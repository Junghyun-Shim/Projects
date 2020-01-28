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
	

    // ��ǲ �޴°��� int Ÿ�� �ȳ����� ���� ���� �̰� ����ó�� ����� �ҵ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
	    game.setPlayerNumber();
	    System.out.println(game.playerNumber);
		
	    Scanner s = new Scanner(System.in);
//		Dealer dealer = new Dealer();
//		System.out.println(dealer.deck[0]);
//		dealer.shuffleDeck();
//		System.out.println(dealer.deck[0]); // �� ���� �� �Ƴ� Ȯ�� �뵵
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
//		String[][] hand = new String[game.playerNumber+1][]; <- array�� �־ �Ϸ��� �ߴµ� ������
		ArrayList<ArrayList<String>> playerHand = new ArrayList<ArrayList<String>>();
		
		// ������ �÷��̾����� ī�� �ִ� �κ�
		for (int i=0; i<game.playerNumber+1; i++) {
			ArrayList<String> hand = new ArrayList<String>(); //hand �ʱ�ȭ
			hand.add(dealer.deck.get(0)); // �� ù��° ī�带 �ڵ忡 �߰�
			dealer.deck.remove(0);  // �߰��� ù��° ī�带 ������ ����
			hand.add(dealer.deck.get(0)); // �ٽ� ���� ù��° ī�带 �տ� �߰�
			dealer.deck.remove(0); // �߰��� ī�带 ������ ����
			playerHand.add(hand); // 2���� ī�带 �÷��̾ �߰�
		}
		
		
		// ���� ��
		ArrayList<Integer> playerMoney = new ArrayList<Integer>();
		for (int i=0; i<game.playerNumber+1; i++) {
			playerMoney.add(50);
		}
		
		// ���� ī�� �� ���� �� ���
		System.out.println("< Dealer's card >");
		System.out.println("[?, " + playerHand.get(0).get(1) + "]"+"[$"+playerMoney.get(0)+"]");
		System.out.println(" ");
		
		// �÷��̾� ī�� �� ���� �� ���
		for (int i=0; i<game.playerNumber; i++) {
		    System.out.println("< " + players.get(i) +"'s card >");
		    System.out.println(playerHand.get(i+1)+"[$"+playerMoney.get(i+1)+"]");
		    System.out.println(" ");
		}
		
		// 2���� ī�� �� ����ϱ�
		ArrayList<Integer> playerScore = new ArrayList<Integer>(); 
		int score = 0;
		for (int i=0; i<game.playerNumber+1; i++) {
			for (int j=0; j<playerHand.get(i).size(); j++) {
		    if (playerHand.get(i).get(j).contains("A")) {
			    System.out.println("��A�� 1������ ���� 11������ ���� ������ (1:1��, 2:11��)");
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
		
		
		
		
		
		// go stop ���� �ޱ�
		for (int i=0; i<game.playerNumber; i++) {
			
			System.out.println("< " + players.get(i) +"'s card >");
			System.out.println(playerHand.get(i+1));
			System.out.println("<Dealer> : Hey " + players.get(i) + ", Do you need more card? (1:yes, 2:no)");
			
			int goStop = s.nextInt();
			if (goStop == 1) {
				ArrayList<String> hand = new ArrayList<String>(); //hand �ʱ�ȭ
				hand.add(playerHand.get(i+1).get(0));
				hand.add(playerHand.get(i+1).get(1));
				hand.add(dealer.deck.get(0)); // ���� ù��° ī�带 �տ� �߰�
				dealer.deck.remove(0);  // �߰��� ī�带 ������ ����
				playerHand.add(i+1, hand); // ī�带 �÷��̾ �߰�
			    System.out.println("< " + players.get(i) +"'s card >");
			    System.out.println(playerHand.get(i+1));
			    System.out.println(" ");
			}
		}
		
        System.out.println(playerHand.get(0).size());
        System.out.println(playerHand.get(1).size());
        System.out.println(playerHand.get(2).size());
		
		// array 2�������� �ؼ� �Ϸ��� �ߴµ� �ڲ� NULL P��¼�� Exception ���� ���� ���� arraylist ���°ɷ� �ٲ�
//		String[] deck2 = {"sucess"};
//		hand[0][0] = dealer.deck.get(0);
//		hand[0][0] = "dfs";
//		System.out.println(hand[0][0]);
//		// ������ �÷��̾�鿡�� ī�� ������
//		for (int i=0; i<game.playerNumber+1; i++) {
//			hand[i][0] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
//		for (int i=0; i<=game.playerNumber; i++) {
//			hand[i][1] = dealer.deck.get(0);
//			dealer.deck.remove(0);
//		}
//		
//	    // ���� �� ���� ���
//		System.out.println("< Dealer's card >");
//		System.out.println(hand[0]);
//		
//		for (int i=1; i<game.playerNumber+1; i++) {
//			System.out.println("< " + players.get(i-1) +"'s card >");
//			System.out.println(hand[i]);
//		}
		
		
		
		
		
		
	}
}



