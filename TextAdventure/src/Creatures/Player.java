/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creatures;

import Combat.Weapons.Dagger;

/**
 *
 * @author MaxM
 */
public class Player extends ICreature {
    public Player(String name)
    {
        this.name = name;
        this.graphicalRepresentation = "C";
        this.EquipWeapon(new Dagger());
        this.minorToMajor = 3;
        this.majorToMortal = 2;
        this.speed = 2;
    }
}
