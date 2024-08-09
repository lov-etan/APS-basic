package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			String line = sc.next(); //라인으로 받아오기
			int N = line.length(); //메모리 길이(배열의 크기)
			
			int[] origin = new int[N]; //원래 배열
			int[] reset = new int[N]; //초기화된 배열
			
			//정답 배열 값 넣어주기
			for(int i=0; i<N; i++) {
				origin[i] = line.charAt(i)-'0'; //'0' 빼주는거 절대 잊지 말기!!
			}
			
			//System.out.println(Arrays.toString(origin));
			//System.out.println(Arrays.toString(reset));
			
			int cnt = 0; //수정횟수
			
			//reset 배열 바꿔주면서 수정 횟수 세기
			for(int i=0; i<N; i++) {
				if(origin[i] == reset[i]) { //기존과 초기화 배열 자리에 같은 수가 있으면
					//pass
					continue;
				} else { 
					//기존과 초기화 값 다르면 -> 그 값으로 초기화 값 N-1배열까지 밀어줘야 함
					//cnt++도 같이
					for(int j=i; j<N; j++) {
						reset[j] = origin[i];
					}
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
			
			
			
		}//한 테스트케이스 끝
		
		
		
	}

}
