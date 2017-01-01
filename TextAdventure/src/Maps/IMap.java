/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Creatures.ICreature;
import IO.MapDescription;
import Maps.Tiles.ITile;
import SharedLibrary.NPC;
import SharedLibrary.Position;
import java.util.ArrayList;
/**
 *
 * @author MaxM
 */
public abstract class IMap {
    protected Position characterPosition;
    protected ITile[][] grid;
    abstract void FillTiles();
    protected ArrayList<NPC> npcs;
    
    /* Should probably be consolidated with MoveCreature at some point */
    public void SetCharacterPosition(int x, int y)
    {
        ITile target = this.grid[x][y];
        if(!target.Occupied())
        {
            ITile originalTile = this.grid[this.characterPosition.X()][this.CharacterPosition().Y()];
            ICreature character = originalTile.CreatureInTile();
            originalTile.UnoccupyTile();
            this.characterPosition.SetX(x);
            this.characterPosition.SetY(y);
            target.SetCreature(character);
        }
    }
    
    public Position CharacterPosition()
    {
        return this.characterPosition;
    }
    
    /* Moves creature from original position to target position. Pass null if creature is not already on the map. */
    public void MoveCreature(ICreature creature, Position original, Position target)
    {
        ITile targetTile = this.grid[target.X()][target.Y()];
        if(!targetTile.Occupied())
        {
            if(original != null)
            {
                this.grid[original.X()][original.Y()].UnoccupyTile();
            }
            this.grid[target.X()][target.Y()].SetCreature(creature);
            this.UpdateNPCPosition(creature, target);
        }
    }
    
    private void UpdateNPCPosition(ICreature creature, Position newPos)
    {
        NPC current = this.GetNPC(creature);
        if(current != null)
        {
            current.SetPosition(newPos.X(), newPos.Y());
        }
    }
    
    private NPC GetNPC(ICreature creature)
    {
        for(int i = 0; i < this.npcs.size(); i++)
        {
            NPC current = this.npcs.get(i);
            if(current.Creature().equals(creature))
            {
                return current;
            }
        }
        return null;
    }
    
    public void AddNPC(NPC npc)
    {
        if(!ContainsNPC(npc))
        {
            this.npcs.add(npc);
            this.MoveCreature(npc.Creature(), null, npc.Position());
        }
    }
    
    public ICreature GetNPC(Position pos)
    {
        if(grid[pos.X()][pos.Y()].Occupied())
        {
            return grid[pos.X()][pos.Y()].CreatureInTile();
        }
        return null;
    }
    
    public Position GetNPCPosition(ICreature creature)
    {
        for(int i = 0; i < this.npcs.size(); i++)
        {
            NPC currentNPC = this.npcs.get(i);
            if(currentNPC.Creature().Name().equals(creature.Name()))
            {
                return currentNPC.Position();
            }
        }
        return null;
    }
    
    private boolean ContainsNPC(NPC npc)
    {
        for(int i = 0; i < this.npcs.size(); i++)
        {
            if(this.npcs.get(i).Creature().Name().equals(npc.Creature().Name()))
            {
                return true;
            }
        }
        return false;
    }
    
    public void RemoveNPC(ICreature creature)
    {
        for(int i = 0; i < npcs.size(); i++)
        {
            NPC current = npcs.get(i);
            if(npcs.get(i).Creature().Name().equals(creature.Name()))
            {
                this.grid[current.Position().X()][current.Position().Y()].UnoccupyTile();
                this.npcs.remove(i);
            }
        }
    }
    
    public boolean CanMoveTo(Position position)
    {
        int x = position.X();
        int y = position.Y();
        return this.InBounds(x, y) && this.grid[x][y].HasVisited() && this.grid[x][y].Travelable() && !this.grid[x][y].Occupied();
    }
    
    public boolean TileTravelable(int x, int y)
    {
        return this.grid[x][y].Travelable();
    }
    
    public boolean TileVisited(int x, int y)
    {
        return this.grid[x][y].HasVisited();
    }
    
    public String TileDescription(int x, int y)
    {
        return this.grid[x][y].Description();
    }
    
    public void SetVisited(int x, int y, boolean visited)
    {
        this.grid[x][y].SetVisited(visited);
    }
    
    public boolean InBounds(int x, int y)
    {
        return x >= 0 && x < this.grid.length && y >= 0 && y < this.grid.length;
    }
    
    @Override
    public String toString()
    {
        int padding = this.SetPadding(this.grid);
        MapDescription key = new MapDescription();
        
        //Label x axis
        String mapString = AddPadding(" ", " ", padding) + " ";
        for(int x = 0; x < this.grid.length; x++)
        {
            String nextPart = "" + x;
            nextPart = AddPadding(nextPart, "0", padding);
            nextPart += " ";
            mapString += nextPart;
        }
        mapString += "\r\n";
        
        for(int y = 0; y < this.grid[0].length; y++)
        {
            String line = AddPadding("" + y, "0", padding);
            line += " ";
            for(int x = 0; x < this.grid.length; x++)
            {
                ITile currentTile = this.grid[x][y];
                if(currentTile.Occupied())
                {
                    line += AddPadding(currentTile.CreatureInTile().GraphicalRepresentation(), " ", padding);
                }
                else if(currentTile.HasVisited())
                {
                    String rep = "" + currentTile.GraphicalRepresentation();
                    line +=  AddPadding(rep, " ", padding);
                    key.Put(rep, currentTile.Name());
                }
                else
                {
                    line += AddPadding("*", " ", padding);
                    key.Put("*", "Unknown Territory");
                }
                line += " ";
            }
            line += "\r\n";
            mapString += line;
        }
        mapString += key.toString();
        return mapString;
    }
    
    private String AddPadding(String number, String pad, int paddingCeiling)
    {
        String padded = number;
        while(padded.length() < paddingCeiling)
        {
            padded = pad + padded;
        }
        return padded;
    }
    
    private int SetPadding(ITile[][] grid)
    {
        int paddingCeiling = 1;
        int length = grid.length;
        while(length > 9)
        {
            paddingCeiling++;
            length /= 10;
        }
        return paddingCeiling;
    }
}
