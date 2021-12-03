package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeModel;

/**
 * Test cases for the TicTacToeModel. Managing the game state properly to identify when a player
 * wins or the game ends in a draw, player actions are properly validated, no invalid arguments for
 * the tictactoe value placement in the matrix.
 */
public class TicTacToeModelTest {

  private final TicTacToe tictactoeGame = new TicTacToeModel();

  @Test
  public void testMove() {
    tictactoeGame.move(0, 2);
    assertEquals(Player.O, tictactoeGame.getTurn());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    tictactoeGame.move(0, 0);
    tictactoeGame.move(0, 0);
  }

  /**
   * Test to check if a horizontal win is valid.
   */
  @Test
  public void testHorizontalWin() {
    tictactoeGame.move(1, 0); // X makes a move
    tictactoeGame.move(0, 0); // O makes a move
    tictactoeGame.move(1, 1); // X makes a move
    tictactoeGame.move(0, 1); // O makes a move
    assertFalse(tictactoeGame.isGameOver());
    tictactoeGame.move(1, 2); // X makes a move
    assertTrue(tictactoeGame.isGameOver());
    assertEquals(Player.X, tictactoeGame.getWinner());
    assertEquals(" O | O |  \n"
        + "-----------\n"
        + " X | X | X\n"
        + "-----------\n"
        + "   |   |  ", tictactoeGame.toString());
  }

  /**
   * Test to check if a vertical win is valid.
   */
  @Test
  public void testVerticalWin() {
    tictactoeGame.move(0, 0); // X makes a move
    tictactoeGame.move(1, 1); // O makes a move
    tictactoeGame.move(1, 0); // X makes a move
    tictactoeGame.move(2, 2); // O makes a move
    assertFalse(tictactoeGame.isGameOver());
    tictactoeGame.move(2, 0); // X makes a move
    assertTrue(tictactoeGame.isGameOver());
    assertEquals(Player.X, tictactoeGame.getWinner());
    assertEquals(" X |   |  \n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " X |   | O", tictactoeGame.toString());
  }

  /**
   * Test to check if a diagonal win is valid.
   */
  @Test
  public void testDiagonalWin() {
    tictactoeGame.move(0, 0); // X makes a move
    assertFalse(tictactoeGame.isGameOver());
    tictactoeGame.move(2, 0); // O makes a move
    tictactoeGame.move(1, 0); // X makes a move
    assertNull(tictactoeGame.getWinner());
    tictactoeGame.move(1, 1); // O makes a move
    tictactoeGame.move(0, 1); // X makes a move
    tictactoeGame.move(0, 2); // O makes a move

    assertTrue(tictactoeGame.isGameOver());
    assertEquals(Player.O, tictactoeGame.getWinner());
    assertEquals(" X | X | O\n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O |   |  ", tictactoeGame.toString());
  }


  @Test(expected = IllegalStateException.class)
  public void testMoveAfterGameOver() {
    tictactoeGame.move(0, 0); // X makes a move
    assertFalse(tictactoeGame.isGameOver());
    tictactoeGame.move(2, 0); // O makes a move
    tictactoeGame.move(1, 0); // X makes a move
    assertNull(tictactoeGame.getWinner());
    tictactoeGame.move(1, 1); // O makes a move
    tictactoeGame.move(0, 1); // X makes a move
    tictactoeGame.move(0, 2); // O makes a move
    tictactoeGame.move(2, 2); // 2,2 is an empty position
  }

  @Test
  public void testToString() {
    tictactoeGame.move(0, 0);
    tictactoeGame.move(1, 1);
    tictactoeGame.move(0, 2);
    tictactoeGame.move(0, 1);
    tictactoeGame.move(2, 1);
    tictactoeGame.move(1, 0);
    tictactoeGame.move(1, 2);
    tictactoeGame.move(2, 2);
    tictactoeGame.move(2, 0);
    assertEquals(" X | O | X\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O", tictactoeGame.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtRow() {
    tictactoeGame.getMarkAt(-12, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtCol() {
    tictactoeGame.getMarkAt(0, -30);
  }

  @Test
  public void testGetBoard() {
    tictactoeGame.move(0, 0); // X makes a move
    tictactoeGame.move(2, 0); // O makes a move
    tictactoeGame.move(1, 0); // X makes a move
    tictactoeGame.move(1, 1); // O makes a move
    tictactoeGame.move(0, 1); // X makes a move
    tictactoeGame.move(0, 2); // O makes a move

    Player[][] board = tictactoeGame.getBoard();
    assertEquals(Player.X, board[0][0]);
    assertEquals(Player.O, board[1][1]);

    assertEquals(Player.O, board[2][0]);
    assertEquals(Player.O, tictactoeGame.getMarkAt(2, 0));
    // mutate
    board[2][0] = Player.X;
    assertEquals(Player.O, tictactoeGame.getMarkAt(2, 0));
    Player[][] board2 = tictactoeGame.getBoard();
    assertEquals(Player.O, board2[2][0]);
  }

}