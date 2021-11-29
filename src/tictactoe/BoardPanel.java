package tictactoe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

  private final TicTacToeModel model;
  public static final int CELL_SPACE = 80;
  public static final int OFFSET = 80;

  public BoardPanel(TicTacToeModel model) {
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    // draw grid lines
    //g2d.drawLine(???);

    for (int i = 0; i <= 3; i++) {
      g2d.drawLine(i * CELL_SPACE + OFFSET, OFFSET, i * CELL_SPACE + OFFSET, 3 * CELL_SPACE + OFFSET);
      g2d.drawLine(OFFSET, i * CELL_SPACE + OFFSET, 3 * CELL_SPACE + OFFSET, i * CELL_SPACE + OFFSET);
    }
    g2d.setFont(new Font("Verdana", Font.PLAIN, 18));

    Player[][] board = model.getBoard();
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] != null) {
          g2d.drawString(board[r][c].toString(), Math.round((c+0.5) * CELL_SPACE + OFFSET),
              Math.round((r+0.5) * CELL_SPACE + OFFSET));
        }
      }
    }

    // Game result
    if (model.isGameOver()) {

    } else {

    }
//    g2d.setFont(???);
    // iterate over board, draw X and O accordingly
//    g2d.drawString("asdf", 5, 6);


  }

}
