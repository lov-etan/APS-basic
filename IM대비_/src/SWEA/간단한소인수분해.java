package SWEA;

import java.util.Scanner;

public class 간단한소인수분해 {
	
	static int dividing(int value, int num) { 
		int cnt =0;
		int result = value;
		
		while(result % num == 0) {
			result = result / num;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //소인수분해 할 숫자 N
			
			int a = dividing(N,2);
			int v = N / (int)Math.pow(2, a);
			int b = dividing(v,3);
			v = ( v /  (int)Math.pow(3, b));
			int c = dividing(v,5);
			v = ( v /  (int)Math.pow(5, c));
			int d = dividing(v,7);
			v = ( v /  (int)Math.pow(7, d));
			int e = dividing(v,11);
			v = ( v / (int)Math.pow(11, e));
			
			System.out.println("#" + tc + " " + a + " "+ b + " "+ c + " "+ d+ " " + e);
			
		}//테스트 케이스 끝
		
	}

}
