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
    }
    
    public ICommand Command(String key)
    {
        if(this.commandMap.containsKey(key))
        {
            return this.commandMap.get(key);
        }
        return null;
    }
}
