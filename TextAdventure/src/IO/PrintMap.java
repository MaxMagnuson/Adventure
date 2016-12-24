/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Maps.Tiles.ITile;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MaxM
 */
public class PrintMap {
    private int paddingCeiling = 2;
    private MapDescription key;
    public void WriteMap(ITile[][] map, int characterX, int characterY) throws IOException
    {
        this.SetPadding(map);
        this.key = new MapDescription();
        
        //Label x axis
        FileWriter writer = new FileWriter("D:\\Adventure\\Overworld.txt");
        String line = AddPadding(" ", " ") + " ";
        for(int x = 0; x < map.length; x++)
        {
            String nextPart = "" + x;
            nextPart = AddPadding(nextPart, "0");
            nextPart += " ";
            line += nextPart;
        }
        line += "\r\n";
        writer.write(line);
        
        for(int y = 0; y < map[0].length; y++)
        {
            line = AddPadding("" + y, "0");
            line += " ";
            for(int x = 0; x < map.length; x++)
            {
                if(x == characterX && y == characterY)
                {
                    line += AddPadding("c", " ");
                }
                else if(map[x][y].HasVisited())
                {
                    String rep = "" + map[x][y].GraphicalRepresentation();
                    line +=  AddPadding(rep, " ");
                    this.key.Put(rep, map[x][y].Name());
                }
                else
                {
                    line += AddPadding("*", " ");
                    this.key.Put("*", "Unknown Territory");
                }
                line += " ";
            }
            line += "\r\n";
            writer.write(line);
        }
        writer.write(this.key.toString());
        writer.close();
    }
    
    private String AddPadding(String number, String pad)
    {
        String padded = number;
        while(padded.length() < this.paddingCeiling)
        {
            padded = pad + padded;
        }
        return padded;
    }
    
    private void SetPadding(ITile[][] grid)
    {
        this.paddingCeiling = 1;
        int length = grid.length;
        while(length > 9)
        {
            this.paddingCeiling++;
            length /= 10;
        }
    }
}
