package Racing;

import java.io.*;
import java.util.Scanner;

class TMain
{
	public static void main(String[] args)
	{

		int iBettingHorse, iBettingCash = 100;

		CBettor[] bettor = new CBettor[2];

		bettor[0] = new CBettor("����", iBettingCash);
		bettor[1] = new CBettor("����", iBettingCash);


		
		int round = 1;
		
		while (round < 4)  // ���� �ݺ�
		{	
			// �ʱ� �ں� ���
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------------------------------------------");
			System.out.println("*****                    "+round+"���� �Դϴ�.                   *****");
			System.out.println("------------------------------------------------------------");
			System.out.println(bettor[0].getName()+" Cash : $" + bettor[0].m_iBettorCash + " | " +
					bettor[1].getName()+ "Cash : $" + bettor[1].m_iBettorCash);
			CHorse[] horses = new CHorse[5]; 
	        
	        
			
			
			// �÷��̾� ����
			int count = 0;
			while (count < 2)
			{
				System.out.println();
				System.out.println(bettor[count].getName()+" �����Դϴ�.");
	
						System.out.println("���� ���� �ϼ���(1~5): ");
						while (true)
						{
							iBettingHorse = getIntInput();

							if (iBettingHorse >= 1 && iBettingHorse <= 5)
								break;
                            else
							    System.out.println("ERR");
						}

						System.out.println("���ñݾ��� �Է��ϼ���(�ּ� 5�޷�): ");
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
			System.out.println("���ָ� �����մϴ� !!!");
			System.out.println("");
            System.out.println("���ָ� �����մϴ� !!!");
			System.out.println("");
			System.out.println("���ָ� �����մϴ� !!!");

			try 
			{
				for (int i = 0; i < horses.length; i++)
				{
					horses[i] = new CHorse((i + 1) + "����");
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
				    System.out.println(bettor[i].m_strBettorName + "���� ��¸��� ������ϴ�.");
			    } 
				else
				{
					System.out.println(bettor[i].m_strBettorName + "����  ��¸��� ������ ���߽��ϴ�.");
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
			System.out.println("����ڴ� "+bettor[0].m_strBettorName +"�� �Դϴ�.");
			System.exit(0);
		}
		else if (bettor[0].m_iBettorCash < bettor[1].m_iBettorCash)
		{
			System.out.println("����ڴ� "+bettor[1].m_strBettorName +"�� �Դϴ�.");
			System.exit(0);
		}
		else
		{
			System.out.println("���º� �Դϴ�.");
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