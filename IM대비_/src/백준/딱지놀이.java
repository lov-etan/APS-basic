package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딱지놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 총 라운드 수

		for (int rd = 0; rd < N; rd++) { // 라운드 시작!
			StringTokenizer st = new StringTokenizer(br.readLine()); // A카드 정보

			int a = Integer.parseInt(st.nextToken());
			int[] aCount = new int[5]; // a의 그림을 담은 카운팅배열 //[0, 세모, 네모, 동그라미, 별]
			for (int i = 0; i < a; i++) {
				int shape = Integer.parseInt(st.nextToken());
				aCount[shape]++;
			}

			st = new StringTokenizer(br.readLine()); // B카드 정보

			int b = Integer.parseInt(st.nextToken());
			int[] bCount = new int[5]; // b의 그림을 담은 카운팅배열 //[0, 세모, 네모, 동그라미, 별]
			for (int i = 0; i < b; i++) {
				int shape = Integer.parseInt(st.nextToken());
				bCount[shape]++;
			}
			
			//승패 가리기 시작! 
			if(comp(aCount, bCount, 4) != 'D') {
				System.out.println(comp(aCount, bCount, 4));
			} else if(comp(aCount, bCount, 3) != 'D') {
				System.out.println(comp(aCount, bCount, 3));
			} else if(comp(aCount, bCount, 2) != 'D') {
				System.out.println(comp(aCount, bCount, 2));
			} else {
				System.out.println(comp(aCount, bCount, 1));
			}
			

		}//라운드 끝!

	}
	
	static char comp(int[] ar, int[] br, int S) { //그냥 4,3,2,1 내려가면 for 루프 돌리면 S 안 받아도 됨 
		char result;
		if(ar[S] > br[S]) {
			result = 'A';
		} else if (ar[S] < br[S]) {
			result = 'B';
		} else {
			result = 'D';
		}
		return result;
	}

}
