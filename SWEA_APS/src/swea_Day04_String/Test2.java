package swea_Day04_String;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//sc.nextLine(); //개행 문자 제거: nextInt()로 하고 난 후, 나머지 /n가 남아있었음
		
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			//String을 배열로 바꿔주기
			char[] charArr = str.toCharArray();
			
			int N = charArr.length;
			int cnt = 0;
			//boolean isPalindrome = true;
			for(int i=0; i<N/2 ; i++) {
//				if(charArr[i] != charArr[(N-1)-i]) {
//					isPalindrome = false;
//					break;
//				}	
//			}
			
//			System.out.println("#" + tc + " " + (isPalindrome ? 1:0));
			
			
			
			if(charArr[i] == charArr[(N-1)-i]) {
					cnt++;
				}
			}
			System.out.print("#" +tc + " ");
			if(cnt == N/2) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			System.out.println();
			
			
			
			
		}//테스트케이스 for문
	}

}
