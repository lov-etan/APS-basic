package D2;

import java.util.Scanner;

public class 두개의숫자열 {
	
	static int[] A;
	static int[] B;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			for(int j=0; j<M; j++) {
				B[j] = sc.nextInt();
			}
			
			System.out.print("#" + tc + " ");
			if(N<=M) {
				System.out.print(multiSum(A, B, N,M));
			} else {
				System.out.print(multiSum(B, A, M,N));
			}
			System.out.println();
			
			
		}
	}
	
	static int multiSum(int[] Sh, int[] Lng, int S, int L) {
		int maxSum =-1;
		for(int j=0; j<=L-S; j++) { //전체적인 시작점과 끝 점
			int sum = 0; //S개의 숫자 합 더할거임
			for(int i=0; i<S; i++) { //S개 더하기 시작
				sum += Lng[j+i]*Sh[i];
			}
			maxSum = Math.max(maxSum, sum); //shorter만큼 쪼개진 것 중에 제일 큰 수 구하기
		}
		return maxSum;
	} 

}
