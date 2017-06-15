/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MaxM
 */
public class CommandMapFactory {
    private HashMap<String, ICommand> commandMap;
    
    public CommandMapFactory()
    {
        this.commandMap = new HashMap<String, ICommand>();
        this.commandMap.put("walk", new Walk());
        this.commandMap.put("print", new Print());
        this.commandMap.put("travel", new Travel());
        this.commandMap.put("!commands", new Commands());
        this.commandMap.put("!describe", new Describe());
    }
    
    public CommandMapFactory(CommandSet set)
    {
        this.commandMap = new HashMap<String, ICommand>();
        if(set == CommandSet.OVERWORLD)
        {
           this.commandMap.put("print", new Print());
           this.commandMap.put("!setpath", new SetFilePath());
        }
        else if(set == CommandSet.COMBAT)
        {
            this.commandMap.put("attack", new Attack());
        }
        this.commandMap.put("walk", new Walk());
        this.commandMap.put("travel", new Travel());
        this.commandMap.put("!commands", new Commands());
        this.commandMap.put("!describe", new Describe());
    }
    
    public ICommand Command(String key)
    {
        if(this.commandMap.containsKey(key))
        {
            return this.commandMap.get(key);
        }
        return null;
    }
    
    public enum CommandSet
    {
        COMBAT, OVERWORLD
    }
    
    public ArrayList<String> AvailableCommands()
    {
        Object[] commands = this.commandMap.keySet().toArray();
        ArrayList<String> listOfCommands = new ArrayList<String>();
        for(int i = 0; i < commands.length; i++)
        {
            String current = commands[i].toString();
            listOfCommands.add(current);
        }
        return listOfCommands;
    }
}
