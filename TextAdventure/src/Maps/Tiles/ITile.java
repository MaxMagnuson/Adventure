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
public abstract class ITile {
    protected boolean travelable;
    public boolean Travelable()
    {
        return this.travelable;
    }
    
    protected String description;
    public String Description()
    {
        return this.description;
    }
}
