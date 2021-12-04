package tictactoe;

/**
 * TicTacToeControllerImpl represents the control of the Tic Tac Toe game, get the user interaction
 * and provides the desired results based on the functionality.
 */
public class TicTacToeControllerImpl implements TicTacToeController {

  private final TicTacToeModel model;
  private final TicTacToeView view;

  /**
   * The functionality that is to be implemented when user interacts is decided by the controller.
   *
   * @param model the functionality is defined about what the player moves.
   * @param view  the display of the tic tac toe game
   */
  public TicTacToeControllerImpl(TicTacToeModel model, TicTacToeView view) {
    if(model == null) {
      throw new IllegalArgumentException("Empty model");
    }
    if(view == null) {
      throw new IllegalArgumentException("Empty view");
    }

    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame(TicTacToe m) {
    if(m == null) {
      throw new IllegalArgumentException("Empty model in play game");
    }
    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
  // Row column related exceptions are handled in the model.
    try {
      model.move(row, col);
    } catch (IllegalStateException isl) {
      // Empty catch to handle and not throw exceptions.
    }
    view.refresh();
  }
}
