package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class 백만장자프로젝트3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 개수
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스 시~~~작@!
		for(int tc=1; tc<=T; tc++) { 
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//스택에 값 차곡차곡 채워넣기
			Stack<Integer> stack = new Stack<>();
			for(int i=0; i<N; i++) {
				stack.add(Integer.parseInt(st.nextToken()));
			}
			
			//계산 시작
			long result = 0;
			int max = 0;
			int cnt = 0;
			int cost = 0;
			
			while(!stack.isEmpty()) {
				//max = Math.max(max, stack.peek());
				if(stack.peek() == max) { //스택에 max 값이 나온다면 그 값 위에 담겼으니 pop해주기
					max = stack.pop();
				}else if(max > stack.peek()) {
					cnt++;
					cost += stack.pop();
				}else if(max < stack.peek()) { //max,cnt,cost 초기화 잊지말기
					result += max*cnt - cost;
					max = stack.pop();
					cnt = 0;
					cost = 0;
				}else {//그냥 스택이 비었어 뭐가 안 나오고
					break;
				}
			}
			result += max*cnt - cost;
			
			System.out.println("#" + tc + " " + result);
			
			
		}//테스트케이스 끝
	}
}