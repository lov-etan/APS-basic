package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine()); //문자열의 길이
			String expression = br.readLine(); //"4+5+6+"..
			
			String postfix = infixToPostfix(expression, N);
			int result = evalPostfix(postfix);
			System.out.println("#" + tc + " " + result);
			}
	}//main끝
	
	//연산자 우선순위 Map 설정
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+',1);
	}
	
	
			
	//Step1. 중위표기식에서 후위표기식으로 바꿔주기
		static String infixToPostfix(String infix, int N) {
			
			//출력할 후위표기식
			String postfix = "";
				//스택 만들기
			Stack<Character> stack = new Stack<>();
			
		
				//1. 입력 받은 중위 표기식에서 토큰을 읽는다.
			for(int i=0; i<N; i++) {
			char c = infix.charAt(i);
			
				//2.피연산자(숫자)면 바로 출력
			if( '0' <= c && c <= '9') {
				postfix += c;
			} /*연산자면 고려해야 함*/ else { //pop 멈춰야 하는 조건까지 pop해주기
				while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) { //pop 그만해야 하는 조건: 비어있거나, 우선순위 큰게 깔려있으면 pop하면 안 됨
					postfix += stack.pop();
				}
				//pop할 거 다했으면 연산자 stack에 push 해주기
				stack.push(c);
			}//else연산자문
			
			
			}//for 토큰 하나 값 비교하여 stack 처리
			
			while(!stack.isEmpty()) { //스택이 비워질 때까지 pop pop pop //숫자 다 썼으면 스택에 남아있던 연산자 털기
				postfix += stack.pop();
			}
			
			return postfix;
		
		
		}//step1 메소드(중위->후위)
		
		
		//Step2. 후위 표기식 계산
		static int evalPostfix(String postfix) {
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0; i<postfix.length(); i++) { //모든 char 검사 후 stack에 쌓을 예정
				char c = postfix.charAt(i);
				
				//1. 피연산자면 무조건 stack에 push
				if( '0' <= c && c <= '9') {
					stack.push(c - '0'); //이렇게 해야 정수가들어감!!
				} else { //연사자이면 stack에서 필요한 만큼(2개) 꺼내서 연산해줘야 함
					int num1 = stack.pop(); //스택에서 하나 꺼내고
					int num2 = stack.pop(); // 그 아래에 있는거 또 꺼내고
					int result=0;
					
					if( c == '+') {
						result = num1 + num2;
					}
					stack.push(result); //계산하고 남은 값은 result에 담아 stack에 다시 넣어준다.
				}
			}//for문 끝
			return stack.pop(); //모든 수를 다 돌면 stack에 마지막 남은 숫자가 결과값임
			
		}

	
}
