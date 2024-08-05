package swea_Day04_String;

import java.util.Arrays;
import java.util.Scanner;

public class swea1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//100개의 행, 100개의 열, 2개의 대각선 총 202번의 계산
		
		//총 10개의 테스트 케이스가 주어짐
		for(int tc=0; tc<10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			//100x100 배열에 입력값 채워넣기
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			//최종 max 값 지정
			int max = 0;
			//'100개의 행'의 합과 max 값 비교
			for(int r=0; r<100; r++) {
				int tmp = 0;
				for(int c=0; c<100; c++) {
					tmp += arr[r][c];
				} //끝 열까지 다 돌고 나서 max 값과 비교해주는게 정수
				if(tmp > max)
					max = tmp;
			}
			
			//'100개의 열'의 합과 max 값 비교
			for(int c=0; c<100; c++) {
				int tmp =0;
				for(int r=0; r<100; r++) {
					tmp += arr[r][c];
				}
				if(tmp > max)
					max = tmp;
			}
			
			//'1개의 대각선" 합과 max 값 비교
			int tmp =0; //tmp가 for문 밖에서 선언되어야 함_대각선은 어차피 하나 //for문 안에 있으면 다음 대각선으로 갈 때마다 숫자가 초기화 됨.. <- 대각선 열 다 합 구해야 하는데 앞 값 다 초기화 한 꼴
			for(int r=0; r<100; r++) {
				tmp += arr[r][r];
			}
			if(tmp > max)
				max = tmp;
			
			tmp =0; //위에서 이미 선언해준 수이니까 초기화 다시 해주기
			//'1개의 부대각선'합과 max 값 비교
			for(int r=99; r>=0; r--) {
				tmp += arr[r][99-r]; //거꾸로 타고있다는 것 인식하기!!!!!
			}
			if(tmp > max)
				max = tmp;
			
			System.out.println("#" + T + " " + max);
		}//한 테스트케이스 for문 끝	
		
		
	}
}
