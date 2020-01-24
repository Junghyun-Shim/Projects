package blackJack;

import java.util.Scanner;

public class Game {
	
	Scanner s = new Scanner(System.in);
	int playerNumber;
	
	public void setPlayerNumber() {
		System.out.println("set number of the players : ");
		this.playerNumber = s.nextInt();
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
	    game.setPlayerNumber();
	    System.out.println(game.playerNumber);
	}
    
}
