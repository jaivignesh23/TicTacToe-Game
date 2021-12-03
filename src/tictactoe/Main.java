package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {

    // Create the model
    TicTacToeModel model = new TicTacToeModel();
    // Create the view
    TicTacToeView view = new TicTacToeViewImpl("Tic Tac Toe", model);
    // Create the controller with the model and view
    TicTacToeController control = new TicTacToeControllerImpl(model, view);

    control.playGame(model);
  }
}
