package tictactoe;

public class TicTacToeControllerImpl implements TicTacToeController {

  private final TicTacToeModel model;
  private final TicTacToeView view;

  public TicTacToeControllerImpl(TicTacToeModel model, TicTacToeView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame(TicTacToe m) {
    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    model.move(row, col);
    view.refresh();
  }
}
