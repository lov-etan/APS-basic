package 실습;

import java.util.Scanner;

public class 거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=10; i++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = power(N,M);
			System.out.println("#" + tc + " " + result);
			
		}//한 테스트케이스 끝
		
	}
	
	//거듭제곱 재귀함수
	static int power(int N, int M) {
		
		if(M == 0)
			return 1;
		
		M--;
		return N * power(N,M);
	}

}
