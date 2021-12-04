package tictactoe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * BoardPanel represents the board layout of the tic-tac-toe game and defines the view and the game
 * result view as a panel.
 */
public class BoardPanel extends JPanel {

  private final TicTacToeModel model;
  public static final int CELL_SPACE = 80;
  public static final int OFFSET = 80;

  /**
   * the model of the game is used to get the functionality and develop the game board.
   *
   * @param model the functionality of the board game and values.
   */
  public BoardPanel(TicTacToeModel model) {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model");
    }
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("Invalid graphic");
    }
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // draw grid lines.

    for (int i = 0; i <= 3; i++) {
      g2d.drawLine(i * CELL_SPACE + OFFSET, OFFSET,
          i * CELL_SPACE + OFFSET, 3 * CELL_SPACE + OFFSET);
      g2d.drawLine(OFFSET, i * CELL_SPACE + OFFSET,
          3 * CELL_SPACE + OFFSET, i * CELL_SPACE + OFFSET);
    }
    g2d.setFont(new Font("Verdana", Font.PLAIN, 18));

    Player[][] board = model.getBoard();
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] != null) {
          g2d.drawString(board[r][c].toString(), Math.round((c + 0.5) * CELL_SPACE + OFFSET),
              Math.round((r + 0.5) * CELL_SPACE + OFFSET));
        }
      }
    }

    // Game result
    if (model.isGameOver()) {

      g2d.drawString((model.getWinner() == null
              ? "Game over: tie game." : "Game over: " + model.getWinner().toString() + " wins."),
          10, 20);

    } else {
      g2d.drawString("Turn: " + model.getTurn().toString(), 10, 20);
    }


  }

}
