/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Maps.Tiles.ITile;

/**
 *
 * @author MaxM
 */
public class OverworldMap extends IMap {
    
    public void SetMap(ITile[][] grid)
    {
        this.grid = grid;
    }
}
