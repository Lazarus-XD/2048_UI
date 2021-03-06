/**
 * @file: TestBoardT.java
 * @Author: Rizwan Ahsan, ahsanm7
 * @Date: February 23, 2022
 * @Description: Tests the public interfaces of BoardT
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;

public class TestBoardT {

    private BoardT board;

    @Before
    public void setUp() {
        board = new BoardT(4);
    }

    @After
    public void tearDown() {
        board = null;
    }

    @Test
    public void testAddNewNumber() {
        board.addNewNumber();
        board.addNewNumber();
        board.addNewNumber();
        int count = 0;
        for(int i = 0; i < board.getBoard().length; i++) {
            for(int j = 0; j < board.getBoard().length; j++) {
                if(board.getBoard()[i][j] == null) continue;
                if((board.getBoard()[i][j].getValue() == 2) || (board.getBoard()[i][j].getValue() == 4))
                    count++;
            }
        }
        assertEquals(count, 3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testException() {
        BoardT board1 = new BoardT(3);
    }

    @Test
    public void testUpdateStatus() {
        assertFalse(board.getIsWon());
        assertFalse(board.getIsOver());
    }

    @Test
    public void testTranspose() {
        board.addNewNumber();
        board.addNewNumber();
        Tile[][] t = new Tile[board.getBoard().length][board.getBoard().length];
        for(int i = 0; i < board.getBoard().length; i++) {
            for(int j = 0; j < board.getBoard().length; j++) {
                t[i][j] = board.getBoard()[j][i];
            }
        }
        board.transpose();
        assertArrayEquals(board.getBoard(), t);
    }

    @Test
    public void testInverse() {
        board.addNewNumber();
        board.addNewNumber();
        Tile[][] t = new Tile[board.getBoard().length][board.getBoard().length];
        for(int i = 0; i < board.getBoard().length; i++) {
            for(int j = 0; j < board.getBoard().length; j++) {
                t[i][j] = board.getBoard()[i][3 - j];
            }
        }
        board.inverse();
        assertArrayEquals(board.getBoard(), t);
    }

    @Test
    public void testShiftCells() {
        int count = 0;
        boolean val;
        BoardT board1 = new BoardT(4);
        board1.addNewNumber();
        board1.addNewNumber();
        board1.shiftCells();
        for(int i = 0; i < board1.getBoard().length; i++) {
            if(board1.getBoard()[i][0] == null) continue;
            if((board1.getBoard()[i][0].getValue() == 2) || (board1.getBoard()[i][0].getValue() == 4))
                count++;
        }
        val = count <= 2;
        assertTrue(val);
    }

    @Test
    public void testMergeCells() {
        BoardT board1 = new BoardT(4);
        board1.addNewNumber();
        board1.addNewNumber();
        for(int i = 0; i < 7; i++) board1.addNewNumber();
        board1.shiftCells();
        board1.mergeCells();
        int count = 0;
        boolean val;
        for(int i = 0; i < board1.getBoard().length; i++) {
            for(int j = 0; j < board1.getBoard().length; j++) {
                if(board1.getBoard()[i][j] == null) continue;
                if(board1.getBoard()[i][j].getValue() == 4) count++;
            }
        }
        val = count > 1;
        assertTrue(val);
    }
}
