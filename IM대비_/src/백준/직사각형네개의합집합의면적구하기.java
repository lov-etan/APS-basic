package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형네개의합집합의면적구하기 {
	static int[][] Br;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Br = new int[100][100];
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); //1 2 4 4 (좌표 받아오기) 
			int x1 = Integer.parseInt(st.nextToken()); 
			int y1 = Integer.parseInt(st.nextToken()); 
			int x2 = Integer.parseInt(st.nextToken()); 
			int y2 = Integer.parseInt(st.nextToken()); 
			
			inBoxing(x1, y1, x2, y2);
		}
		
		int boxCnt = 0; 
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(Br[r][c] == 1) {
					boxCnt++;
				}
			}
		}
		
		System.out.println(boxCnt);
	}
	
	static void inBoxing(int x1, int y1, int x2, int y2) {
		for(int i=x1; i<x2 ; i++) {
			for(int j=y1; j<y2; j++) {
				Br[i][j] = 1;
			}
		}
	}
	

}
