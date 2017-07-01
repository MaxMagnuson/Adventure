/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileReaders;

import Maps.IMap;
import Maps.OverworldMap;
import Maps.Tiles.ITile;
import Maps.Tiles.TileFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author MaxM
 */
public class FileToMap {
    
    public static IMap FileToMap(String path) throws FileNotFoundException
    {
       File file = new File(path);
       Scanner scanner = new Scanner(file);
       String[] dimLine = scanner.nextLine().split(" ");
       if(dimLine.length != 2)
       {
           //Todo: error out or something
       }
       int xDim = Integer.parseInt(dimLine[0]);
       int yDim = Integer.parseInt(dimLine[1]);
       
       ITile[][] grid = new ITile[xDim][yDim];
       int y = 0;
       while(scanner.hasNextLine())
       {
           String[] currentLine = scanner.nextLine().split(" ");
           for(int x = 0; x < currentLine.length; x++)
           {
               ITile currentTile = TileFactory.TileMap(currentLine[x]);
               grid[x][y] = currentTile;
           }
           y++;
       }
       
       //Todo: Set Character Position
       OverworldMap map = new OverworldMap();
       map.SetMap(grid);
   
       scanner.close();
       return map;
    }
}
