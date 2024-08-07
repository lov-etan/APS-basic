package 수업;

import java.util.LinkedList;
import java.util.Queue;

public class 큐API {
	
	public static void main(String[] args) {
		//Queue<Integer> queue = new Queue<>(); - Queue는 인터페이스이기 때문에 구현체를 넣어줘야 함
		Queue<Integer> queue = new LinkedList<>(); //가장 많이 사용하는 구현체는 linked list
		
		// 삽입
		queue.add(1); //추가될 수 없으면 예외를 발생시킨다 - 예외처리를 안하면 프로그램이 멈춘다.
		queue.offer(1); //추가될 수 없으면 return false
		System.out.println(queue);
		
		// 삭제
		queue.remove(); //삭제될 수 없으면(큐가 비어있으면) 예외 발생
		queue.poll(); //삭제될 수 없으면 return null;
		System.out.println(queue);
		
		
		// 조회
		queue.element(); //예외 발생
		queue.peek(); //return null;
		
	}

}
