package swea_Day03;

import java.util.Arrays;
import java.util.Scanner;

public class Array3_2001 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//테스트 개수만큼 반복 시작
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
		int N = sc.nextInt(); //넓은 N
		int M = sc.nextInt(); //파리채
		
		int map[][] = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				//NxN map에 값 채워넣기
				map[r][c] = sc.nextInt();
				}
			}
		//최대 합을 저장할 변수 초기화
		int maxSum = 0;
		
		//MxM 부분 배열의 합 계산 및 최대 합 갱신
		//i~i+(M-1)만큼씩 뽑아서 해당 값 더하기
		for(int r=0; r<=(N-M); r++) { //mm 배열 시작점 //5-3=2 근데 3개 돌아가야 하니까 = 표시 붙여서 케이스 빶빔없이 다 포함시켜주기
			for(int c=0; c<=(N-M); c++) {
				int tmp = 0;
				for(int j=r; j<r+M ; j++) {
					for(int k=c; k<c+M; k++) {
						tmp += map[j][k];
					}
				}
				if(tmp>maxSum)
					maxSum = tmp;
				}
			}
		System.out.println("#" +(i+1) + " " + maxSum );
		}
		
	}
			
}
	
