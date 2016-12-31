/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedLibrary;

import Maps.IMap;
import java.util.ArrayList;

/**
 *
 * @author MaxM
 */
public class SharedMethods {
    public static ArrayList<Position> PossibleMoves(IMap map, Position creaturePos, int speed)
    {
        ArrayList<Position> possibleMoves = new ArrayList<Position>();
        ArrayList<Position> nodes = new ArrayList<Position>();
        nodes.add(creaturePos);
        
        while(!nodes.isEmpty())
        {
            Position current = nodes.remove(0);
            ArrayList<Position> potentialMoves = new ArrayList<Position>();
            for(int i = -1; i < 2; i+=2)
            {
                potentialMoves.add(new Position(current.X() + i, current.Y()));
                potentialMoves.add(new Position(current.X(), current.Y() + i));
            }
            for(int i = 0; i < potentialMoves.size(); i++)
            {
                Position currentPotential = potentialMoves.get(i);
                if(map.CanMoveTo(currentPotential) && currentPotential.ManhattanDist(creaturePos) <= speed)
                {
                    if(!Contains(possibleMoves, currentPotential))
                    {
                        possibleMoves.add(currentPotential);
                        if(!Contains(nodes, currentPotential))
                        {
                            nodes.add(currentPotential);
                        }
                    }
                }
            }
        }
        
        return possibleMoves;
    }
    
    public static boolean Contains(ArrayList<Position> positions, Position position)
    {
        for(int i = 0; i < positions.size(); i++)
        {
            Position current = positions.get(i);
            if(position.SamePosition(current))
            {
                return true;
            }
        }
        return false;
    }
    
    public static Position Remove(ArrayList<Position> positions, Position position)
    {
        for(int i = 0; i < positions.size(); i++)
        {
            Position current = positions.get(i);
            if(position.equals(current))
            {
                positions.remove(i);
                return current;
            }
        }
        return null;
    }
}
