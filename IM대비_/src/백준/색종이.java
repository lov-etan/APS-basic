package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[1001][1001]; //평면 
		
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) { //i번째 색종이 겹치기 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); //너비
			int h = Integer.parseInt(st.nextToken()); //높이 
			
			inBoxing(i, x,y,w,h); 

			
		} //N번의 색종이 겹치기 끝 
		
		for(int i=1; i<=N; i++) {
			int area =0; //i번째 색종이가 보이는 면적 크기 
			
			for(int r=0; r<arr.length; r++) {
				for(int c=0; c<arr[0].length; c++) {
					if(arr[r][c] == i) {
						area++;
					}
				}
			}
			
			System.out.println(area);
		}
		
	}
	
	static void inBoxing(int i,int x, int y, int w, int h) {
		for(int r=x; r<x+w; r++) {
			for(int c=y; c<y+h; c++) {
				arr[r][c]=i; //해당 숫자를 넣는다. 그 숫자가 i번째 색종이가 보이는 면적 
			}
		}
	}

}
