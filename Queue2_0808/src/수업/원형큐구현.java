package 수업;

import java.util.Arrays;

public class 원형큐구현 {
	
	//데이터를 3개 담을 수 있다 (배열크기 -1 만큼의 데이터를 담을 수 있다. 왜냐면 0 은 front로 남겨둘거라)
	static String[] queue = new String[4];
	static int front, rear; //정수의 초기값 0으로 어차피 초기화 됨
	static int N = queue.length;
	static int size = 0; //사이즈가 배열크기랑 같은지 확인하면 포화상태인지 알 수 있다
	
	public static void main(String[] args) {
		enQueue("루나");
		enQueue("데이지");
		enQueue("맥스");
		enQueue("서울9반강기훈");
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		deQueue(); //루나 뺴주기
		deQueue();
		deQueue();
		enQueue("서울9반강기훈");
		enQueue("서울8반소남주");
		enQueue("서울10반지유림");
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
	}
	
	// 포화상태 확인
	static boolean isFull() {
		return (4 + front - rear) % 4 == 1; //음수 나올 때의 상황 방지 //front가 0에 있고 rear가 3에 있는 경우
		
	}
	
	//공백상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	//삽입
	static void enQueue(String data) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		size ++;
		//++rear % N <- 이렇게 하면 rear가 순환하지 않고 계속 늘어나기만 할 것임 / 인덱스 지정 전에 먼저 +1 올려주기
		rear = (rear+1) % N;
		queue[rear] = data;
	}
	
	//삭제 
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		size--;
		front = (front+1) %4;
		String item  = queue[front];
		queue[front]= null;
		return item;
	}
	
	//조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[(front + 1) % N];
	}
	
	
	//데이터 개수
	static int size() {
		//rear - front //선형에서 사이즈 구한 방식
		
		return (N + rear - front) % N;
	}
	

}
