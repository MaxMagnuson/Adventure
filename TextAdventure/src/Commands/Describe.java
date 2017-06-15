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
public class Describe implements ICommand {

    @Override
    public ArrayList<String> Act(String[] action, State state) {
        ICommand command = state.GetCommands().Command(action[0]);
        ArrayList<String> description = new ArrayList<String>();
        description.add(command.Description());
        return description;
    }

    @Override
    public String Description() {
        return "Command \"!describe\" returns the description of the given command.";
    }
    
}
