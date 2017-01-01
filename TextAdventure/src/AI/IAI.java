/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import Creatures.ICreature;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public interface IAI {
    void TakeTurn(State state, ICreature creature);
}
