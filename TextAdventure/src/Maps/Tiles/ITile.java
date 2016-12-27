/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps.Tiles;

import Creatures.ICreature;

/**
 *
 * @author MaxM
 */
public abstract class ITile {
    protected boolean travelable;
    public boolean Travelable()
    {
        return this.travelable;
    }
    
    protected String description;
    public String Description()
    {
        return this.description;
    }
    
    protected boolean visited = false;
    public void SetVisited(boolean visited)
    {
        this.visited = visited;
    }
    
    public boolean HasVisited()
    {
        return this.visited;
    }
    
    protected char representation;
    public char GraphicalRepresentation()
    {
        return this.representation;
    }
    
    protected String name;
    public String Name()
    {
        return this.name;
    }
    
    protected ICreature creature;
    public ICreature CreatureInTile()
    {
        return this.creature;
    }
    
    public void SetCreature(ICreature creature)
    {
        this.creature = creature;
    }
    
    public boolean Occupied()
    {
        return this.creature != null;
    }
    
    public void UnoccupyTile()
    {
        this.creature = null;
    }
}
