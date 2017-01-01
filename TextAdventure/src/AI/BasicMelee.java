/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import Creatures.ICreature;
import Maps.IMap;
import SharedLibrary.Position;
import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class BasicMelee implements IAI {

    @Override
    public void TakeTurn(State state, ICreature creature) {
        IMap map = state.GetCurrentMap();
        Position playerPos = map.CharacterPosition();
        Position creaturePos = map.GetNPCPosition(creature);
        
        Position newCreaturePos = null;
        if(creaturePos.Adjacent(playerPos))
        {
            //TODO: Attack
        }
        else
        {
            newCreaturePos = this.Move(map, creature, playerPos, creature.Speed());
            if(newCreaturePos.Adjacent(playerPos))
            {
                //TODO: Attack
            }
            else
            {
                //Use Second Action to Move
                if(newCreaturePos != null)
                {
                    map.MoveCreature(creature, newCreaturePos, creaturePos);
                    Move(map, creature, playerPos, creature.Speed() * 2);
                }
            }
        }
    }
    
    private Position Move(IMap map, ICreature creature, Position playerPos, int speed)
    {
        Position creaturePos = map.GetNPCPosition(creature);
        ArrayList<Position> possibleMoves = SharedLibrary.SharedMethods.PossibleMoves(map, creaturePos, speed);
        
        Position closestToPlayer = null;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < possibleMoves.size(); i++)
        {
            Position current = possibleMoves.get(i);
            int distance = current.ManhattanDist(playerPos);
            if(distance < closest)
            {
                closest = distance;
                closestToPlayer = current;
            }
        }
        
        if(closestToPlayer != null)
        {
            map.MoveCreature(creature, creaturePos, closestToPlayer);
        }
        return closestToPlayer;
    }
}
