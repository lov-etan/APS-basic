package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N*M]; //하나하나씩 더하기 수행
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					arr[n*M+m] = (n+1)+(m+1);
				}
			}
			
			int[] count = new int[N+M+1]; //더하기 값을 인덱스로 갖는 count배열 생성
			for(int i=0; i<arr.length; i++) {
				count[arr[i]]++;
			}
			
			int maxPos = 0;
			for(int i=0; i<count.length; i++) { //등장할 확률이 가장 높은 것들을 출력
				maxPos = Math.max(maxPos, count[i]);
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<count.length; i++) {
				if(count[i] == maxPos) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
		}
	}

}
