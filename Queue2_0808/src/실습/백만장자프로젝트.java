package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class 백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int T = sc.nextInt(); //테스트 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) { //테스트 케이스 하나 시작
			//int N = sc.nextInt(); //미래를 볼 날짜 받기
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄 받아와서 토큰으로 자르기
			
			Queue<Integer> queue = new LinkedList<>();

			int maxSale = 0;
			for(int i=1; i<=N; i++) {
				//N일까지의 매매가 큐에 담기
				//int sale = sc.nextInt();
				int sale = Integer.parseInt(st.nextToken());
				queue.add(sale);
				//N일까지 중 가장 매매가가 큰 날 알기
				//N일 중에 제일 비싼 날에 털어줄 예정
				maxSale = Math.max(maxSale, sale); //만약 큐 뽑아주다가 maxSale값 만나면 뽑기 종료시켜야겠다..
			}
			
			//maxDay 전까지만 queue 털어주기
			int cost = 0;
			int cnt = 0;
			while(queue.peek()!=maxSale) {
				cost += queue.poll();
				cnt++;
			}
			
			//파는 날이 왔어요
			int result = maxSale*cnt - cost;
			
			System.out.println("#" + tc + " " + result);
			
		}//한 테스트 케이스 끝
	}
	
//	static void makingBenefit() {
//		
//	}

}
