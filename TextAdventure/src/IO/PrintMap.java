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
    public void WriteMap(ITile[][] map) throws IOException
    {
        FileWriter writer = new FileWriter("C:\\Users\\MaxM\\Documents\\GitHub\\Adventure\\Overworld.txt");
        String line = "   ";
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
                if(map[x][y].HasVisited())
                {
                    line += " " + map[x][y].GraphicalRepresentation() + " ";
                }
                else
                {
                    line += "   ";
                }
            }
            line += "\r\n";
            writer.write(line);
        }
        writer.close();
    }
    
    private String AddPadding(String number, String pad)
    {
        if(number.length() < 2)
        {
            return pad + number;
        }
        return number;
    }
}
