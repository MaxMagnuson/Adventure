/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Maps.Tiles.ITile;
import Maps.Tiles.Mountain;
import SharedLibrary.Position;

/**
 *
 * @author MaxM
 */
public class TransitionMapTest extends IMap {

    public TransitionMapTest()
    {
        this.grid = new ITile[4][4];
        this.FillTiles();
        this.characterPosition = new Position(1, 1);
    }
    
    private void FillTiles() {
        for(int i = 0; i < 4; i++)
        {
            this.grid[0][i] = new Mountain();
            this.grid[3][i] = new Mountain();
        }
        
    }
    
}
