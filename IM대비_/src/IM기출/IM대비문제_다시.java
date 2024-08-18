package IM기출;

import java.util.Arrays;
import java.util.Scanner;

public class IM대비문제_다시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt(); //학생수
			int min = sc.nextInt(); //반 학생 수 최소값
			int max = sc.nextInt(); //반 학생 수 최대값
			
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
			}
			
			Arrays.sort(score);
			
			//index가 0~100점을 뜻하는 카운팅 배열
			int[] count = new int[101];
			for(int i=0; i<N; i++) {
				count[score[i]]++;
			}
			
			
			int result = Integer.MAX_VALUE;
			for(int s1=0; s1<100; s1++) {
				for(int s2=s1+1; s2<=100; s2++) {
					//기준 스코어 지정해주기
					
					int maxGroup = -1;
					int minGroup = Integer.MAX_VALUE;
					
					int a = 0;
					int b = 0;
					int c = 0;
					
					for(int i=0; i<s1; i++) {
						a += count[i];
					} for(int j=s1; j<s2;j++) {
						b += count[j];
					} for(int k=s2; k<count.length;k++) {
						c += count[k];
					}
					
					if( a>=min && a<=max && b>=min && b<=max && c>=min && c<=max) {
						maxGroup = Math.max(a, Math.max(b, c));
						minGroup = Math.min(a, Math.min(b, c));
						
						result = Math.min(result, maxGroup - minGroup);
					}
					
					
				}
			}
			
			
			if(result == Integer.MAX_VALUE) {
				System.out.println("#" + tc + " " + -1 );
			} else {
				System.out.println("#" + tc + " " + result );
			}
				
			
			
			
		}
		
	}

}
