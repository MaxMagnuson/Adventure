/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Commands.CommandMapFactory;
import Commands.ICommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class ConsoleHandler implements IIOHandler {
    private Scanner scan;
    public ConsoleHandler()
    {
        this.scan = new Scanner(System.in);
    }
    
    public void Start()
    {
        CommandMapFactory commandMap = new CommandMapFactory();
        State state = new State();
        while(true)
        {
            String input = this.scan.nextLine();
            input = input.toLowerCase();
            System.out.print("Input: " + input);
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
