package 백준;

import java.util.Scanner;

public class 빙고 {
	static int[][] Br;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Br = new int[5][5]; // 빙고판 만들기

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				Br[r][c] = sc.nextInt(); // 빙고판 채우기
			}
		}

		//int bingoCnt = 0; // 빙고 개수 세기 //위치가 잘못 //어차피 현재 배열로 빙고를 세는 거기 때문에 for 전에 선언하면 누적되어서 이전에 빙고개수 센 것과 더하여 출력된다. 
		for (int k = 1; k <= 25; k++) { // 사회자가 25개의 숫자를 부르기 시작함 //부르는 순서를 나타내기도 함 
			int num = sc.nextInt();
			// 그 숫자를 배열에서 찾아 0으로 바꿔줌
			check(num);
			
			int bingoCnt = cntBingo();
			
			if(bingoCnt >= 3) {
				System.out.println(k);
				break;
			}

		}
	}

	static void check(int num) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (Br[r][c] == num)
					Br[r][c] = 0;
			}
		}
	}

	static int cntBingo() {
		int bingoCnt =0;
		// 가로 방향 빙고
		for (int r = 0; r < 5; r++) {
			int cnt = 0; //빙고가 되려면 5가 되어야 함 
			for (int c = 0; c < 5; c++) {
				if(Br[r][c] == 0) {
					cnt++;
				if(cnt == 5) 
					bingoCnt++;
					
				}
			}
		}
		
		//세로 방향 빙고 
		for (int c = 0; c < 5; c++) {
			int cnt = 0; //빙고가 되려면 5가 되어야 함 
			for (int r = 0; r < 5; r++) {
				if(Br[r][c] == 0) {
					cnt++;
				if(cnt == 5) 
					bingoCnt++;	
				}
			}
		}
		
		//대각선 방향 빙고 
		int cnt =0; 
		for(int r=0; r<5; r++) {
			if(Br[r][r] == 0) {
				cnt++;
			if(cnt == 5) 
				bingoCnt++;	
			}
		}
		
		//부대각선 방향 빙고 
		cnt =0; 
		for(int r=0; r<5; r++) {
			if(Br[r][4-r] == 0) {
				cnt++;
			if(cnt == 5) 
				bingoCnt++;
			}
		}
		
		return bingoCnt;
	}//isBingo 끝 

}
