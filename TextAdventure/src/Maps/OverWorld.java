/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Maps.Tiles.ITile;
import Maps.Tiles.Mountain;
import Maps.Tiles.Plains;
import SharedLibrary.Position;

/**
 *
 * @author MaxM
 */
public class OverWorld extends IMap {
    public OverWorld(int x, int y)
    {
        this.grid = new ITile[10][10];
        this.characterPosition = new Position(x, y);
        this.FillTiles();
    }
    
    void FillTiles()
    {
        for(int x = 0; x < 10; x++)
        {
            this.grid[0][x] = new Mountain();
            this.grid[9][x] = new Mountain();
        }
        for(int y = 1; y < 9; y++)
        {
            this.grid[y][0] = new Mountain();
            for(int x = 1; x < 9; x++)
            {
                this.grid[x][y] = new Plains();
            }
            this.grid[y][9] = new Mountain();
        }
    }
}
