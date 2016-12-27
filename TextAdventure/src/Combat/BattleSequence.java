/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

import Commands.CommandMapFactory;
import Commands.CommandMapFactory.CommandSet;
import Commands.ICommand;
import Creatures.Bat;
import Creatures.ICreature;
import Creatures.Player;
import IO.Prompt;
import Maps.IMap;
import SharedLibrary.NPC;
import SharedLibrary.Position;
import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author xbone
 */
public class BattleSequence {
    private ICreature player;
    private ArrayList<ICreature> enemies;
    private IMap battleMap;
    private Prompt prompt;
    private State state;
    private CommandMapFactory commands;
    
    public BattleSequence(State state)
    {
        this.battleMap = state.GetCurrentMap();
        this.player = state.GetPlayer();
        this.GenerateEnemies();
        this.prompt =  new Prompt();
        this.state = state;
        this.commands = new CommandMapFactory(CommandSet.COMBAT);
    }
    
    public void Start()
    {
        PriorityQueue queue = new PriorityQueue();
        Position playerPosition = new Position(2, 4);
        queue.Put(new BattlePriority(this.player));
        this.battleMap.MoveCreature(this.player, null, playerPosition);
        for(int i = 0; i < this.enemies.size(); i++)
        {
            queue.Put(new BattlePriority(this.enemies.get(i)));
        }
        
        while(!queue.AllDeadButHero())
        {
            BattlePriority current = queue.Next();
            ICreature currentCreature = current.Creature();
            if(!currentCreature.IsDead())
            {
                // TODO: add error handling
                if(currentCreature instanceof Player)
                {
                    String mapString = this.battleMap.toString();
                    Prompt prompt = new Prompt();
                    ArrayList<String> messagesToPlayer = new ArrayList<String>();
                    messagesToPlayer.add(mapString);
                    String[] commandInput = prompt.Ask(messagesToPlayer);
                    
                    String[] actions = new String[commandInput.length-1];
                    System.arraycopy(commandInput, 1, actions, 0, actions.length);
                    ICommand command = this.commands.Command(commandInput[0]);
                    ArrayList<String> output = command.Act(actions, this.state);
                    //TODO: Move into IO
                    for(String out : output)
                    {
                        System.out.println(out);
                    }
                }
            }
        }
    }
    
    private void GenerateEnemies()
    {
        this.enemies = new ArrayList<ICreature>();
        ICreature bat = new Bat("Bat One");
        this.enemies.add(bat);
        this.battleMap.AddNPC(new NPC(bat, new Position(2, 2)));
    }
    
    private class PriorityQueue
    {
        private ArrayList<BattlePriority> queue;
        private int index = 0;
        public PriorityQueue()
        {
            this.queue = new ArrayList<BattlePriority>();
        }
        
        public void Put(BattlePriority battleEntity)
        {
            //TODO: Fix this garbage
            for(int i = 0; i < this.queue.size(); i++)
            {
                if(this.queue.get(i).Priority() > battleEntity.priority)
                {
                    this.queue.add(i, battleEntity);
                    return;
                }
            }
            this.queue.add(battleEntity);
        }
        
        public int Size()
        {
            return this.queue.size();
        }
        
        public boolean AllDeadButHero()
        {
            int dead = 0;
            for(int i = 0; i < this.queue.size(); i++)
            {
                if(this.queue.get(i).Creature().IsDead())
                {
                    dead++;
                }
            }
            return this.queue.size() - dead == 1;
        }
        
        public BattlePriority Next()
        {
            BattlePriority next = this.queue.get(this.index);
            this.index = (this.index + 1) % this.queue.size();
            return next;
        }
    }
    
    private class BattlePriority
    {
        private int priority;
        private ICreature creature;
        public BattlePriority(ICreature creature)
        {
            this.creature = creature;
            this.priority = creature.Speed();
        }
        
        public int Priority()
        {
            return this.priority;
        }
        
        public ICreature Creature()
        {
            return this.creature;
        }
    }
}
