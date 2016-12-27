/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Maps.IMap;
import Maps.Tiles.ITile;
import SharedLibrary.Position;
import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class Travel implements ICommand {

    @Override
    public ArrayList<String> Act(String[] action, State state) {
        ArrayList<String> output = new ArrayList<String>();
        if(action.length != 2)
        {
            output.add("command \"travel\" must be followed by two integers");
            return output;
        }
        
        int destX;
        int destY;
        try
        {
           destX = Integer.parseInt(action[0]);
           destY = Integer.parseInt(action[1]);
        }
        catch(Exception ex)
        {
            output.add("Position values must be integers");
            return output;
        }
        
        IMap currentMap = state.GetCurrentMap();
        boolean possible = FindPath(currentMap, new Position(destX, destY));
        
        if(possible)
        {
            currentMap.SetCharacterPosition(destX, destY);
            output.add("You successfully traveled to coordinate (" + destX + ", " + destY + ")");
            output.add(currentMap.TileDescription(destX, destY));
        }
        else
        {
            output.add("You cannot travel to coordinate (" + destX + ", " + destY + ")");
        }
        
        return output;
    }
    
    private boolean FindPath(IMap map, Position destination)
    {
        if(!CanTravelTo(map, destination.X(), destination.Y()))
        {
            return false;
        }
        
        PositionList queue = new PositionList();
        queue.Add(map.CharacterPosition());
        PositionList visited = new PositionList();
        while(!queue.IsEmpty())
        {
            Position next = queue.DeQueue(destination);
            ArrayList<Position> neighbors = ViableNeighbors(map, visited, next);
            for(int i = 0; i < neighbors.size(); i++)
            {
                Position neighbor = neighbors.get(i);
                if(neighbor.equals(destination))
                {
                    return true;
                }
                else if(!visited.contains(neighbor))
                {
                    queue.Add(neighbor);
                }
            }
            visited.Add(next);
        }
        return false;
    }
    
    private ArrayList<Position> ViableNeighbors(IMap map, PositionList visited, Position center)
    {
        ArrayList<Position> neighbors = new ArrayList<Position>();
        int centerX = center.X();
        int centerY = center.Y();
        if(CanTravelTo(map, centerX - 1, centerY))
        {
            AddNeighbor(visited, neighbors, centerX - 1, centerY);
        }
        if(CanTravelTo(map, centerX + 1, centerY))
        {
            AddNeighbor(visited, neighbors, centerX + 1, centerY);
        }
        if(CanTravelTo(map, centerX, centerY - 1))
        {
            AddNeighbor(visited, neighbors, centerX, centerY - 1);
        }
        if(CanTravelTo(map, centerX, centerY + 1))
        {
            AddNeighbor(visited, neighbors, centerX, centerY + 1);
        }
        return neighbors;
    }
    
    private boolean CanTravelTo(IMap map, int x, int y)
    {
        return map.InBounds(x, y) && map.TileTravelable(x, y) && map.TileVisited(x, y);
    }
    
    private void AddNeighbor(PositionList visited, ArrayList<Position> neighbors, int x, int y)
    {
        Position neighbor = new Position(x, y);
        if(!visited.contains(neighbor))
        {
            neighbors.add(neighbor);
        }
    }
    
    private class PositionList
    {
        private ArrayList<Position> positions;
        public PositionList()
        {
            this.positions = new ArrayList<Position>();
        }
        
        public void Add(Position pos)
        {
            if(!this.contains(pos))
            {
                this.positions.add(pos);
            }
        }
        
        public boolean contains(Position diff)
        {
            for(int i = 0; i < positions.size(); i++)
            {
                if(this.positions.get(i).equals(diff))
                {
                    return true;
                }
            }
            return false;
        }
        
        public Position DeQueue(Position destination)
        {
            int bestIndex = 0;
            Position currentBest = this.positions.get(0);
            int bestDist = currentBest.ManhattanDist(destination);
            for(int i = 1; i < this.positions.size(); i++)
            {
                Position temp = this.positions.get(i);
                int manhatdis = temp.ManhattanDist(destination);
                if(manhatdis < bestDist)
                {
                    bestIndex = i;
                    currentBest = temp;
                    bestDist = manhatdis;
                }
            }
            this.positions.remove(bestIndex);
            return currentBest;
        }
        
        public boolean IsEmpty()
        {
            return this.positions.size() == 0;
        }
    }
}
