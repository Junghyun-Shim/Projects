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
	    // 밑에걸로 변경
//	    System.out.println(dealer.deck.get(0));

//		Player player = new Player("정현");
//		System.out.println(player.player);
	    
	    // 사용자 ArrayList
	    ArrayList<String> players = new ArrayList<String>();
	  
		// 플레이어 입력 수 만큼 플레이어 생성
		for (int i=0; i<game.playerNumber; i++) {
			System.out.println("set your name : ");
			String name = s.nextLine();
			players.add(name);
			System.out.println("your name is "+ players.get(i)+ " !!");
		}
		System.out.println("Okay, Let's go Blackjack !");
		System.out.println(" ");
		
		// 플레이어 설정후 딜러가 덱 셔플
		Dealer dealer = new Dealer();
		
		System.out.println("The deck is shuffled");
		dealer.shuffleDeck();
		System.out.println(dealer.deck.get(0)); // 덱 확인
	
		// 플레이어 수만큼 손의 패 상태 정보 만듬
//		String[][] hand = new String[game.playerNumber+1][];
		ArrayList<ArrayList<String>> playerHand = new ArrayList<ArrayList<String>>();
		
//		
		for (int i=0; i<game.playerNumber+1; i++) {
			ArrayList<String> hand = new ArrayList<String>(); //hand 초기화
			hand.add(dealer.deck.get(0)); // 덱 첫번째 카드를 핸드에 추가
			dealer.deck.remove(0);  // 추가한 첫번째 카드를 덱에서 삭제
			hand.add(dealer.deck.get(0)); // 다시 덱의 첫번째 카드를 손에 추가
			dealer.deck.remove(0); // 추가한 카드를 덱에서 삭제
			playerHand.add(hand); // 2개의 카드를 플레이어에 추가
		}
		
		
		System.out.println("< Dealer's card >");
		System.out.println(playerHand.get(0));
		
		for (int i=0; i<game.playerNumber; i++) {
		    System.out.println("< " + players.get(i) +"'s card >");
		    System.out.println(playerHand.get(i+1));
		}
		
//		String[] deck2 = {"sucess"};
////		hand[0][0] = dealer.deck.get(0);
//		hand[0][0] = "dfs";
//		System.out.println(hand[0][0]);
//		// 딜러와 플레이어들에게 카드 나눠줌
////		for (int i=0; i<game.playerNumber+1; i++) {
////			hand[i][0] = dealer.deck.get(0);
////			dealer.deck.remove(0);
////		}
////		for (int i=0; i<=game.playerNumber; i++) {
////			hand[i][1] = dealer.deck.get(0);
////			dealer.deck.remove(0);
//		}
		
		
//	    // 현재 패 정보 출려
//		System.out.println("< Dealer's card >");
//		System.out.println(hand[0]);
//		
//		for (int i=1; i<game.playerNumber+1; i++) {
//			System.out.println("< " + players.get(i-1) +"'s card >");
//			System.out.println(hand[i]);
//		}
		
		
	}
}



