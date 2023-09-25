package tictactoepackage;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class TicTacToe {

	// Lists to store player positions
	static ArrayList<Integer> playerOnePositions = new ArrayList<Integer>();
	static ArrayList<Integer> playerCPUPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		// Declarations
		Scanner userInput = new Scanner(System.in);
		// Populating 2d board array
		char[][] board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		// Calls printBoard() method
		printBoard(board);

		// While loop for gameplay
		while (true) {
			System.out.println("Enter your position (1-9)");

			// Takes user input and plays it
			int userPos = userInput.nextInt();

			// While loop makes sure the user enter a valid position
			while (playerOnePositions.contains(userPos) || playerCPUPositions.contains(userPos)) {
				System.out.println("Position unavailable, please enter another one");
				userPos = userInput.nextInt();
			}

			// Calls placePiece method
			placePiece(board, "Player 1", userPos);

			// Checks if user won
			String result = winCondition();
			if (result.length() > 0) {
				System.out.println(result);
				printBoard(board);
				
				break;
			} 
			// Checks if game is a tie
			else if (playerOnePositions.size() + playerCPUPositions.size() == 9) {
				System.out.println("It's a tie! -_-");
				printBoard(board);
				
				break;
			}

			// Prints your move
			System.out.println("Your previous move: ");
			printBoard(board);
			System.out.println("-----------------------------------");

			// Takes random cpu input and plays it
			Random random = new Random();
			int cpuPos = random.nextInt(9) + 1;

			// While loop makes sure computer enters a valid position
			while (playerOnePositions.contains(cpuPos) || playerCPUPositions.contains(cpuPos)) {
				cpuPos = random.nextInt(9) + 1;
			}
			// Calls placePiece method
			placePiece(board, "Player CPU", cpuPos);

			// Checks if computer won
			result = winCondition();
			if (result.length() > 0) {
				System.out.println(result);
				printBoard(board);
				
				break;
			}
			// Checks if game is a tie
			else if (playerOnePositions.size() + playerCPUPositions.size() == 9) {
				System.out.println("It's a tie! -_-");
				printBoard(board);
				
				break;
			}

			// Calls printBoard method
			System.out.println("CPU's Turn:");
			printBoard(board);
			System.out.println("----------------------------------");
		}
	}

// ------------------------------------------------------------------------------------------------------------------------------	

	// Prints game board
	public static void printBoard(char[][] board) {

		// For loop to print each row of the board array
		for (char[] row : board) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

// ------------------------------------------------------------------------------------------------------------------------------	

	// Maps inputs as pieces with positions on the board
	public static void placePiece(char[][] board, String player, int userPos) {

		// Determines what piece the user or CPU places
		char piece = 'X';
		if (player.equals("Player 1")) {
			piece = 'X';
			playerOnePositions.add(userPos);
		} else if (player.equals("Player CPU")) {
			piece = 'O';
			playerCPUPositions.add(userPos);
		}

		// Switch case which allocates user input to a position on the board
		switch (userPos) {
		case 1:
			board[0][0] = piece;
			break;
		case 2:
			board[0][2] = piece;
			break;
		case 3:
			board[0][4] = piece;
			break;
		case 4:
			board[2][0] = piece;
			break;
		case 5:
			board[2][2] = piece;
			break;
		case 6:
			board[2][4] = piece;
			break;
		case 7:
			board[4][0] = piece;
			break;
		case 8:
			board[4][2] = piece;
			break;
		case 9:
			board[4][4] = piece;
			break;
		}
	}

// ------------------------------------------------------------------------------------------------------------------------------	

	// Allocates game win conditions
	public static String winCondition() {

		// Making a list of all the possible winning conditions
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> botRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 2, 3);
		List<Integer> midCol = Arrays.asList(4, 5, 6);
		List<Integer> rightCol = Arrays.asList(7, 8, 9);
		List<Integer> diag1 = Arrays.asList(1, 5, 9);
		List<Integer> diag2 = Arrays.asList(7, 5, 3);

		// Making a collection of the lists
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(diag2);
		winning.add(diag1);

		// Checks if the board contains a winning/tying condition
		for (List<?> a : winning) {
			boolean win = false;
			if (playerOnePositions.containsAll(a)) {
				win = true;
				return "You Won! ^_^";

			} else if (playerCPUPositions.containsAll(a)) {
				win = true;
				return "You Lost! O_o";
			}
		}
		return "";
	}

}
