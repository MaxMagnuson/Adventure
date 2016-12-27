/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import IO.PrintFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class Print implements ICommand {
    
    @Override
    public ArrayList<String> Act(String[] action, State state) {
        try {
            String mapString = state.GetCurrentMap().toString();
            PrintFile printer = new PrintFile();
            printer.Print(mapString, state.FilePath());
        } catch (IOException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> output = new ArrayList<String>();
        output.add("Map successfully printed!");
        return output;
    }
}
