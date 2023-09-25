package tictactoepackage;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.Before;

import org.junit.Test;

public class TicTacToeTest {

	  @Test
	    public void testPrintBoard() {
	        char[][] board = {
	            { ' ', '|', ' ', '|', ' ' },
	            { '-', '+', '-', '+', '-' },
	            { ' ', '|', ' ', '|', ' ' },
	            { '-', '+', '-', '+', '-' },
	            { ' ', '|', ' ', '|', ' ' }
	        };
	        
	        // Create a StringWriter to capture the printed output
	        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
	        System.setOut(new java.io.PrintStream(outContent));
	       
	        // Call the method to be tested
	        TicTacToe.printBoard(board);
	        
	        // Define the expected output
	        String expectedOutput = " | | \n-+-+-\n | | \n-+-+-\n | | \n";
	        
	        // Compare the expected output with the actual printed output
	        assertEquals(expectedOutput, outContent.toString());
	    }
	  
	    @Test
	    public void testWinCondition_PlayerOneWins() {    	
	    
	        // Fill the user array list with winning condition
	        TicTacToe.playerOnePositions = new ArrayList<>(Arrays.asList(1, 2, 3)); 
	            
	        // Call the winCondition method
	        String result = TicTacToe.winCondition();	            
	        
	        assertEquals("You Won! ^_^", result);
	    }
	    
	    @Before
	    public void setUP1() {
	    	// Clears the arraylist
	    	TicTacToe.playerOnePositions.clear();
	    	TicTacToe.playerCPUPositions.clear();
	    }
	    		    
	    @Test 
	    public void testWinCondition_CPUWins() {
	    	
	    	// Fill the cpu array list with winning condition
	    	TicTacToe.playerCPUPositions = new ArrayList<>(Arrays.asList(1,2,3));
	    	
	    	// Calls the winCondition method
	    	String result = TicTacToe.winCondition();
	    	
	    	assertEquals("You Lost! O_o", result);
	    }

	    @Before
	    public void setUP2() {
	    	// Clears the arraylist
	    	TicTacToe.playerOnePositions.clear();
	    	TicTacToe.playerCPUPositions.clear();
	    }
	    
	    @Test
	    public void testWinCondition_NoWinner() {
	 	        
	        // Call the winCondition method
	        String result = TicTacToe.winCondition();
	        
	        // Assert that the result is an empty string indicating no winner
	        assertEquals("", result);
	    }



	}









