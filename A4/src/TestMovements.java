/**
 * @file: TestMovements.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: April 16, 2021
 * @Description: Tests the module Movements
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;

public class TestMovements {

    private BoardT board;

    @Before
    public void setUp() {
        board = new BoardT(4);
    }

    @After
    public void tearDown() {
        board = null;
    }

    public void addNumbers() {
        for(int i = 0; i < 12; i++) board.addNewNumber();
    }

    @Test
    public void testMoveLeft() {
        addNumbers();
        Movements.moveLeft(board);
        int count = 0;
        for(int i = 0; i < board.getBoard().length; i++) {
            if(board.getBoard()[i][0] != 0) count++;
        }
        assertEquals(count, 4);
    }

    @Test
    public void testMoveRight() {
        addNumbers();
        Movements.moveRight(board);
        int count = 0;
        for(int i = 0; i < board.getBoard().length; i++) {
            if(board.getBoard()[i][3] != 0) count++;
        }
        assertEquals(count, 4);
    }

    @Test
    public void testMoveUp() {
        addNumbers();
        Movements.moveUp(board);
        int count = 0;
        for(int j = 0; j < board.getBoard().length; j++) {
            if(board.getBoard()[0][j] != 0) count++;
        }
        assertEquals(count, 4);
    }

    @Test
    public void testMoveDown() {
        addNumbers();
        Movements.moveDown(board);
        int count = 0;
        for(int j = 0; j < board.getBoard().length; j++) {
            if(board.getBoard()[3][j] != 0) count++;
        }
        assertEquals(count, 4);
    }
}
