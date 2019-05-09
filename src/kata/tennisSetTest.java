package kata;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import kata.TennisSet;
import kata.TennisGame;

@RunWith(Parameterized.class)
public class tennisSetTest {
	private int player1Point;
	private int player2Point;
	private int player1Game;
	private int player2Game;
	private String expectedResult;
	
	public tennisSetTest(int player1Game, int player2Game, int player1Point, int player2Point, String expectedResult) {
		this.player1Game = player1Game;
		this.player2Game = player2Game;
		this.player1Point = player1Point;
		this.player2Point = player2Point;
		this.expectedResult = expectedResult;
	}
	
	 @Parameters
	 public static Collection<Object[]> getAllScores() {
	        return Arrays.asList(new Object[][] {
	                { 0, 0, 0, 0, "Set: 0-0 Game: Zero-Zero" },
	                { 0, 0, 0, 1, "Set: 0-0 Game: Zero-Fifteen"},
	                { 0, 0, 0, 2, "Set: 0-0 Game: Zero-Thirty"},
	                { 0, 0, 0, 3, "Set: 0-0 Game: Zero-Forty"},
	                { 0, 0, 0, 4, "Set: 0-0 Game: Player2 wins => Set: 0-1"},
	                
	                { 0, 0, 1, 0, "Set: 0-0 Game: Fifteen-Zero"},
	                { 0, 0, 1, 1, "Set: 0-0 Game: Fifteen-Fifteen" },
	                { 0, 0, 1, 2, "Set: 0-0 Game: Fifteen-Thirty"},
	                { 0, 0, 1, 3, "Set: 0-0 Game: Fifteen-Forty"},
	                { 0, 0, 1, 4, "Set: 0-0 Game: Player2 wins => Set: 0-1"},
	                
	                { 0, 0, 2, 0, "Set: 0-0 Game: Thirty-Zero"},
	                { 0, 0, 2, 1, "Set: 0-0 Game: Thirty-Fifteen"},   
	                { 0, 0, 2, 2, "Set: 0-0 Game: Thirty-Thirty"},
	                { 0, 0, 2, 3, "Set: 0-0 Game: Thirty-Forty"},
	                { 0, 0, 2, 4, "Set: 0-0 Game: Player2 wins => Set: 0-1"},
	                
	                { 0, 0, 3, 0, "Set: 0-0 Game: Forty-Zero"},
	                { 0, 0, 3, 1, "Set: 0-0 Game: Forty-Fifteen"},
	                { 0, 0, 3, 2, "Set: 0-0 Game: Forty-Thirty"},     
	                { 0, 0, 3, 3, "Set: 0-0 Game: Forty-Forty"},
	                { 0, 0, 3, 4, "Set: 0-0 Game: Player2 wins => Set: 0-1"},
	                	                
	                { 0, 0, 4, 0, "Set: 0-0 Game: Player1 wins => Set: 1-0"},
	                { 0, 0, 4, 1, "Set: 0-0 Game: Player1 wins => Set: 1-0"},
	                { 0, 0, 4, 2, "Set: 0-0 Game: Player1 wins => Set: 1-0"},          
	                { 0, 0, 4, 3, "Set: 0-0 Game: Player1 wins => Set: 1-0"},
	                
	                { 6, 0, 0, 0, "Player1 wins"},
	                { 6, 1, 0, 0, "Player1 wins"},
	                { 6, 2, 0, 0, "Player1 wins"},
	                { 6, 3, 0, 0, "Player1 wins"},
	                { 6, 4, 0, 0, "Player1 wins"},
	                
	                { 6, 5, 1, 2, "Set: 6-5 Game: Fifteen-Thirty"},
	                { 6, 5, 1, 3, "Set: 6-5 Game: Fifteen-Forty"}, 
	                { 6, 5, 1, 4, "Set: 6-5 Game: Player2 wins => Set: 6-6"},
	                
	                { 6, 6, 1, 2, "Set: 6-6 Game: Fifteen-Thirty"},
	                { 6, 6, 1, 3, "Set: 6-6 Game: Fifteen-Forty"}, 
	                { 6, 6, 1, 4, "Set: 6-6 Game: Player2 wins => Set: 6-7 Player2 wins"},
	                
	                { 6, 7, 0, 0, "Player2 wins"},
	                { 7, 6, 0, 0, "Player1 wins"},
	        });
	    }
	 
	 public void checkAllScores(TennisSet set, TennisGame game) {
	        String result = set.getResult(set,game, player1Game, player2Game, player1Point, player2Point);
	        assertEquals(this.expectedResult, result);
	        System.out.println("Result: " + result);
	        System.out.println();
	    }   
	 
	 
	 @Test
	 public void checkAllScoresTennisGame1() {
		 TennisSet set = new TennisSet("Player1", "Player2");
		 TennisGame game = new TennisGame("Player1", "Player2");
		 System.out.println("Set Score: " + player1Game + "-" + player2Game + " Game Score: " + player1Point + "-" + player2Point);
	     checkAllScores(set, game);
	 }
}
