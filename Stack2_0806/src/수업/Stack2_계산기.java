package 수업;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2_계산기 {
	public static void main(String[] args) {
		
		String expression = "(6+5*(2-8)/2)";

		int result = evaluate(expression);
		System.out.println(result);
	}

	//계산기 (Step1. 중위표기식->후위표기식) (Step2. 후위표기식 계산)
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression); //step1. 중위표기식->후위표기식
		return evalPostfix(postfix); //step2. 후위표기식 계산
	}
	
	//연산자 우선순위 Map 설정
	static Map<Character, Integer> map = new HashMap<>(); //지역변수라 호출될 때마다 이 과정이 계속 반복 될 것임 -> STATIC 전역 변수로 만드는게 맞음
	
	static {
		//함수는 아무리 불러도 변하지 않음 - static : 중복해서 map을 만들지 않아 효율적이다
				map.put('+', 1);
				map.put('-', 1);
				map.put('*', 2);
				map.put('/', 2);
				map.put('(', 0);
	}
	
	//Step1. 중위표기식에서 후위표기식으로 바꿔주기
	static String infixToPostfix(String infix) { //infix: 중위표기식
		
		String postfix = ""; //길이가 0인 문자열로 초기화
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i<infix.length(); i++) { //"(6+5*(2-8)/2)" 중위표기식 넣어줌
			char c = infix.charAt(i); //1-1.입력 받은 중위 표기식에서 토큰을 읽는다
			
			//2. 피연산자(숫자)가 나오면 바로 출력
			if('0' <= c && c <= '9') {
				postfix += c;
				
				//3. 토큰이 연산자(+-*/괄호)라면
				//3-1. 스택이 비어있으면(top에 연산자 없으면) push
				//3-2. 뭔가가 들어있다면
						//1) c(*)가 top연산자(+)보다 우선순위가 높으면 - stack에 push (c*집어넣기)
						//2) c(+)가 top연산자(*)보다 같거나 작으면 - stack에서 pop (top* 빼주기)
				//4. 토큰이 ) 이면 스택TOP에 (_시작점이 올 때까지 스택에 pop연산을 수행하고 pop한 연산자를 출력
			
			} else if(c == '(') { //여는 괄호는 stack에 push
				stack.push(c);
			} else if(c == ')') { //4. stack 탑에 여는 괄호가 나올 때까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else { //3. 3-1(비어있으면 stack에 push) 3-2(우선순위 비교하여 push, pop)
				//연산자 스택의 마지막에
				//우선순위가 낮은 연산자가 올 때까지 pop //우선순위 어떻게 비교할까? Map(문자-정수 mapping)
				while (!stack.isEmpty() && //스택이 비어있지 않거나
						//stack.peek() != '(' && //스택의 마지막 원소가 여는 괄호가 아니거나
						map.get(stack.peek())>= map.get(c)) { //아무튼 숫자 큰게(우선순위 큰게) 스택 위로 쌓이는 거임 //들어온 애(+)보다 stacktop(*)의 우선순위가 보다 크거나 같으면 pop
					
					char popItem = stack.pop();
					postfix += popItem;
				}
				
				stack.push(c);
			}
		}//c 하나씩 받아서 stack 처리 끝내기
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}//메소드 끝

	//Step2. 후위 표기식 계산
	static int evalPostfix(String postfix) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			
			// 1. 피연산자(숫자)를 만나면 스택에 push 한다.
			if('0' <= c && c<= '9') {
				stack.push(c - '0'); //이렇게 해야 정수가 들어감. c가 문자니까
			} else { 
				//2. 연산자를 만나면 필요한 만큼(2)의 피연산자를 스택에서 pop하여 연산하고, 연산결과를 다시 스택에 push한다.
				int num2 = stack.pop(); //밑에 깔린 값
				int num1 = stack.pop();
				int result;
				
				if(c == '+') {
					result = num1 + num2;
				} else if (c == '-') {
					result = num1 - num2;
				} else if (c == '*') {
					result = num1 * num2;
				}else {
					result = num1 / num2;
				}
				stack.push(result);
				
			}
		}
		//수식이 끝나면, 마지막으로 스택을 pop하여 출력한다.
		return stack.pop();
	}
}
