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
	

    // 인풋 받는곳에 int 타입 안넣으면 에러 떠서 이거 예외처리 해줘야 할듯
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
	    game.setPlayerNumber();
	    System.out.println(game.playerNumber);
		
	    Scanner s = new Scanner(System.in);
//		Dealer dealer = new Dealer();
//		System.out.println(dealer.deck[0]);
//		dealer.shuffleDeck();
//		System.out.println(dealer.deck[0]); // 덱 셔플 잘 됐나 확인 용도
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
	
		// 플레이어 수만큼 손의 패 상태 정보 만듬
//		String[][] hand = new String[game.playerNumber+1][]; <- array에 넣어서 하려고 했는데 실패함
		ArrayList<ArrayList<String>> playerHand = new ArrayList<ArrayList<String>>();
		
		// 딜러가 플레이어한테 카드 주는 부분
		for (int i=0; i<game.playerNumber+1; i++) {
			ArrayList<String> hand = new ArrayList<String>(); //hand 초기화
			hand.add(dealer.deck.get(0)); // 덱 첫번째 카드를 핸드에 추가
			dealer.deck.remove(0);  // 추가한 첫번째 카드를 덱에서 삭제
			hand.add(dealer.deck.get(0)); // 다시 덱의 첫번째 카드를 손에 추가
			dealer.deck.remove(0); // 추가한 카드를 덱에서 삭제
			playerHand.add(hand); // 2개의 카드를 플레이어에 추가
		}
		
		
		// 현재 돈
		ArrayList<Integer> playerMoney = new ArrayList<Integer>();
		for (int i=0; i<game.playerNumber+1; i++) {
			playerMoney.add(50);
		}
		
		// 딜러 카드 및 현재 돈 출력
		System.out.println("< Dealer's card >");
		System.out.println("[?, " + playerHand.get(0).get(1) + "]"+"[$"+playerMoney.get(0)+"]");
		System.out.println(" ");
		
		// 플레이어 카드 및 현재 돈 출력
		for (int i=0; i<game.playerNumber; i++) {
		    System.out.println("< " + players.get(i) +"'s card >");
		    System.out.println(playerHand.get(i+1)+"[$"+playerMoney.get(i+1)+"]");
		    System.out.println(" ");
		}
		
		// 2장의 카드 합 계산하기
		ArrayList<Integer> playerScore = new ArrayList<Integer>(); 
		int score = 0;
		for (int i=0; i<game.playerNumber+1; i++) {
			for (int j=0; j<playerHand.get(i).size(); j++) {
		    if (playerHand.get(i).get(j).contains("A")) {
			    System.out.println("♡A를 1점으로 할지 11점으로 할지 고르세요 (1:1점, 2:11점)");
			    int aceScore = s.nextInt();
			    if (aceScore == 1) {
				    score += 1;
			    } else {
				    score += 11;
			    } 
        
		    } else if (playerHand.get(i).get(j).contains("2")) {
			    score += 2;
		    } else if (playerHand.get(i).get(j).contains("3")) {
			    score += 3;
		    } else if (playerHand.get(i).get(j).contains("4")) {
			    score += 4;
		    } else if (playerHand.get(i).get(j).contains("5")) {
			    score += 5;
		    } else if (playerHand.get(i).get(j).contains("6")) {
			    score += 6;
		    } else if (playerHand.get(i).get(j).contains("7")) {
			    score += 7;
		    } else if (playerHand.get(i).get(j).contains("8")) {
			    score += 8;
		    } else if (playerHand.get(i).get(j).contains("9")) {
			    score += 9;
		    } else if (playerHand.get(i).get(j).contains("10")) {
		    	score += 10;
	    	} else if (playerHand.get(i).get(j).contains("J")) {
			   score += 10;
		    } else if (playerHand.get(i).get(j).contains("K")) {
			    score += 10;
		    } else if (playerHand.get(i).get(j).contains("Q")) {
			    score += 10;
		    }  
		}
			playerScore.add(score);
		}
		
		
		
		
		
		// go stop 여부 받기
		for (int i=0; i<game.playerNumber; i++) {
			
			System.out.println("< " + players.get(i) +"'s card >");
			System.out.println(playerHand.get(i+1));
			System.out.println("<Dealer> : Hey " + players.get(i) + ", Do you need more card? (1:yes, 2:no)");
			
			int goStop = s.nextInt();
			if (goStop == 1) {
				ArrayList<String> hand = new ArrayList<String>(); //hand 초기화
				hand.add(playerHand.get(i+1).get(0));
				hand.add(playerHand.get(i+1).get(1));
				hand.add(dealer.deck.get(0)); // 덱의 첫번째 카드를 손에 추가
				dealer.deck.remove(0);  // 추가한 카드를 덱에서 삭제
				playerHand.add(i+1, hand); // 카드를 플레이어에 추가
			    System.out.println("< " + players.get(i) +"'s card >");
			    System.out.println(playerHand.get(i+1));
			    System.out.println(" ");
			}
		}
		
        System.out.println(playerHand.get(0).size());
        System.out.println(playerHand.get(1).size());
        System.out.println(playerHand.get(2).size());
		
		// array 2차원으로 해서 하려고 했는데 자꾸 NULL P어쩌구 Exception 오류 떠서 위에 arraylist 쓰는걸로 바꿈
//		String[] deck2 = {"sucess"};
//		hand[0][0] = dealer.deck.get(0);
//		hand[0][0] = "dfs";
//		System.out.println(hand[0][0]);
//		// 딜러와 플레이어들에게 카드 나눠줌
//		for (int i=0; i<game.playerNumber+1; i++) {
//			hand[i][0] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
//		for (int i=0; i<=game.playerNumber; i++) {
//			hand[i][1] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
//		
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



