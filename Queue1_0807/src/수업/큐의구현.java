package 수업;

import java.util.Scanner;

public class 큐의구현 {
	
	// 배열 사이즈가 10이면 10번 삽입할 수 있다.
	static String[] queue = new String[10]; //큐가 10개를 담을 수 있다? NO //10번 '삽입'할 수 있다? O
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		for(int i =0; i<5; i++) {
			System.out.println("삽입할 문자열 입력: ");
			String item = sc.next();
			enQueue(item);
		}
		
		System.out.println(size());
		
		while (!isEmpty()) {
			String rItem  = deQueue();
			System.out.println(rItem);
		}
		
	}
	
	// 공백상태 확인
	static boolean isEmpty() {
//		if(front == rear) {
//			return true;
//		}
//		return false;
		return front == rear;
	}
	
	//포화상태 확인
	static boolean isFull() {
		//rear가 배열의 마지막 인덱스를 가리키면 포화상태
		return rear == queue.length -1;
	}
	
	//삽입
	//삽입 성공 여부를 반환하려면 boolean 타입도 반환 가능
	static void enQueue(String item) {
		//포화상태인지 먼저 확인
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
					//boolean이면 return false;
		}
//		queue[rear+1] = item;
//		rear++;
		queue[++rear] = item;
		return;
				//true
	}
	
	//삭제
	static String deQueue() {
//		String item = queue[front +1];
//		front++;
//		return item;
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}
	
	//삭제할 원소 조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front + 1]; //front를 직접 더하지 않고 거기에 있는 하나 뒤 수 출력하면 됨
	}
	
	//큐에 들어있는 데이터 개수
	static int size() {
		return rear-front;
	}

}
