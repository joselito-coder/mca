
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ConnectFourGame extends JFrame {
    private final int ROWS = 6;
    private final int COLS = 7;
    private final JButton[] buttons = new JButton[COLS];
    private final CellPanel[][] grid = new CellPanel[ROWS][COLS];
    private char currentPlayer = 'R'; // 'R' for Red, 'Y' for Yellow

    public ConnectFourGame() {
        setTitle("Connect Four");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(1, COLS));
        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));

        // Create buttons for dropping pieces
        for (int col = 0; col < COLS; col++) {
            buttons[col] = new JButton("Drop");
            int finalCol = col;
            buttons[col].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dropPiece(finalCol);
                }
            });
            buttonPanel.add(buttons[col]);
        }

        // Create the grid (custom JPanel cells)
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = new CellPanel();
                gridPanel.add(grid[row][col]);
            }
        }

        add(buttonPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }

    // Handle piece drop
    private void dropPiece(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (grid[row][col].isEmpty()) {
                grid[row][col].setPlayerColor(currentPlayer == 'R' ? Color.RED : Color.YELLOW);
                if (checkWin(row, col)) {
                    JOptionPane.showMessageDialog(this, "Player " + (currentPlayer == 'R' ? "Red" : "Yellow") + " wins!");
                    resetGame();
                } else if (isGridFull()) {
                    JOptionPane.showMessageDialog(this, "It's a draw!");
                    resetGame();
                } else {
                    currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R'; // Switch player
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Column is full! Choose another column.");
    }

    // Check for a win condition
    private boolean checkWin(int row, int col) {
        Color color = grid[row][col].getPlayerColor();
        return checkDirection(row, col, 1, 0, color) ||  // Check horizontally
               checkDirection(row, col, 0, 1, color) ||  // Check vertically
               checkDirection(row, col, 1, 1, color) ||  // Check diagonal down-right
               checkDirection(row, col, 1, -1, color);   // Check diagonal down-left
    }

    // Check in a particular direction for a connect four
    private boolean checkDirection(int row, int col, int rowDir, int colDir, Color color) {
        int count = 1;
        count += countInDirection(row, col, rowDir, colDir, color);
        count += countInDirection(row, col, -rowDir, -colDir, color);
        return count >= 4;
    }

    // Count consecutive pieces in a specific direction
    private int countInDirection(int row, int col, int rowDir, int colDir, Color color) {
        int count = 0;
        for (int i = 1; i < 4; i++) {
            int newRow = row + i * rowDir;
            int newCol = col + i * colDir;
            if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS &&
                grid[newRow][newCol].getPlayerColor() == color) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    // Check if the grid is completely full
    private boolean isGridFull() {
        for (int col = 0; col < COLS; col++) {
            if (grid[0][col].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Reset the game for a new round
    private void resetGame() {
        currentPlayer = 'R';
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col].clear();
            }
        }
    }

    // Custom JPanel for each cell in the grid
    private static class CellPanel extends JPanel {
        private Color playerColor = Color.WHITE;  // Default empty cell

        public CellPanel() {
            setBorder(BorderFactory.createLineBorder(Color.BLACK));  // Add a border around each cell
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(playerColor);
            // Draw a circle (oval) centered in the panel
            g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);
        }

        public boolean isEmpty() {
            return playerColor == Color.WHITE;
        }

        public void setPlayerColor(Color color) {
            playerColor = color;
            repaint();  // Redraw the panel with the new color
        }

        public Color getPlayerColor() {
            return playerColor;
        }

        public void clear() {
            playerColor = Color.WHITE;
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectFourGame game = new ConnectFourGame();
            game.setVisible(true);
        });
    }
}
