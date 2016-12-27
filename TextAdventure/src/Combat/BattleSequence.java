/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

import Creatures.Bat;
import Creatures.ICreature;
import Creatures.Player;
import IO.Prompt;
import Maps.IMap;
import SharedLibrary.NPC;
import SharedLibrary.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author xbone
 */
public class BattleSequence {
    private Player player;
    private ArrayList<ICreature> enemies;
    private IMap battleMap;
    private Prompt prompt;
    
    public BattleSequence(IMap battleMap, Player player)
    {
        this.battleMap = battleMap;
        this.player = player;
        this.GenerateEnemies();
        this.prompt =  new Prompt();
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
                if(currentCreature instanceof Player)
                {
                    String mapString = this.battleMap.toString();
                    Prompt prompt = new Prompt();
                    ArrayList<String> messagesToPlayer = new ArrayList<String>();
                    messagesToPlayer.add(mapString);
                    prompt.Ask(messagesToPlayer);
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
