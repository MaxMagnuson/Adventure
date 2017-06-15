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
public class Commands implements ICommand {

    @Override
    public ArrayList<String> Act(String[] action, State state){ 
        ArrayList<String> commands = state.GetCommands().AvailableCommands(); 
        commands.add(0, "List of Commands:");
        return commands;
    }

    @Override
    public String Description() {
        return "Command \"!commands\" prints out the list of available commands.";
    }
    
}
