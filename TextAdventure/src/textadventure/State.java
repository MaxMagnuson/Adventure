/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import Creatures.ICreature;
import Creatures.Player;
import Maps.IMap;
import Maps.OverWorld;

/**
 *
 * @author MaxM
 */
public class State {
    private OverWorld overWorld;
    private IMap currentCharacterMap;
    private ICreature player;
    private String filePath = "D:\\Adventure\\Overworld.txt";
    
    public State()
    {
        this.player = new Player("Unnamed hero");
        this.overWorld = new OverWorld(5, 5, this.player);
        this.currentCharacterMap = this.overWorld;
    }
    
    public State(ICreature player)
    {
        this.player = player;
        this.overWorld = new OverWorld(5, 5, this.player);
        this.currentCharacterMap = this.overWorld;
    }
    
    public IMap GetCurrentMap()
    {
        return this.currentCharacterMap;
    }
    
    public void SetCurrentMap(IMap map)
    {
        this.currentCharacterMap = map;
    }
    
    public ICreature GetPlayer()
    {
        return this.player;
    }
    
    public String FilePath()
    {
        return this.filePath;
    }
}
