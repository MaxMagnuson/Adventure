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
public class OpenBattleTile extends ITile {
    public OpenBattleTile()
    {
        this.travelable = true;
        this.description = "";
        this.representation = ' ';
        this.name = "Floor";
        this.creature = null;
        this.visited = true;
    }
}
