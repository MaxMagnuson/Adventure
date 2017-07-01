/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Maps.Tiles.ITile;
import Maps.Tiles.OpenBattleTile;
import SharedLibrary.NPC;
import SharedLibrary.Position;
import java.util.ArrayList;

/**
 *
 * @author MaxM
 */
public class GenericBattleMap extends IMap {

    public GenericBattleMap()
    {
        this.grid = new ITile[5][5];
        this.npcs = new ArrayList<NPC>();
        this.FillTiles();
        this.characterPosition = new Position(2, 4);
    }
            
    private void FillTiles() 
    {
        for(int x = 0; x < this.grid.length; x++)
        {
            for(int y = 0; y < this.grid[x].length; y++)
            {
                this.grid[x][y] = new OpenBattleTile();
            }
        }
    }
    
}
