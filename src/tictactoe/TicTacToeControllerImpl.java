package tictactoe;

/**
 * TicTacToeControllerImpl represents the control of the Tic Tac Toe game,
 * get the user interaction and provides the desired results based on the functionality.
 */
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
    try{
      model.move(row, col);
    }
    catch(IllegalStateException isl) {

    }

    view.refresh();
  }
}
