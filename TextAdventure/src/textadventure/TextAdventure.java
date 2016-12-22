/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import Commands.CommandMapFactory;
import Commands.ICommand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MaxM
 */
public class TextAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //ConsoleHandler handler = new ConsoleHandler();
        //handler.Start();
        Scanner scan = new Scanner(System.in);
        CommandMapFactory commandMap = new CommandMapFactory();
        State state = new State();
        while(true)
        {
            String input = scan.nextLine();
            input = input.toLowerCase();
            String[] inputTokens = input.split(" ");
            ICommand command = commandMap.Command(inputTokens[0]);
            if(command == null)
            {
                System.out.print(SharedLibrary.Constants.UndefinedCommand);
            }
            else
            {
                String[] actions = new String[inputTokens.length-1];
                System.arraycopy(inputTokens, 1, actions, 0, actions.length);

                ArrayList<String> consoleOutput = command.Act(actions, state);
                for(String output : consoleOutput)
                {
                    System.out.println(output);
                }
            }
        }
    }
    
}
