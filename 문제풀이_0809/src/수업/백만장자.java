package 수업;

import java.util.Arrays;
import java.util.Scanner;

public class 백만장자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int[] price = new int[N];
			
			for(int i=0; i<N; i++) {
				price[i] = sc.nextInt();
			}
			
			int answer = 0;
			
			int[] max = new int[N];
			max[N-1] = price[N-1];
			for(int i=N-2; i>=0;i--) {
				max[i] = Math.max(price[i], max[i+1]);
				answer += max[i] - price[i];
			}
			//System.out.println(Arrays.toString(max));
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
