import java.awt.*;
import java.awt.event.*;

public class CircularLinkedList extends Frame {

    private static final int BOARD_SIZE = 8;
    private Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    public CircularLinkedList() {
        setTitle("Simple Chess");
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        initializeBoard();
        addComponents();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 400);
        // Make the window always on top
        setAlwaysOnTop(true);
        setVisible(true);
    }

    private void initializeBoard() {
    	// Initialize the chessboard with buttons
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col] = new Button();
                squares[row][col].setBackground(getSquareColor(row, col));
                squares[row][col].addActionListener(new ChessButtonListener(row, col));

                // Set initial pieces (replace with your piece representation)
                if (row == 1) {
                    squares[row][col].setLabel("3x2"); // Pawn symbol
                } else if (row == 0 && (col == 3 || col == 4)) {
                    squares[row][col].setLabel("♕"); // Queen symbol
                }
            }
        }
    }

    
    private void addComponents() {
        // Add buttons to the frame
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                add(squares[row][col]);
            }
        }
    }

    private Color getSquareColor(int row, int col) {
        // Determine the color of the square based on its position
        return (row + col) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY;
    }

    private class ChessButtonListener implements ActionListener {
        private int row;
        private int col;

        public ChessButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            // Handle button click events (for future moves, piece selection, etc.)
            System.out.println("Square clicked: Row=" + row + ", Col=" + col);
        }
    }

    public static void main(String[] args) {
        new CircularLinkedList();
    }
}
