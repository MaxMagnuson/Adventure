/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Maps.IMap;
import SharedLibrary.Position;
import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class Walk implements ICommand {
    private IMap overworld;
    
    @Override
    public String Description()
    {
        return "Command \"walk\" takes in a coordinate direction and attempts to"
                + " move the player one space in that direction.";
    }
    
    public ArrayList<String> Act(String[] action, State state)
    {
        ArrayList<String> output = new ArrayList<String>();
        
        if(action.length != 1)
        {
            output.add("command \"walk\" must be followed by north, south, east, or west");
            return output;
        }
        String direction = action[0];
        IMap currentMap = state.GetCurrentMap();
        Position characterPosition = currentMap.CharacterPosition();
        int x = characterPosition.X();
        int y = characterPosition.Y();
        switch(direction)
        {
            case "north":
                y--;
                break;
            case "south":
                y++;
                break;
            case "west":
                x--;
                break;
            case "east":
                x++;
                break;
            default:
                output.add(SharedLibrary.Constants.UndefinedCommand);
                return output;
        }
        if(currentMap.TileTravelable(x, y))
        {
            currentMap.SetCharacterPosition(x, y);
            output.add(this.Successful(direction));
        }
        else
        {
            output.add("You are too feeble to travel in that direction.");
        }
        currentMap.SetVisited(x, y, true);
        output.add(state.GetCurrentMap().TileDescription(x, y));
        return output;
    }
    
    private String Successful(String direction)
    {
        return "You successfully moved " + direction + ".";
    }
}
