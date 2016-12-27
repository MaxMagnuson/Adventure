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
 * @author xbone
 */
public interface IWeapon {
    ArrayList<Position> AttackCoordinates();
    String Name();
    Wound Damage();
}
