package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 러시아국기같은깃발2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		//테스트케이스 시~~작@!!
		for(int tc=1; tc<=T; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //행의 개수 N 받기
			int M = Integer.parseInt(st.nextToken()); //열의 개수 M 받기
			
			//제시된 마구잡이 색깔 판 받아오기
			Character[][] arr = new Character[N][M];
			for(int r=0; r<N; r++) {
				String line = br.readLine();
				for(int c=0; c<M; c++) {
					arr[r][c] = line.charAt(c);
				}
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			//완전탐색
			//모든 행 돌면서 색 다 바꿔보고 제일 최소로 바꾸는 cnt 수 알아보기
			int minCnt = Integer.MAX_VALUE;
			
			for(int w=0; w<N-2; w++) {
				for(int b=w+1;b<N-1; b++ ) {
					for(int r=b+1; r<N; r++) { //행의 색깔을 정하고 시작함
						
						int cnt=0; //해당 행까지 돌면서 바꾸는 칸 개수 세기
						
						for(int row=0; row<=w; row++) {
							for(int col=0; col<M; col++ ) {
								if(!arr[row][col].equals('W')) {
									cnt++;
								}
							}
						}
						
						for(int row=w+1; row<=b; row++) {
							for(int col=0; col<M; col++ ) {
								if(!arr[row][col].equals('B')) {
									cnt++;
								}
							}
						}
						
						for(int row=b+1; row<N; row++) { //마지막행은 무조건 끝까지 돌려줘야 함
							for(int col=0; col<M; col++ ) {
								if(!arr[row][col].equals('R')) {
									cnt++;
								}
							}
						}
						
						minCnt = Math.min(cnt, minCnt);
					}
					
				}
			}
		
			System.out.println("#" + tc + " " + minCnt);
			
		}//테스트케이스끝!
		
	}

}
