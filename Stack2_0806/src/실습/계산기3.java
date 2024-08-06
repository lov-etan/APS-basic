package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 계산기3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String expression = br.readLine();
			
			String postfix = infixToPostfix(expression, N);
			int result = evalPostfix(postfix);
			System.out.println("#" + tc + " " + result);
			
			}
		
	}//main 
	
	//우선순위 정해주기
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
		map.put('(', 0);
	}
	
	
	//Step1. 중위표기식에서 후위표기식으로 바꿔주기
	static String infixToPostfix(String expression, int N) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<N; i++) { //c 하나씩 검사하며 stack 관리
			char c = expression.charAt(i);
			
			//1. 피연산자(숫자)가 들어왔을 때, 바로 postfix에 출력해주기
			if( '0' <= c && c <= '9') {
				postfix += c;
			//2.연산자일 경우,
				// 2-1. 괄호
			} else if( c == '(') { //'('열린 괄호일 때는 무조건 push
				stack.push(c);
			} else if( c == ')') { //')'닫는 괄호일 때는 stack에 )여는 괄호 넣을 때까지 털어주기
				char popItem = stack.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();//popItem 새로운 top 값으로 갱신
				}
				//2-2. 다른 연산자(+, *)
			} else {
				//아래의 조건에 맞을 때까지 일단 연산자stack 털어주고 다하면 스택에 push
				while(!stack.isEmpty() && stack.peek()!='(' && map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
			
		}//for문 끝
		
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}//step1 메서드 끝
	
	//Step2. 후위표기식 계산
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			//1. 피연산자이면 무조건 stack에 쌓아준다.
			if( '0' <= c && c <= '9') {
				stack.push(c-'0');
			//2. 연산자이면 필요한 만큼 뽑아서 연산을 해준다. (여기서 괄호는 제외됨)
				//그 결과를 다시 스택에 넣어줌
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result=0;
				
				if(c == '+') {
					result = num1 + num2;
				} else if(c == '*') {
					result = num1 * num2;
				}
				
				stack.push(result);
			}
			
		}//for문
		return stack.pop();
	}
	
}//Class
