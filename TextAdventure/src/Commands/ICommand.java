/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public interface ICommand {
    ArrayList<String> Act(String[] action, State state);
    String Description();
}
