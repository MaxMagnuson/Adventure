/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textadventure;

import Maps.IMap;
import Maps.OverWorld;
import SharedLibrary.Position;

/**
 *
 * @author MaxM
 */
public class State {
    private OverWorld overWorld;
    private IMap currentCharacterMap;
    
    public State()
    {
        this.overWorld = new OverWorld(5, 5);
        this.currentCharacterMap = this.overWorld;
    }
    
    public void SetCharacterPosition(int x, int y)
    {
        this.currentCharacterMap.SetCharacterPosition(x, y);
    }
    
    public IMap GetCurrentMap()
    {
        return this.currentCharacterMap;
    }
    
    public Position GetCharacterPosition()
    {
        return this.currentCharacterMap.CharacterPosition();
    }
}
