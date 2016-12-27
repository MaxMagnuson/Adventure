/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

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
    }
    
    public CommandMapFactory(CommandSet set)
    {
        this.commandMap = new HashMap<String, ICommand>();
        if(set == CommandSet.OVERWORLD)
        {
           this.commandMap.put("print", new Print()); 
        }
        else if(set == CommandSet.COMBAT)
        {
            this.commandMap.put("attack", new Attack());
        }
        this.commandMap.put("walk", new Walk());
        this.commandMap.put("travel", new Travel());
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
}
