/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import Combat.BattleSequence;
import Commands.CommandMapFactory;
import Commands.CommandMapFactory.CommandSet;
import Commands.ICommand;
import Creatures.ICreature;
import Creatures.Player;
import static FileReaders.FileToMap.FileToMap;
import IO.ConsoleHandler;
import Maps.GenericBattleMap;
import Maps.IMap;
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
        
        String path = "C:\\Users\\MaxM\\Desktop\\TestMap.txt";
        IMap map = FileToMap(path);
        for(int x = 0; x < 6; x++)
        {
            for(int y = 0; y < 5; y++)
            {
                map.SetVisited(x, y, true);
            }
        }
        System.out.println(map.toString());
        
        /*
        Scanner scan = new Scanner(System.in);
        CommandMapFactory commandMap = new CommandMapFactory(CommandSet.OVERWORLD);
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
        */
        
        /*
        GenericBattleMap map = new GenericBattleMap();
        ICreature player = new Player("Unnamed Hero");
        State state = new State(player);
        state.SetCurrentMap(map);
        BattleSequence sequence = new BattleSequence(state);
        sequence.Start();
        */
    }
    
}
