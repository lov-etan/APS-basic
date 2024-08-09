package 수업;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 농작물수확하기 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input (21).txt"));
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) { //테스트케이스 시작
			
			int N = sc.nextInt(); //농장의 크기
			
			int[][] board = new int[N][N];
			
			for( int r=0; r<N; r++) {
				String line = sc.next();
				for(int c=0; c<N; c++) {
					board[r][c] = line.charAt(c)-'0';
				}
			}
			
			int sum = 0; //순회하며 탐색한 값을 더해줄 것임
			//열번호 범위
			int start = N/2;
			int end = N/2;
			
			for(int r=0; r<N; r++) {
				for(int c=start; c<=end; c++) {
					sum += board[r][c];
				}
				
				if(r<N/2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
				
			}
			
			System.out.println("#" + " " + sum);
			
			
			
			
		}//테스트 케이스 끝
	}

}
