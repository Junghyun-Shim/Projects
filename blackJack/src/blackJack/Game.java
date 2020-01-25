package blackJack;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	
	Scanner s = new Scanner(System.in);
	int playerNumber;
	

	
	
	// set number of the players
	public void setPlayerNumber() {
		System.out.println("set number of the players : ");
		this.playerNumber = s.nextInt();
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
//	    game.setPlayerNumber();
//	    System.out.println(game.playerNumber);
		
//		Dealer dealer = new Dealer();
//		System.out.println(dealer.deck[0]);
//		dealer.shuffleDeck();
//		System.out.println(dealer.deck[0]);
	   
		Player player = new Player("Á¤Çö");
		System.out.println(player.player);
	}
    
}
