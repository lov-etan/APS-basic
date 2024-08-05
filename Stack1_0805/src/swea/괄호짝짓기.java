package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) { //10개의 테스트 케이스 돌릴거야
			int N = Integer.parseInt(br.readLine()); //181_String의 길이
			String s = br.readLine(); // 괄호들의 나열 String 읽어오기
			Stack<Character> stack = new Stack<>(); //Stack 만들기
			int r=0; //유효성 검사 초기값 (유효하지 않음)
			
			for(int i=0; i<N; i++) {
				char c = s.charAt(i); //괄호 하나씩 쪼개서 불러오기
				
				if(c==')' && stack.peek() == '(') {
					stack.pop();
				} else if(c==']' && stack.peek() =='[') {
					stack.pop();
				} else if(c =='}' && stack.peek() == '{') {
					stack.pop();
				} else if(c =='>' && stack.peek() == '<') {
					stack.pop();
				} else {
					stack.push(c);
				}
			}//stack에서 더하고 빼고 끝
			
			if(stack.isEmpty()) {
				r = 1;
			} else {
				r = 0;
			}
			
			System.out.println("#"+ tc + " " + r);
			
		}//테스트 케이스 하나 끝
	}

}
