package tictactoe;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TicTacToeViewImpl extends JFrame implements TicTacToeView {

  public TicTacToeViewImpl(String title, TicTacToeModel model) {
    super(title);

    this.setSize(500,500);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
