/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creatures;

import AI.BasicMelee;
import AI.IAI;
import Combat.HealthBar;
import Combat.Weapons.Dagger;

/**
 *
 * @author MaxM
 */
public class Bat extends ICreature implements IEnemy {
    public Bat(String name)
    {
        this.name = name;
        this.graphicalRepresentation = "b";
        this.minorToMajor = 2;
        this.majorToMortal = 1;
        this.health = new HealthBar(this.minorToMajor, this.majorToMortal);
        this.speed = 1;
        this.ai = new BasicMelee();
        this.weapon = new Dagger();
    }

    private IAI ai;
    @Override
    public IAI AI() {
        return this.ai;
    }
}
