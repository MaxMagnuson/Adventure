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
public class SetFilePath implements ICommand {

    @Override
    public String Description()
    {
        return "Command \"setpath\" sets the file path for any commands that create files.";
    }
    
    @Override
    public ArrayList<String> Act(String[] action, State state) {
        ArrayList<String> messages = new ArrayList<String>();
        
        if(action.length != 1)
        {
           messages.add("SetPath only accepts one path");
           return messages;
        }
        
        state.SetPath(action[0]);
        messages.add("New path has been set.");
        return messages;
    }
    
}
