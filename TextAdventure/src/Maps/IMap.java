/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import IO.PrintMap;
import Maps.Tiles.ITile;
import SharedLibrary.Position;
import java.io.IOException;
/**
 *
 * @author MaxM
 */
public abstract class IMap {
    protected Position characterPosition;
    protected ITile[][] grid;
    abstract void FillTiles();
    
    public void SetCharacterPosition(int x, int y)
    {
        this.characterPosition.SetX(x);
        this.characterPosition.SetY(y);
    }
    
    public Position CharacterPosition()
    {
        return this.characterPosition;
    }
    
    public boolean TileTravelable(int x, int y)
    {
        return this.grid[x][y].Travelable();
    }
    
    public String TileDescription(int x, int y)
    {
        return this.grid[x][y].Description();
    }
    
    public void SetVisited(int x, int y, boolean visited)
    {
        this.grid[x][y].SetVisited(visited);
    }
    
    public void PrintMap() throws IOException
    {
        PrintMap printer = new PrintMap();
        printer.WriteMap(this.grid);
    }
}
