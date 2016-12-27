/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat.Weapons;

import Combat.HealthBar.Wound;
import SharedLibrary.Position;
import java.util.ArrayList;

/**
 *
 * @author MaxM
 */
public class Dagger implements IWeapon {
    private ArrayList<Position> attackCoordinates;
    private String name;
    public Dagger()
    {
        this.attackCoordinates = new ArrayList<Position>();
        this.SetCoordinates();
        this.name = "Dagger";
    }
    
    @Override
    public ArrayList<Position> AttackCoordinates() {
        return this.attackCoordinates;
    }
    
    private void SetCoordinates()
    {
        this.attackCoordinates.add(new Position(0, 1));
    }

    @Override
    public Wound Damage()
    {
       return Wound.MINOR; 
    }
    
    @Override
    public String Name() {
        return this.name;
    }
    
}
