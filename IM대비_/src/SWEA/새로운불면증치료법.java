package SWEA;

import java.util.Scanner;

public class 새로운불면증치료법 {
	static int[] zeroToNine = new int[10];; //0-9까지 등장 숫자 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			zeroToNine = new int[10]; //배열 새로 선언
			
			int N = sc.nextInt();
			int k = 1;
			String number = Integer.toString(k*N);
			
			while(!isAllAppeared(number)) { //while(false) !!!!!!!!!!
				k++;
				number= Integer.toString(k*N);
			}
			
			System.out.println("#" + tc + " " + k*N);
			
			
			
		
		}//테스트케이스 끝
	}
	
	static boolean isAllAppeared(String number) {
		//카운팅배열로 해주기
		for(int i=0; i<number.length(); i++) {
			zeroToNine[number.charAt(i)-'0']++; //카운팅배열시 값만 하나씩 올라가는거 잊지말기!!!
		}
		
		for(int i=0; i<10; i++) {
			if(zeroToNine[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
