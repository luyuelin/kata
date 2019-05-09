package kata;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import kata.TennisGame;

@RunWith(Parameterized.class)
public class tennisGameTest {
	 private int player1Point;
	 private int player2Point;
	 private String expectedResult;
	 
	 public tennisGameTest(int player1Point, int player2Point, String expectedResult) {
		 this.player1Point = player1Point;
	 	 this.player2Point = player2Point;
	 	 this.expectedResult = expectedResult;
	 }
	 
	 @Parameters
	 public static Collection<Object[]> getAllScores() {
	        return Arrays.asList(new Object[][] {
	                { 0, 0, "Zero-Zero" },
	                { 0, 1, "Zero-Fifteen"},
	                { 0, 2, "Zero-Thirty"},
	                { 0, 3, "Zero-Forty"},
	                { 0, 4, "Player2 wins"},
	                
	                { 1, 0, "Fifteen-Zero"},
	                { 1, 1, "Fifteen-Fifteen" },
	                { 1, 2, "Fifteen-Thirty"},
	                { 1, 3, "Fifteen-Forty"},
	                { 1, 4, "Player2 wins"},
	                
	                { 2, 0, "Thirty-Zero"},
	                { 2, 1, "Thirty-Fifteen"},   
	                { 2, 2, "Thirty-Thirty"},
	                { 2, 3, "Thirty-Forty"},
	                { 2, 4, "Player2 wins"},
	                
	                { 3, 0, "Forty-Zero"},
	                { 3, 1, "Forty-Fifteen"},
	                { 3, 2, "Forty-Thirty"},     
	                { 3, 3, "Forty-Forty"},
	                { 3, 4, "Player2 wins"},
	                	                
	                { 4, 0, "Player1 wins"},
	                { 4, 1, "Player1 wins"},
	                { 4, 2, "Player1 wins"},          
	                { 4, 3, "Player1 wins"},
	        });
	    }

	    public void checkAllScores(TennisGame game) {
	        int highestScore = Math.max(this.player1Point, this.player2Point);
	        for (int i = 0; i < highestScore; i++) {
	            if (i < this.player1Point)
	                game.wonPoint("player1");
	            if (i < this.player2Point)
	                game.wonPoint("player2");
	        }
	        assertEquals(this.expectedResult, game.getResult());
	        System.out.println("Result: " + game.getResult());
	        System.out.println();
	    }   
	    
	    @Test
	    public void checkAllScoresTennisGame1() {
	    	TennisGame game = new TennisGame("Player1", "Player2");
	    	System.out.println("Player1-Player2: " + player1Point + "-" + player2Point);
	        checkAllScores(game);
	    }

}
