package swea_Day02;

import java.util.Arrays;
import java.util.Scanner;

public class Array2_1204 {
	public static void main(String[] args) throws Exception {
		//최빈수 구하기
		Scanner scanner = new Scanner(System.in);
		//테스트 케이스의 수
		int T = scanner.nextInt();
		
		
		//한 테스트 케이스씩 1000명이 담긴 배열 만들기
		for(int i=0; i<T; i++) {
			//테스트 케이스의 번호
			int N = scanner.nextInt();
			int[] scores = new int[1000];
			for(int j=0; j<1000; j++) {
				scores[j] = scanner.nextInt();
			}
			findAMode(scores);
			//System.out.println(Arrays.toString(scores));
			System.out.println("#" + N + " " + findAMode(scores));
		}
		
	}
	
	static int findAMode(int[] arr) {
		//1.원소의 범위(최댓값K) 확인
		int K = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > K)
				K = arr[i];
		}
		
		//2.count 배열을 통해 원소 count
		int[] count = new int[K+1];
		
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		//3.i=점수/ count[i]가 가장 큰 i가 최빈값
		int cnt = -1;
		int mode = 0;
		for(int i=0; i<count.length; i++) {
			if(count[i] >= cnt ) {//>= 해주면 최빈수가 여러 개 일 때 가장 큰 점수로 출력할 수 있을 것임
				cnt = count[i];
				mode = i;
			}
		}
		return mode;
		

	}//함수끝
	
}
