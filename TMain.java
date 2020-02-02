package Racing;

import java.io.*;
import java.util.Scanner;

class TMain
{
	public static void main(String[] args)
	{

		int iBettingHorse, iBettingCash = 100;

		CBettor[] bettor = new CBettor[2];

		bettor[0] = new CBettor("정현", iBettingCash);
		bettor[1] = new CBettor("혜원", iBettingCash);


		
		int round = 1;
		
		while (round < 4)  // 라운드 반복
		{	
			// 초기 자본 출력
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("*****                    "+round+"라운드 입니다.                   *****");
			System.out.println("------------------------------------------------------------");
			System.out.println(bettor[0].getName()+" Cash : $" + bettor[0].m_iBettorCash + " | " +
					bettor[1].getName()+ "Cash : $" + bettor[1].m_iBettorCash);
			CHorse[] horses = new CHorse[5]; 
	        
	        
			
			
			// 플레이어 베팅
			int count = 0;
			while (count < 2)
			{
				System.out.println();
				System.out.println(bettor[count].getName()+" 차례입니다.");
	
						System.out.println("말을 선택 하세요(1~5): ");
						while (true)
						{
							iBettingHorse = getIntInput();

							if (iBettingHorse >= 1 && iBettingHorse <= 5)
								break;
                            else
							    System.out.println("ERR");
						}

						System.out.println("배팅금액을 입력하세요(최소 5달러): ");
						while (true)
						{
							iBettingCash = getIntInput();

							if (iBettingCash >= 5 && iBettingCash <= bettor[count].m_iBettorCash)
								break;
                            else
							    System.out.println("ERR");
						}
						
				bettor[count].bettingCash(iBettingCash, iBettingHorse);
                count++;				
			}
			
			System.out.println("");
			System.out.println("경주를 시작합니다 !!!");
			System.out.println("");
            System.out.println("경주를 시작합니다 !!!");
			System.out.println("");
			System.out.println("경주를 시작합니다 !!!");

			try 
			{
				for (int i = 0; i < horses.length; i++)
				{
					horses[i] = new CHorse((i + 1) + "번말");
				}
			}
			catch (Exception e)
			{
				System.out.println("1 err");
			}
						
			CRunHorse rh = new CRunHorse();
						
			try 
			{
				rh.readyHorses(horses);
				rh.start();
			}
			catch (Exception e) 
			{
				System.out.println("2 err");
			}



			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
			}

			if (!rh.isFinish())
			{
				continue;
			}

			for (int i = 0; i < bettor.length;i++)
			{
				if (bettor[i].isWin(rh.getWinnerNum()))
			    {
				    bettor[i].makeMoney();
				    System.out.println(bettor[i].m_strBettorName + "님이 우승마를 맞췄습니다.");
			    } 
				else
				{
					System.out.println(bettor[i].m_strBettorName + "님은  우승마를 맞추지 못했습니다.");
				}
			}

			System.out.println(bettor[0].getName()+" Cash : $" + bettor[0].m_iBettorCash + " | " +
									bettor[1].getName()+ "Cash $: " + bettor[1].m_iBettorCash);
				
			rh = null;
			horses=null;
			System.gc();
			

			round++;
	    }
		
		if (bettor[0].m_iBettorCash > bettor[1].m_iBettorCash)
		{
			System.out.println("우승자는 "+bettor[0].m_strBettorName +"님 입니다.");
			System.exit(0);
		}
		else if (bettor[0].m_iBettorCash < bettor[1].m_iBettorCash)
		{
			System.out.println("우승자는 "+bettor[1].m_strBettorName +"님 입니다.");
			System.exit(0);
		}
		else
		{
			System.out.println("무승부 입니다.");
			System.exit(0);
		}

	}
	public static int getIntInput()
	{
		int iInput = 0;
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		while (true)
		{
			try
			{
//				iInput = Integer.parseInt(in.readLine());
				iInput = in.nextInt();
				break;
			} 
			catch (Exception e)
			{
				System.out.println("ERR2");
			}
		}
		return iInput;
	}
}