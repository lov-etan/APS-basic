package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class 백만장자프로젝트2 {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int T = sc.nextInt(); //테스트 개수
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스 시~~~작@!
		for(int tc=1; tc<=T; tc++) { 
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			//정렬되지 않은 데이터 받아오기 (배열의 크기: N)
			int[] unsorted = new int[N];
			for(int i=0; i<N; i++) {
				unsorted[i] = Integer.parseInt(st.nextToken());
			}
			
			//sorted 배열은 숫자 크기에 따라 숫자 재정렬하기 (Max 값 갱신할 때 사용할 것임)
			Integer[] sorted = new Integer[N];
			for(int i=0; i<N; i++) {
				sorted[i] = unsorted[i];
			}
			Arrays.sort(sorted, Collections.reverseOrder()); //이제 제일 큰 수를 알 수 있게 됨!
			//System.out.println(Arrays.toString(sorted)); 
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0; i<N; i++) {
				queue.add(unsorted[i]);
			}
			
			int cost = 0; //비용
			int cnt = 0; //판매 개수
			long result = 0; //최대 이익
			int i=0;
			
			while(!queue.isEmpty()) { //큐가 빌 때까지 반복하기
				while(queue.peek() != sorted[i]) { //front값이 최댓값일 때까지 반복
					cost += queue.poll();
					cnt++;
				}
				result += queue.poll()*cnt - cost; //최대매매가*개수 - 원가
				cost =0;
				cnt=0;
				i++;
				
			}
			
			System.out.println("#" + tc + " " + result);
			
		}//한 테스트 케이스 끝
	}
	

}
