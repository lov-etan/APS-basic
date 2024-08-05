package 수업;

import java.util.Stack;

public class Stack_스택의구현 {
	
	static String[] stack = new String[100];
	//마지막에 들어간 데이터의 index를 가리키는 top
	static int top = -1;//초기값은 -1
	
	public static void main(String[] args) {
//		Stack<String> stack = new Stack<>();
//		
//		stack.push("고양이");
//		stack.push("토끼");
//		stack.push("쥐");
//		
//		for(int i=0; i<3; i++) {
//			System.out.println(stack.pop());
//			
//		}
		
		
		push("고양이");
		push("토끼");
		push("쥐");
		
		while(!isEmpty()) { //비지 않을 때까지만
			String popItem = pop();
			System.out.println(popItem);
		}
		
		//pop();
		for(int i=0; i<=100; i++) {
			push(i+"");
		}
		
	}
	
	static boolean isEmpty() {
		if(top == -1) {
			return true;
		} 
		return false;
	}
	
	static boolean isFull() {
		return top == stack.length-1; //99까지 차면 더 들어갈 수 없다
	}
	
	static void push(String item) {
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = item; //먼저 1 올려주고 item을 해당 위치에 넣어준다
	}
	
	static String pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null; 
		}
//		pop한 위치를 지워주는 코드
//		String popItem = stack[top];
//		stack[top] = null;
//		return popItem;
		
		//리턴이 안 됐다면 비어있지 않다는 것
		return stack[top--]; //그치만 지워주지 않아도 나중에 push할 때 자동으로 덮어쓰이기 때문에 값을 지워주지는 않는다
	}
	
	static String peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}
