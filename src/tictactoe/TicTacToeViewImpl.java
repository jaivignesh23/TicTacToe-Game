package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * TicTacToeViewImpl represents the view of the TicTacToe game that the user can interact to
 * play the game and get the result.
 */
public class TicTacToeViewImpl extends JFrame implements TicTacToeView {

  private BoardPanel boardPanel;

  public TicTacToeViewImpl(String title, TicTacToeModel model) {
    super(title);

    setSize(500,500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel);

  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseListener ml = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = (e.getY() - BoardPanel.OFFSET) / BoardPanel.CELL_SPACE;
        int col = (e.getX() - BoardPanel.OFFSET) / BoardPanel.CELL_SPACE;
        listener.handleCellClick(row, col);
      }
    };
    boardPanel.addMouseListener(ml);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
