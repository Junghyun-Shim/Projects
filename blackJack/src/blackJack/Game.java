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
	    game.setPlayerNumber();
	    System.out.println(game.playerNumber);
		
	    Scanner s = new Scanner(System.in);
//		Dealer dealer = new Dealer();
//		System.out.println(dealer.deck[0]);
//		dealer.shuffleDeck();
//		System.out.println(dealer.deck[0]);
	    // �ؿ��ɷ� ����
//	    System.out.println(dealer.deck.get(0));

//		Player player = new Player("����");
//		System.out.println(player.player);
	    
	    // ����� ArrayList
	    ArrayList<String> players = new ArrayList<String>();
	  
		// �÷��̾� �Է� �� ��ŭ �÷��̾� ����
		for (int i=0; i<game.playerNumber; i++) {
			System.out.println("set your name : ");
			String name = s.nextLine();
			players.add(name);
			System.out.println("your name is "+ players.get(i)+ " !!");
		}
		System.out.println("Okay, Let's go Blackjack !");
		System.out.println(" ");
		
		// �÷��̾� ������ ������ �� ����
		Dealer dealer = new Dealer();
		
		System.out.println("The deck is shuffled");
		dealer.shuffleDeck();
		
		// �÷��̾� ����ŭ ���� �� ���� ���� ����
		String[][] hand = new String[game.playerNumber+1][];
		
		hand[0][0] = dealer.deck.get(0);
		System.out.println(hand[0][0]);
		// ������ �÷��̾�鿡�� ī�� ������
//		for (int i=0; i<game.playerNumber+1; i++) {
//			hand[i][0] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
//		for (int i=0; i<=game.playerNumber; i++) {
//			hand[i][1] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
		
		
//	    // ���� �� ���� ���
		System.out.println("< Dealer's card >");
		System.out.println(hand[0]);
//		
//		for (int i=1; i<game.playerNumber+1; i++) {
//			System.out.println("< " + players.get(i-1) +"'s card >");
//			System.out.println(hand[i]);
//		}
		
		
	}
}



