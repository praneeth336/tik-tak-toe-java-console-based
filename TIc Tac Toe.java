import java.util.Scanner;

public class TicTacToe {

    // Function to check if a player has won
    public static boolean isWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] != '.' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            // Check columns
            if (board[0][i] != '.' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '.' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    // Function to print the board
    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }

        int movesLeft = 9;
        char player = 'X';

        while (movesLeft > 0) {
            printBoard(board);
            System.out.print("Enter the position (row column) to place " + player + ": ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Check for valid input
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid Input. Try again.");
                continue;
            } else if (board[row][col] != '.') {
                System.out.println("Cell already occupied. Try again.");
                continue;
            }

            // Place the player's mark
            board[row][col] = player;

            // Check for a win
            if (isWin(board)) {
                printBoard(board);
                System.out.println(player + " is the winner!");
                break;
            }

            // Switch player
            player = (player == 'X') ? 'O' : 'X';
            movesLeft--;
        }

        // Check for a draw
        if (movesLeft == 0 && !isWin(board)) {
            printBoard(board);
            System.out.println("Game is a draw!");
        }

        sc.close();
    }
}
