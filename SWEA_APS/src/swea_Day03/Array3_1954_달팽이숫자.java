package swea_Day03;

import java.util.Scanner;

public class Array3_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		//테스트 케이스만큼 해당 반복문을 돌리겠다.
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt(); //N*N 배열 만들어야지~
			int arr[][] = new int[N][N];
			
			//배열 채우기 시작전에 int 선언해두기~
			int cnt = 1; //배열에 찍히게 될 수 (++ 하며 커질 예정)
			int r = 0;
			int c = 0; //(0,0) 부터 출발
			int d = 0; //우(0) 하(1) 좌(2) 상(3)
			
				//    우 하 좌 상
			int dr[] = {0,-1,0,1};
			int dc[] = {1,0,-1,1};
			
			
			
			//N*N 배열 채우기 시작! 달팽이처럼 가보자
			while(cnt++ < N*N) {
				
			}
			
			
			
			}	
		
	}

}
