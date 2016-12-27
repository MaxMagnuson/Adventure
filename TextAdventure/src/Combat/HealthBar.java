/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

/**
 *
 * @author MaxM
 */
public class HealthBar {
    private int minorWounds;
    private int majorWounds;
    private final int minorToMajor;
    private final int majorToDeath;
    private boolean dead;
    public HealthBar(int minorToMajor, int majorToDeath)
    {
        this.minorWounds = 0;
        this.majorWounds = 0;
        this.minorToMajor = minorToMajor;
        this.majorToDeath = majorToDeath;
        this.dead = false;
    }
    
    public void TakeWound(Wound wound)
    {
        if(wound == Wound.MINOR)
        {
            this.minorWounds++;
        }
        else if(wound == Wound.MAJOR)
        {
            this.majorWounds++;
        }
        else
        {
            this.dead = true;
        }
        
        if(minorWounds >= minorToMajor)
        {
            this.minorWounds = 0;
            this.majorWounds++;
        }
        
        if(this.majorWounds >= this.majorToDeath)
        {
            this.dead = true;
        }
    }
    
    public boolean MortallyWounded()
    {
        return this.dead;
    }
    
    public enum Wound
    {
        MINOR, MAJOR, MORTAL
    }
}
