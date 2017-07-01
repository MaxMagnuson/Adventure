/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps.Tiles;

/**
 *
 * @author MaxM
 */
public class TileFactory {
    
    public static ITile TileMap(String type)
    {
        switch(type)
        {
            case "m":
                return new Mountain();
            case "p":
                return new Plains();
            default:
                return new Mountain();
        }
    }
}
