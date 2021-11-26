package tictactoe;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TicTacToeViewImpl extends JFrame implements TicTacToeView {

  private BoardPanel boardPanel;

  public TicTacToeViewImpl(String title, TicTacToeModel model) {
    super(title);

    this.setSize(500,500);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(model);
    add(boardPanel);

    pack();
    setVisible(true);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void makeVisible() {

  }
}
