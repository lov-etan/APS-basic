package 수업;

import java.util.Scanner;

public class ㅇㅇ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 개수 입력 받기
		for(int tc=1; tc<=T; tc++) { //입력받은 테스트 케이스 개수만큼 반복
			
			int N = sc.nextInt();
			//N*N 배열칸 만들기
			int[][] arr = new int[N][N];
			
			int r = 0; //행의 좌표
			int c = 0; //열의 좌표
			int cnt = 1; //배열칸에 넣을 수(1부터 시작)
			
			int d = 0; //델타 배열의 초기 인덱스 설정
			// 반시계방향 달팽이 숫자 입력시 '방향' 설정할 델타 배열
			//          하 우 상 좌
			int[] dr = {1,0,-1,0}; 
			int[] dc = {0,1,0,-1};
			
			
			//배열칸 숫자 채워넣기 시작
			while(cnt <= N*N) { //달팽이 숫자는 cnt 값이 N*N이 될 때까지 반복문을 돌며 숫자가 입력됨
				arr[r][c] = cnt; 
				cnt++;
				
				//다음 좌표 임시 설정
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				//그런데, 다음 좌표가 배열을 벗어나거나 숫자 0이 아닌 다른 수로 이미 채워져 있다면, 방향을 바꿔줘야 함 
				if( nr<0 || nr>=N || nc<0 || nc>=N || arr[nr][nc] != 0) {
					d = (d+1)%4; //방향을 바꿔줘야 하므로 d+1을 해줌 // 델타배열 인덱스는 0부터 3까지만 나올 수 있음
					//d값을 이용하여 방향을 하, 우, 상, 좌 순으로 바꿔준 후 좌표값 조정하기
					nr = r + dr[d];
					nc = c + dc[d];
				}
				
				//확정된 다음 좌표 값
				r = nr;
				c= nc;
				
			}//숫자 채워넣기 끝
			
			//반시계방향 달팽이 숫자로 완성된 배열 출력
			System.out.println("#" + tc);
			for(r=0; r<N; r++) {
				for(c=0; c<N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
			
			
			
			
			
		}//한 케이스 끝
	}

}
