package swea;

import java.util.Scanner;
import java.util.Stack;

public class 제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); //테스트 케이스 개수
		
		for(int tc=1; tc<=TC; tc++){
			int K = sc.nextInt(); //K개의 줄 등장 예정
			int[] arr = new int[K];
			int sum = 0; //재민이가 받아 적은 수의 합
			//Stack<Integer> stack = new Stack<>(); //stack.pop() stack.push(num)

			for(int i=0; i< K; i++) {//K만큼 수 받을거야 //동시에 채워넣을거야
					arr[i] = sc.nextInt();
			}//배열 채워넣기 끝 //디버깅-for문 쓸데없이 두 번 돌림
			
			//[i]가 0이라면 i보다 작은 idx범위를 설정하고 0이 아닌 값을 0으로 바꿔주기
			for(int i=1; i<K; i++) {
				if(arr[i]==0) {
					for(int j=i-1; j>=0; j--) {
						if(arr[j] != 0) {
							arr[j] =0;
							break;
						} else {
							continue;
						}
					}
						
				}
			}// 값 바꿔주기 끝
			
			//배열의 합 구하기
			for(int i=0; i<K; i++) {
				sum += arr[i];
			}
			
			//테스트 케이스 결과 출력
			System.out.println("#" + tc + " " + sum);
			
			
		}//한 테스트 케이스 끝
	}

}
