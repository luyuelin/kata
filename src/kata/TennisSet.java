package kata;

import kata.TennisGame;

public class TennisSet {
	
	private String playerTwoName;
	private String playerOneName;
	private int player1Set = 0;
	private int player2Set = 0;
	
	public TennisSet(String playerOneName, String playerTwoName) {
		this.playerOneName = playerOneName;
		this.playerTwoName = playerTwoName;
	}
	
	public void wonPoint(String p){
		if (p.equals("player1"))
			player1Set ++;
		else 
			player2Set ++;		
	}
	
	public String getResult(TennisSet set, TennisGame game, int player1Game, int player2Game, int player1Point,
			int player2Point) {
		int tmp1;
		int tmp2;
		String tmp ="";
		
		// Initialize game
		int highestScore = Math.max(player1Point, player2Point);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Point)
                game.wonPoint("player1");
            if (i < player2Point)
                game.wonPoint("player2"); 
        } 
        String rGame = game.getResult();
        /* String rGame = game.getResultModeDeuse(); */ //Mode Deuse
        
        // initialize set
        highestScore = Math.max(player1Game, player2Game);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Game)
                wonPoint("player1");
            if (i < player2Game)
                wonPoint("player2"); 
        } 
        
        if(hasWinner()) 
        	return playerWithHigherPoint() + " wins"; 
        if(game.hasWinner()){ //if(game.hasWinnerModeDeuce()) {
        	tmp1 = player1Set;
        	tmp2 = player2Set;
        	if (player1Point > player2Point)
        		tmp1 ++;
        	else 
        		tmp2 ++;
        	if (tmp1 == 7)
        		tmp = " " + playerOneName + " wins";
        	if (tmp2 == 7)
        		tmp = " " + playerTwoName + " wins";
        	return "Set: "+  player1Set + "-" + player2Set + " Game: " + rGame + " => Set: " + tmp1 + "-" + tmp2 + tmp; 
        }        	
        return "Set: "+  player1Set + "-" + player2Set + " Game: " + rGame;
	}
	
	public String getResultModeTieBreak
	(TennisSet set, TennisGame game, int player1Game, int player2Game, int player1Point,
			int player2Point) {
		int tmp1;
		int tmp2;
		String tmp ="";
		
		// Initialize game
		int highestScore = Math.max(player1Point, player2Point);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Point)
                game.wonPoint("player1");
            if (i < player2Point)
                game.wonPoint("player2"); 
        } 
        String rGame = game.getResult();
        /* String rGame = game.getResultModeDeuse(); */ //Mode Deuse
        
        // initialize set
        highestScore = Math.max(player1Game, player2Game);
        for (int i = 0; i < highestScore; i++) {
            if (i < player1Game)
                wonPoint("player1");
            if (i < player2Game)
                wonPoint("player2"); 
        } 
        
        if(hasWinnerModeTieBreak()) 
        	return playerWithHigherPoint() + " wins"; 
        if(game.hasWinner()){ //if(game.hasWinnerModeDeuce()) {
        	tmp1 = player1Set;
        	tmp2 = player2Set;
        	if (player1Point > player2Point)
        		tmp1 ++;
        	else 
        		tmp2 ++;
        	if (tmp1 >= 7 && tmp1 >= tmp2 + 2)
        		tmp = " " + playerOneName + " wins";
        	if (tmp2 >= 7 && tmp2 >= tmp1 + 2)
        		tmp = " " + playerTwoName + " wins";
        	return "Set: "+  player1Set + "-" + player2Set + " Game: " + rGame + " => Set: " + tmp1 + "-" + tmp2 + tmp; 
        }        	
        return "Set: "+  player1Set + "-" + player2Set + " Game: " + rGame;
	}
	
	protected boolean hasWinner(){
		if (player1Set == 6 && player2Set <= 4)
			return true;
		if (player2Set == 6 && player1Set <= 4)
			return true;
		if (player1Set == 7 || player2Set == 7)
			return true;
		return false;
	}
	
	protected boolean hasWinnerModeTieBreak(){
		if (player1Set >= 7 && player1Set - player2Set >= 2)
			return true;
		if (player2Set == 7 && player2Set - player1Set >= 2)
			return true;
		return false;
	}
	
	private String playerWithHigherPoint() {
		if (player1Set > player2Set) {
			return playerOneName;
		} else {
			return playerTwoName;
		}
	}
	
}
