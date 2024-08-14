package 수업_양방향;

class Node{
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList{
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() { //모든 연산을 중간 삽입 연산으로 취급할 수 있음
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	//삽입
	void addData(int i, String data) {
		// 0 : 제일 앞에 삽입
		// size: 제일 뒤에 삽입
		
		if(i<0 || i> size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		//삽입하고자 하는 위치 앞의 노드를 찾는다
		Node curr = head; //헤드로부터 출발해서 삽입할 위치를 찾음
		
		for(int k=0; k<i; k++) {
			curr = curr.next;
		}
		
		// 새 노드 만들어주기
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드 연결해주기
		newNode.next = curr.next;
		newNode.prev = curr;
		
		//기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
		
	}
	
	void removeDara(int i) {
		// 0: 제일 앞의 데이터 삭제
		// size-1: 제일 뒤의 데이터 삭제
		
		if(i<0 || i>=size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		size--;
		
		// 삭제할 위치를 찾기
		// rmNode는 지역변수이므로 메서드 리턴과 동시에 접근불가: GC가 냠냠
		Node rmNode = head.next;
		
		for(int k=0; k<i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;  //A 의 다음이 C가 될 수 있도록
		rmNode.next.prev = rmNode.prev;
	}
	
	void printReverse() {
		Node curr = tail.prev;
		String str = "";
		
		while(curr != head) {
			str = "<-" + curr.data + str;
			curr = curr.prev; // 앞 방향으로 간다	
		}
		System.out.println(str);
	}
	
	
	
	
	
}


public class LinkedList_양방향연결리스트 {
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "강아지");
		list.addData(0, "고양이");
		list.addData(0, "겸사");
		list.addData(0, "강아지");
		list.addData(0, "강아지");
		
		list.printReverse();
		
		list.removeDara(1);
		list.removeDara(0);
	}

}
