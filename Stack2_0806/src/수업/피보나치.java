package 수업;

public class 피보나치 {
	
	public static void main(String[] args) {
		
		//재귀함수
		int result = fibonacci(45); //4번 인덱스 -  0 1 1 2 3
		System.out.println(result); //3
		
		//반복문 - 시간 훨씬 덜 걸림
		int result2 = fibonacci2(45);
		System.out.println(result2);
		
		//mFibo 재귀함수 시간복잡도 문제해결 O(n)
		int mFiboResult = mFibo(45);
		System.out.println(mFiboResult);
		
	}
	
	//재귀함수
	static int fibonacci(int N) {
		if(N <= 1)
			return N;
		return fibonacci(N-1) + fibonacci(N-2);
	}
	
	//반복문
	static int fibonacci2(int N) {
		int[] arr = new int[N+1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i<=N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[N];
	}
	
	//Memoization
	
	static int[] dp = new int[500];
	
	static int mFibo(int N) {
		if(N <= 1)
			return N;
		if(dp[N] > 0)
			return dp[N]; //배열에 값이 저장되어 있다면 그것을 호출
		return dp[N] = mFibo(N-1) + mFibo(N-2);
		
	}
	

}
