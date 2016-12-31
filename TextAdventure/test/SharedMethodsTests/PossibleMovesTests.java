/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharedMethodsTests;

import Maps.GenericBattleMap;
import SharedLibrary.Position;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author MaxM
 */


public class PossibleMovesTests {
    
    @Test
    public void SpeedOneFromCenter()
    {
        GenericBattleMap map = new GenericBattleMap();
        
        Position creaturePos = new Position(2, 2);
        map.SetCharacterPosition(creaturePos.X(), creaturePos.Y());
        ArrayList<Position> moves = SharedLibrary.SharedMethods.PossibleMoves(map, creaturePos, 1);
        
        ArrayList<Position> actualMoves = new ArrayList<Position>();
        actualMoves.add(new Position(2, 2));
        actualMoves.add(new Position(2, 3));
        actualMoves.add(new Position(2, 1));
        actualMoves.add(new Position(1, 2));
        actualMoves.add(new Position(3, 2));
        
        Assert.assertNotNull(moves);
        Assert.assertEquals(actualMoves.size(), moves.size());
        for(int i = 0; i < actualMoves.size(); i++)
        {
            Position current = actualMoves.get(i);
            Assert.assertTrue(SharedLibrary.SharedMethods.Contains(moves, current));
        }
    }
    
    @Test
    public void SpeedOneFromCorner()
    {
        GenericBattleMap map = new GenericBattleMap();
        
        Position creaturePos = new Position(0, 0);
        map.SetCharacterPosition(creaturePos.X(), creaturePos.Y());
        ArrayList<Position> moves = SharedLibrary.SharedMethods.PossibleMoves(map, creaturePos, 1);
        
        ArrayList<Position> actualMoves = new ArrayList<Position>();
        actualMoves.add(new Position(0, 0));
        actualMoves.add(new Position(1, 0));
        actualMoves.add(new Position(0, 1));
        
        Assert.assertNotNull(moves);
        Assert.assertEquals(actualMoves.size(), moves.size());
        for(int i = 0; i < actualMoves.size(); i++)
        {
            Position current = actualMoves.get(i);
            Assert.assertTrue(SharedLibrary.SharedMethods.Contains(moves, current));
        }
    }
    
    @Test
    public void SpeedTwoFromCenter()
    {
        GenericBattleMap map = new GenericBattleMap();
        
        Position creaturePos = new Position(2, 2);
        map.SetCharacterPosition(creaturePos.X(), creaturePos.Y());
        ArrayList<Position> moves = SharedLibrary.SharedMethods.PossibleMoves(map, creaturePos, 2);
        
        ArrayList<Position> actualMoves = new ArrayList<Position>();
        actualMoves.add(new Position(2, 2));
        actualMoves.add(new Position(2, 4));
        actualMoves.add(new Position(2, 3));
        actualMoves.add(new Position(2, 1));
        actualMoves.add(new Position(2, 0));
        actualMoves.add(new Position(0, 2));
        actualMoves.add(new Position(1, 2));
        actualMoves.add(new Position(3, 2));
        actualMoves.add(new Position(4, 2));
        //Diagonals
        actualMoves.add(new Position(1, 1));
        actualMoves.add(new Position(3, 3));
        actualMoves.add(new Position(3, 1));
        actualMoves.add(new Position(1, 3));
        
        Assert.assertNotNull(moves);
        Assert.assertEquals(actualMoves.size(), moves.size());
        for(int i = 0; i < actualMoves.size(); i++)
        {
            Position current = actualMoves.get(i);
            Assert.assertTrue(SharedLibrary.SharedMethods.Contains(moves, current));
        }
    }
}
