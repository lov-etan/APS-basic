package 실습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//테스트 케이스의 수
		
		for(int tc=1; tc<=T; tc++) {//한 테스트케이스
			int N = sc.nextInt(); //카드 개수

			//큐 두 개로 나누어 카드 채워주기
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			int ifNisOdd = (N+1)/2 ; //홀수일 경우에는 한 장 더 가져가야 함
			for(int i=0; i<ifNisOdd; i++) {
				String card = sc.next();
				queue1.add(card);//선입선출
			}
			
			for(int i=0; i<N/2; i++) {
				String card = sc.next();
				queue2.add(card);
			}
			
			
			//큐 두 개를 번갈아서 하나씩 poll 해주기 //언제까지? 큐가 빌 때까지
			System.out.print("#" + tc + " ");
			while(!queue1.isEmpty() || !queue2.isEmpty()){
				if(!queue1.isEmpty()) {
					System.out.print(queue1.poll() + " ");
				}
				if(!queue2.isEmpty()) {
					System.out.print(queue2.poll() + " ");
				}
			}
			System.out.println();
		}
		
	}

}
