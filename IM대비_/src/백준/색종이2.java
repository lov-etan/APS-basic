package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2 {
	static int[][] arr = new int[100][100]; //가로x세로 100x100 도화지
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //색종이 수 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			inBoxing(x,y);
		}
		
		int area = 0;
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				area += arr[r][c];
			}
		}
		
		System.out.println(area);
	}
	
	static void inBoxing(int x, int y) {
		for(int r=x; r<x+10; r++) {
			for(int c=y; c<y+10; c++) {
				arr[r][c] = 1; //중복이 불가능하게끔 해당 값은 1로 고정 
			}
		}
	}

}
