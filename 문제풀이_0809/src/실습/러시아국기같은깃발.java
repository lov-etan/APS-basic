package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 러시아국기같은깃발 {
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
			int minCnt=51;
			minCnt = Integer.MAX_VALUE;
			//흰색이 될 수 있는 행은 뒤에 두 개는 무조건 못 칠헤
			for(int w=0; w<N-2; w++) {
				int cntToWhite = 0;
				int cntToBlue =0;
				int cntToRed=0;
				int sum = 0;
				
				for(int c=0; c<M; c++) {//해당 행에서 w 아닌거 색 바꿔주기~
					if(!arr[w][c].equals('W')) {
						cntToWhite++;
					}
				}
				sum += cntToWhite;
				//System.out.println("cntToWhite" + sum);
				
				for(int b=w+1; b<N-1; b++) {
					for(int c=0; c<M; c++) {//해당 행에서 b 아닌거 색 바꿔주기~
						if(!arr[b][c].equals('B')) {
							cntToBlue++;
						}
					}
					sum += cntToBlue;
					//System.out.println("cntToBlue" + sum);
					
					for(int r=b+1; r<N; r++) {
						for(int c=0; c<M; c++) {
							if(!arr[r][c].equals('R')) {
								cntToRed++;
							}
						}
						//System.out.println("cntToRed" + sum);
					}sum += cntToRed;
				}
				minCnt = Math.min(sum, minCnt);
				//System.out.println("minCnt" + minCnt);
				
			}//for문 다 돌음
			System.out.println("#" + tc + " " + minCnt);
			
		}//테스트케이스끝!
		
	}

}
