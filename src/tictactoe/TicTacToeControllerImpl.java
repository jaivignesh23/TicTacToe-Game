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

  }

  @Override
  public void handleCellClick(int row, int col) {

  }
}
