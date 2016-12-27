/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Combat.Weapons.IWeapon;
import Creatures.ICreature;
import Maps.IMap;
import SharedLibrary.Position;
import java.util.ArrayList;
import textadventure.State;

/**
 *
 * @author MaxM
 */
public class Attack implements ICommand {
    private final String errorMsg = "command \"attack\" must be followed by only north, south, east, or west";
    
    @Override
    public ArrayList<String> Act(String[] action, State state) {
        ArrayList<String> output = new ArrayList<String>();
        if(action.length != 1)
        {
            output.add("errorMsg");
            return output;
        }
        
        int[][] transformation = new int[2][2];
        switch(action[0])
        {
            case "north":
                transformation[0][0] = 1;
                transformation[1][0] = 0;
                transformation[0][1] = 0;
                transformation[1][1] = 1;
                break;
            case "south":
                transformation[0][0] = -1;
                transformation[1][0] = 0;
                transformation[0][1] = 0;
                transformation[1][1] = -1;
                break;
            case "west":
                transformation[0][0] = 0;
                transformation[1][0] = -1;
                transformation[0][1] = 1;
                transformation[1][1] = 0;
                break;
            case "east":
                transformation[0][0] = 0;
                transformation[1][0] = 1;
                transformation[0][1] = -1;
                transformation[1][1] = 0;
                break;
            default:
                output.add(errorMsg);
                return output;
        }
        
        IWeapon characterWeapon = state.GetPlayer().Weapon();
        ArrayList<Position> attackCoords = TransformPositions(characterWeapon.AttackCoordinates(), transformation);
        IMap currentMap = state.GetCurrentMap();
        int characterX = currentMap.CharacterPosition().X();
        int characterY = currentMap.CharacterPosition().Y();
        boolean inflictedWound = false;
        for(int i = 0; i < attackCoords.size(); i++)
        {
            Position currentPos = attackCoords.get(i);
            int attackX = characterX + currentPos.X();
            int attackY = characterY - currentPos.Y();
            if(currentMap.InBounds(attackX, attackY))
            {
                ICreature monster = currentMap.GetNPC(new Position(attackX, attackY));
                if(monster != null)
                {
                    monster.Health().TakeWound(characterWeapon.Damage());
                    output.add("You inflicted " + monster.Name() + " with a " + characterWeapon.Damage().toString().toLowerCase() + " wound");
                    inflictedWound = true;
                    if(monster.Health().MortallyWounded())
                    {
                        output.add(monster.Name() + " has been mortally wounded");
                    }
                }
            }
        }
        if(!inflictedWound)
        {
            output.add("There is no one in the squares of your attack.");
        }
        return output;
    }
    
    
    private ArrayList<Position> TransformPositions(ArrayList<Position> positions, int[][] transform)
    {
        ArrayList<Position> transformedPositions = new ArrayList<Position>();
        for(int i = 0; i < positions.size(); i++)
        {
            Position currentPosition = positions.get(i);
            int x = currentPosition.X() * transform[0][0] + currentPosition.Y() * transform[1][0];
            int y = currentPosition.X() * transform[0][1] + currentPosition.Y() * transform[1][1];
            transformedPositions.add(new Position(x, y));
        }
        return transformedPositions;
    }
}
