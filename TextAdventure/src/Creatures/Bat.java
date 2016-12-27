/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creatures;

import Combat.HealthBar;

/**
 *
 * @author MaxM
 */
public class Bat extends ICreature {
    public Bat(String name)
    {
        this.name = name;
        this.graphicalRepresentation = "b";
        this.minorToMajor = 2;
        this.majorToMortal = 1;
        this.health = new HealthBar(this.minorToMajor, this.majorToMortal);
        this.speed = 1;
    }
}
