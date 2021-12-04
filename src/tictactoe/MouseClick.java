package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The clicks on the mouse id captured to perform the appropriate functions.
 */
class MouseClick extends MouseAdapter {

  private final TicTacToeController listener;

  /**
   * the event of the mouse click as listeners created from the view.
   *
   * @param listener the event of the mouse click as listeners created.
   */
  MouseClick(TicTacToeController listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Invalid listener");
    }
    this.listener = listener;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e == null) {
      throw new IllegalArgumentException("Invalid mouse click operation");
    }
    int row = (e.getY() - BoardPanel.OFFSET) / BoardPanel.CELL_SPACE;
    int col = (e.getX() - BoardPanel.OFFSET) / BoardPanel.CELL_SPACE;
    listener.handleCellClick(row, col);
  }


}
