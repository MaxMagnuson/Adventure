/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedLibrary;

import Creatures.ICreature;

/**
 *
 * @author MaxM
 */
public class NPC {
    private ICreature creature;
    private Position position;
    public NPC(ICreature creature, Position position)
    {
        this.creature = creature;
        this.position = position;
    }
    
    public ICreature Creature()
    {
        return this.creature;
    }
    
    public Position Position()
    {
        return this.position;
    }
    
    public void SetPosition(int x, int y)
    {
        this.position = new Position(x, y);
    }
}
