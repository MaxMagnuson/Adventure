/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creatures;

import Combat.HealthBar;
import Combat.Weapons.IWeapon;

/**
 *
 * @author MaxM
 */
public abstract class ICreature {
    protected String name;
    protected IWeapon weapon;
    
    //Stats
    protected int minorToMajor;
    protected int majorToMortal;
    protected HealthBar health;
    protected int speed;
    public String Name()
    {
        return this.name;
    }
    
    protected String graphicalRepresentation;
    public String GraphicalRepresentation()
    {
        return this.graphicalRepresentation;
    }
    
    public HealthBar Health()
    {
        return this.health;
    }
    
    public int Speed()
    {
        return this.speed;
    }
    
    public void EquipWeapon(IWeapon weapon)
    {
        this.weapon = weapon;
    }
    
    public IWeapon Weapon()
    {
        return this.weapon;
    }
    
    private boolean dead = false;
    public boolean IsDead()
    {
        return this.dead;
    }
    
    private void SetDeath(boolean dead)
    {
        this.dead = dead;
    }
}
