package Racing;

import java.io.*;
import java.util.Scanner;

class CMain
{
	public static void main(String[] args)
	{

		int iBettingHorse, iBettingCash = 100;

		CBettor[] bettor = new CBettor[2];

		bettor[0] = new CBettor("정현", iBettingCash);
		bettor[1] = new CBettor("혜원", iBettingCash);
//		bettor[2] = new CBettor("Tom", iBettingCash);

		
		int round = 1;
		
		while (true)
		{	
			// 초기 자본 출력
			
			System.out.println(round+"라운드 입니다.");
			System.out.println(bettor[0].getName()+" Cash : $" + bettor[0].m_iBettorCash + " | " +
					bettor[1].getName()+ "Cash : $" + bettor[1].m_iBettorCash);
			CHorse[] horses = new CHorse[5]; 
	        
	        
			
			while (true) // 라운드 반복
			{
				
				try
				{
					System.out.println();
					System.out.println("배팅을 시작합니다.");
					System.out.println("1.정현   2.혜원    3.게임시작     4.나가기");
					System.out.println("배터을 선택하세요: (전부 선택했으면 3으로 게임 시작) ");

					int iInput = getIntInput();

					switch (iInput)
					{
						case 1:
						{
							System.out.println("배터는 정현입니다.");
							System.out.println("말을 선택 하세요(1~5): ");
							while (true)
							{
								iBettingHorse = getIntInput();

								if (iBettingHorse >= 1 && iBettingHorse <= 5)
									break;

								System.out.println("ERR");
							}

							System.out.println("배팅금액을 입력하세요(최소 5달러): ");
								while (true)
								{
									iBettingCash = getIntInput();

									if (iBettingCash >= 5 && iBettingCash <= bettor[0].m_iBettorCash)
										break;

									System.out.println("ERR");
								}
						
								bettor[0].bettingCash(iBettingCash, iBettingHorse);
								break;
						}

						case 2:
						{
							System.out.println("배터는 혜원입니다.");
							System.out.println("말을 선택 하세요(1~5): ");
							while (true)
							{
								iBettingHorse = getIntInput();

								if (iBettingHorse >= 1 && iBettingHorse <= 5)
									break;

								System.out.println("ERR");
							}

							System.out.println("배팅금액을 입력하세요(최소 5달러): ");
								while (true)
								{
									iBettingCash = getIntInput();

									if (iBettingCash >= 5 && iBettingCash <= bettor[1].m_iBettorCash)
										break;

									System.out.println("ERR");
								}
						
								bettor[1].bettingCash(iBettingCash, iBettingHorse);
								break;
						}

//						case 3:
//						{
//							System.out.println("배터는 Tom입니다.");
//							System.out.println("말을 선택 하세요(1~5): ");
//							while (true)
//							{
//								iBettingHorse = getIntInput();
//
//								if (iBettingHorse >= 1 && iBettingHorse <= 5)
//									break;
//
//								System.out.println("ERR");
//							}
//
//							System.out.println("배팅금액을 입력하세요(5~15): ");
//								while (true)
//								{
//									iBettingCash = getIntInput();
//
//									if (iBettingCash >= 5 && iBettingCash <= 15)
//										break;
//
//									System.out.println("ERR");
//								}
//						
//								bettor[2].bettingCash(iBettingCash, iBettingHorse);
//								break;
//						}

					case 3:
					{
						try {
						for (int i = 0; i < horses.length; i++)
						{
							horses[i] = new CHorse((i + 1) + "번말");
						}
						}
						catch (Exception e){
							System.out.println("1 err");
						}
						
						CRunHorse rh = new CRunHorse();
						
						try {
						rh.readyHorses(horses);
						rh.start();
						}
						catch (Exception e) {
							System.out.println("2 err");
						}

						while (true)
						{
							try
							{
								Thread.sleep(1000);
							}
							catch (InterruptedException e)
							{
							}

							if (!rh.isFinish()){
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
//							System.out.println("Bob Cash : " + bettor[0].m_iBettorCash + " | Joe Cash : " + bettor[1].m_iBettorCash 
//									+ " | Tom Cash : " + bettor[2].m_iBettorCash);
							System.out.println(bettor[0].getName()+" Cash : $" + bettor[0].m_iBettorCash + " | " +
									bettor[1].getName()+ "Cash $: " + bettor[1].m_iBettorCash);
							break;
						}
						rh = null;
						horses=null;
						System.gc();
						break;
					}

					case 4:
					{
						System.exit(0);
					}

					default:
						System.out.println("ERR_default");
					}
				}
				
				catch (Exception e)
				{
					System.out.println("ERR_run_try");
				}
				
				round++;
				if (round < 4)
				    break; // 요게 빠져있어서 계속 두번째 while문만 돌았음
				else
					System.exit(0);
			}	
			
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
