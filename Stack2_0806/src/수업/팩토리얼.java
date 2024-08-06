package 수업;

public class 팩토리얼 {
	public static void main(String[] args) {
		
		System.out.println(factorial1(10));
		
		System.out.println(factorial2(10));
		
	}
	
	//1부터 N까지의 곱을 return
	static int factorial1(int N) {
		
		int result = 1;
		for (int i=1; i<= N; i++) {
			result *= i;
		}
		return result;
	}
	
	
	
	//재귀함수로 구현해보겠다
	static int factorial2(int N) {
		//기저 조건 필요
		if(N == 0 || N==1)
			return 1;
		return N * factorial2(N-1); //이것만 있으면 스택 오버플로우 발생
	}

	
	
}
