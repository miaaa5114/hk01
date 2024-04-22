package HW6a;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // X starts the game
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    public boolean hasWinner() {
        return checkWinner(currentPlayer);
    }

    private boolean checkWinner(char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    public char[][] getGameBoard() {
        return board;
    }

}


public class HW6a {
	   public static void main(String[] args) {
	        TicTacToeGame game = new TicTacToeGame();
	        Scanner scanner = new Scanner(System.in);
	        boolean gameEnded = false;
            boolean isComputerPlayer = false;
            Random random = new Random();
            System.out.println("Player? 0:computer 1:human");
            int player = scanner.nextInt();

           if(player==0) isComputerPlayer=true;

	        while (!gameEnded) {
	            printBoard(game.getGameBoard());
                if (isComputerPlayer && game.getCurrentPlayer()=='O'){
                    int row = random.nextInt(3);
                    int col = random.nextInt(3);
                    game.makeMove(row, col);
                }else{
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [0-2] and column [0-2]): ");
                        try {
                            int row = scanner.nextInt();
                            int col = scanner.nextInt();
                            if (game.makeMove(row, col)) {
                                validInput = true;
                            } else {
                                System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter numbers only.");
                            scanner.nextLine();
                        }
                    }
    
                    
                }
	            if (game.hasWinner()) {
                    gameEnded = true;
                    printBoard(game.getGameBoard());
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                } else if (game.isBoardFull()) {
                    printBoard(game.getGameBoard());
                    System.out.println("It's a tie!");
                    break;
                } else {
                    game.switchPlayer();
                }
	        }

	        scanner.close();
	    }

	    private static void printBoard(char[][] board) {
	        System.out.println("Board:");
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j]);
	                if (j < 2) System.out.print("|");
	            }
	            System.out.println();
	            if (i < 2) System.out.println("-+-+-");
	        }
	    }

}