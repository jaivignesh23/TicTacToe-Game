package tictactoe;

import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * TicTacToeViewImpl represents the view of the TicTacToe game that the user can interact to play
 * the game and get the result.
 */
public class TicTacToeViewImpl extends JFrame implements TicTacToeView {

  private BoardPanel boardPanel;

  /**
   * The display of the game is defined and reassigned in the view functionality.
   *
   * @param title the window title that is displayed.
   * @param model the control of the game functionality.
   */
  public TicTacToeViewImpl(String title, TicTacToeModel model) {
    super(title);
    if (model == null) {
      throw new IllegalArgumentException("Invalid model");
    }

    setSize(500, 500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel);

  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid listener");
    }
    MouseListener ml = new MouseClick(listener);
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
