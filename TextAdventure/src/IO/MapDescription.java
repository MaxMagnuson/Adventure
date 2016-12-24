/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.ArrayList;

/**
 *
 * @author xbone
 */
public class MapDescription {
    private ArrayList<Description> descriptions;
    public MapDescription()
    {
        this.descriptions = new ArrayList<Description>();
        this.Put("c", "You");
    }
    
    public void Put(String key, String description)
    {
        if(!this.ContainsKey(key))
        {
            this.descriptions.add(new Description(key, description));
        }
    }
    
    public boolean ContainsKey(String key)
    {
        for(int i = 0; i < this.descriptions.size(); i++)
        {
            if(this.descriptions.get(i).GetKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        String result = "\r\nKey:\r\n";
        for(int i = 0; i < this.descriptions.size(); i++)
        {
            result += this.descriptions.get(i).toString();
        }
        return result;
    }
    
    private class Description
    {
        private String key;
        private String description;
        Description(String key, String description)
        {
            this.key = key;
            this.description = description;
        }
        
        public String GetKey()
        {
            return this.key;
        }
        
        @Override
        public String toString()
        {
            return this.key + " => " + description + "\r\n";
        }
    }
}
