import java.util.ArrayList;

public class SelfNumber {

	public static void main(String[] args) {
		//어떤 자연수 n이 있을 때 d(n)을 n의 각 자릿수 숫자들과 n자신을 더한 숫자라고 정의하자
		// 예를들어 d(91) = 9 + 1 + 91 = 101
		// 이때 n을 d(n)의 제네레이터라고 한다.
		// 위의 예에서 91은 101의 제네레이터이다.
		// 제네레이터가 없는 숫자를 구해라
		ArrayList<Integer> n = new ArrayList<Integer>();
		for (int i = 1; i<50; i++)
		{
			n.add(i);
		}
		
		
	    for (int i = 1; i < 5000; i++) 
	    {
	    	int thousand = i/1000;
			int hundred = i%1000/100;
			int ten = i%1000%100/10;
			int one = i%1000%100%10;
			int dn;
			dn = thousand + hundred + ten + one + i;
			n.remove((Integer)dn);
	    }
		
	    System.out.println(n);
	    
//		int i = 1092;
//		int length = (int)(Math.log10(i)+1);
//		System.out.println(length);
//		int thousand = i/1000;
//		int hundred = i%1000/100;
//		int ten = i%1000%100/10;
//		int one = i%1000%100%10;
//        System.out.println(thousand);
//        System.out.println(hundred);
//        System.out.println(ten);
//        System.out.println(one);
        
        
	    
	    
        
        
	}

}
