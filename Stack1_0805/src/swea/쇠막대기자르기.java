package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 수 T
		
		for(int tc=1; tc<=T; tc++) {
			String test = br.readLine();
			int N = test.length();
			int result = 0; //만들어진 총 막대기 갯수
			int cnt =0; //진행 중인 막대기 수
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<N; i++) {
				char c = test.charAt(i); //괄호 하나씩 받아오기
				
				//만약 '(' 열린 괄호가 들어오면 
				// 1. 바로 옆에 ')'가 있는지 검사 -> 지금까지의 cnt 검사 후 result에 넣기
				// 2. 없으면 -> stack에 쌓는다 (막대기 생성 즉, cnt++)
				if(c == '(' ) {
					if(test.charAt(i+1) == ')') {
						result += cnt;
					} else {
						stack.push(c);
						cnt++;//현재 진행 중 막대기 숫자 +1
					}
				//만약 ')' 닫힌 괄호가 들어오면 
				// 1. 전에 '(' 나왔다면 스루
				// 2. 아니라면 -> '('열린괄호 나올 때까지 stack 털어주기 (막대기 하나 없어짐, cnt--/ result는 ++)
				} else { 
					if( i>0 && test.charAt(i-1) == '(') { //1.
						continue;
					} else { //2.
						//while(stack.peek() != '(') {
							stack.pop();
							cnt--;
							result++;
						//}
					}
					
				}
			} //괄호 하나씩 받아서 stack 만들기 끝
			System.out.println("#" + tc + " " + result); //양식 맞추기!!!!!!
			
		}//한 테스트케이스 끝
		
	}

}
