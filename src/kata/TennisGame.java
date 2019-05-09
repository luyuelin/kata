package kata;

public class TennisGame {
	private int player1Point = 0;
	private int player2Point = 0;
	private String playerTwoName;
	private String playerOneName;
	
	public TennisGame(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}
	
	public void wonPoint(String p){
		if (p.equals("player1"))
			player1Point ++;
		else 
			player2Point ++;		
	}

	public String getResult() {
		if (hasWinner())
			return playerWithHigherPoint()+ " wins";
		return 	translateScore(player1Point) + "-" + translateScore(player2Point);			
	}
	
	public String getResultModeDeuse() {
		if (hasWinnerModeDeuce())
			return playerWithHigherPoint()+ " wins";
		if (hasAdv())
			return playerWithHigherPoint()+ " ADV";
		if(isDeuce())
			return "Deuce";
		return 	translateScore(player1Point) + "-" + translateScore(player2Point);			
	}
	
	private String translateScore(int score) {
		switch (score) {
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1: 
			return "Fifteen";
		case 0:
			return "Zero";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}
	
	protected boolean hasWinner(){
		if (player1Point == 4 || player2Point == 4)
			return true;
		return false;
	}
	
	protected boolean hasWinnerModeDeuce(){
		if (player1Point >=4 && player1Point >= player2Point + 2)
			return true;
		if (player2Point >=4 && player2Point >= player1Point + 2)
			return true;
		return false;
	}
	
	private boolean hasAdv(){
		if (player1Point >=4 && player1Point == player2Point + 1)
			return true;
		if (player2Point >=4 && player2Point == player1Point + 1)
			return true;
		return false;
	}
	
	private boolean isDeuce(){
		return player1Point>3 && player1Point == player2Point;
	}
	
	private String playerWithHigherPoint() {
		if (player1Point > player2Point) {
			return playerOneName;
		} else {
			return playerTwoName;
		}
	}
	
	
}
