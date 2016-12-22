/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedLibrary;

/**
 *
 * @author MaxM
 */
public class Position {
    private int x;
    private int y;
    
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public boolean SamePosition(Position pos)
    {
        return this.x == pos.X() && this.y == pos.Y();
    }
    
    public void SetX(int x)
    {
        this.x = x;
    }
    
    public void SetY(int y)
    {
        this.y = y;
    }
    
    public int X()
    {
        return this.x;
    }
    
    public int Y()
    {
        return this.y;
    }
}
