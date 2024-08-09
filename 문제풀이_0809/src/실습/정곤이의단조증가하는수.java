package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 정곤이의단조증가하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//테스트케이스 개수
		
		for(int tc=1; tc<=T; tc++) { //테스트케이스 시작
			int N = sc.nextInt(); // 양의 정수 N개 주어짐
			
			//N크기의 배열 생성
			int[] nums = new int[N];
			
			//배열 제공된 정수로 채워주기
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//System.out.println(Arrays.toString(nums));
			
			//두 수 곱하기 한 결과값 중 단조 증가하는 수, 그리고 그것들의 최댓값을 구해보겠다.
			int max = -1; //단조 증가하는 수가 없다면 -1을 출력해야 하므로!!!!!
			for(int i=0; i<N; i++){
				for(int j=i+1; j<N; j++){
					String multipliedStr = Integer.toString(nums[i]*nums[j]);
					if(isIncreasing(multipliedStr)) {//단조 증가하는 수가 맞다면 해당 수와 max값 비교
						max = Math.max(max, Integer.parseInt(multipliedStr));
					}else {
						continue;
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
			
			
		}//테스트케이스 끝
	}
	
	static boolean isIncreasing(String str) {
		for(int k=0; k<str.length()-1; k++) {
			if(str.charAt(k)-'0' > str.charAt(k+1)-'0') {
				return false; //단조 증가하는 숫자를 하나라도 만족하지 못하면 false
			}
		}
		return true; //모든 자리 숫자가 단조 증가하는 수를 만족하면 true 반환
	}

}
