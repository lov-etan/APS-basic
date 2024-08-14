package 수업_단방향;

class Node{
	String data;
	Node link; //다음 노드의 주소를 저장할 링크 필드
}

class SinglyLinkedList{
	Node head;
	int size;
	
	SinglyLinkedList(){
		head = new Node();
	}
	
	//삽입
	void addData(int i, String data) { 
		// i 인덱스에 데이터 삽입
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if ( !(0<= i && i<=size) ) { //0보다 크고 size보다는 작아야 함 -> 그렇지 않으면 ~ //0  > i || i>size
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data; //새 노드에 값 넣기
		
		// 삽입할 위치 '앞에 있는 노드' 찾기
		Node curr = head;
		for(int k = 0; k < i ; k++) { //삽입할 노드 인덱스 전까지 순회하면서 curr에 삽입할 위치 '앞에 있는 노드'로 만들어주기
			curr = curr.link;
		}
		
		//새 노드부터 연결
		//추가할 다음 노드에 연결부터 한다.  현재 노드는 current / 다음 노드는 current.node
		newNode.link = curr.link; //A 다음에 C 가리키던 걸 B 다음에 C를 가리키는 것으로 변경
		curr.link = newNode; //newNode는 curr의 다음에 있다
		
		size++;
	}
	
	//삭제
	void removeData(int i) {
		// 0번 : 제일 앞에 있는 데이터 삭제
		// (size-1)번: 마지막 데이터 삭제
		
		if( 0>i || i>=size ) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		// 삭제할 노드의 앞 노드로 이동
		Node curr = head;
		
		for(int k=0; k<i; k++) {
			curr = curr.link; //A로 이동하게 됨 (B를 지우고자 하니까 A는 head의 다음 노드)
		}
		
		curr.link = curr.link.link; //A의 다다음이었던 C를 A 바로 다음으로 배치
	}
	
	//조회
	
	void printAll() {
		Node curr = head.link;//헤드의 다음 위치에서부터 출력
		
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
	
	
	//데이터 개수(사이즈 확인)
}

public class LinkedList_단순연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "서울 8반 소남주");
		list.printAll();
		list.addData(0, "강아지");
		list.printAll();
		list.addData(0, "고양이");
		list.printAll();
		list.addData(0, "고라니");
		list.addData(0, "고라니");
		list.addData(0, "고라니");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		
	}

}
