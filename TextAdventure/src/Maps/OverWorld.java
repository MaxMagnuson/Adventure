/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import Creatures.ICreature;
import Maps.Tiles.ITile;
import Maps.Tiles.Mountain;
import Maps.Tiles.Plains;
import SharedLibrary.NPC;
import SharedLibrary.Position;
import java.util.ArrayList;

/**
 *
 * @author MaxM
 */
public class OverWorld extends IMap {
    public OverWorld(int x, int y, ICreature character)
    {
        this.grid = new ITile[10][10];
        this.npcs = new ArrayList<NPC>();
        this.FillTiles();
        this.characterPosition = new Position(x, y);
        this.MoveCreature(character, null, this.characterPosition);
        this.grid[x][y].SetVisited(true);
    }
    
    void FillTiles()
    {
        int xMax = this.grid.length;
        int yMax = this.grid[0].length;
        for(int x = 0; x < xMax; x++)
        {
            this.grid[x][0] = new Mountain();
            this.grid[x][yMax-1] = new Mountain();
        }
        for(int y = 1; y < yMax - 1; y++)
        {
            this.grid[0][y] = new Mountain();
            for(int x = 1; x < xMax - 1; x++)
            {
                this.grid[x][y] = new Plains();
            }
            this.grid[xMax-1][y] = new Mountain();
        }
    }
}
