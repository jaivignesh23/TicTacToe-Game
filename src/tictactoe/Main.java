package tictactoe;

/**
 * Run a TicTacToe game interactively.
 */
public class Main {
  /**
   * Run a TicTacToe game interactively.
   */
  public static void main(String[] args) {
    // Old News: console-based game:
    //new TicTacToeConsoleController(new InputStreamReader(System.in),
    //    System.out).playGame(new TicTacToeModel());

    // New Hotness: Graphical User Interface:
    // 1. Create an instance of the model.
    // 2. Create an instance of the view.
    // 3. Create an instance of the controller.
    // 4. Call playGame() on the controller.

    // Create the model
    TicTacToeModel model = new TicTacToeModel();
    // Create the view
    TicTacToeView view = new TicTacToeViewImpl("Echo a string", model);
    // Create the controller with the model and view
    TicTacToeController control = new TicTacToeControllerImpl(model, view);

    control.playGame(model);
  }
}
