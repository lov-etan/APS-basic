package 실습_양방향;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//메모리 초과가 난다 - 단방향으로는 답이 없음.. 수가 많으면 처음부터 끝까지 가는거 오-바
class Node{
	int data;
	Node prev;
	Node next;
}

class DoublyLinkedList{
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() { //모든 연산을 중간 삽입 연산으로 취급할 수 있는 장점이 있는 구현
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	//삽입
	void addData(int i, int data) {
		//0:제일 앞에 삽입
		//size: 제일 뒤에 삽입
		
		if(0>i || i>size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		//새 노드 만들어주기
		Node newNode = new Node();
		newNode.data = data;
		
		//삽입하고자 하는 위치 앞의 노드를 찾는다.
		Node curr = head; //헤드로부터 시작해 삽입할 위치 찾기
		
		for(int k=0; k<i; k++) {
			curr = curr.next;
		}
		
		
		//새 노드 연결해주기
		newNode.next = curr.next; //직전거 다음 값 뉴노드 //원래 값의 다음은 9 .. newNode 다음이 이제 9로 만들어주기
		newNode.prev = curr; //직전 값은 뉴노드 직전
		
		//기존 노드 연결 재구성
		curr.next.prev = newNode; //뉴노드는 기존 직접 값 다음값의 이전값 //C의 이전값을 뉴노드로 ㅏㄸㅇ땅!
		curr.next = newNode; //뉴노드는 기존 직접 값의 다음	
	}
	
	//삭제
	void removeData(int i) {
		//0:제일 앞의 데이터 삭제
		//size:제일 뒤의 데이터 삭제
		
		if( i<0 || i>=size) {
			System.out.println("삭제할 수 없는 범위");
			return;
		}
		size--;
		
		//삭제할 위치를 찾기
		Node rmNode = head.next;
		for(int k=0; k<i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
	}
	
	//추가
	void appendData(int data) {
		//맨 뒤에 다 넣을 것이니 새로운 값이 tail node 뒤에 오면 된다.
		Node newNode = new Node();
		newNode.data = data;
		
		//어차피 맨 뒤니까 삽입하고자 하는 curr 찾을 필요 없음
		//새 노드 연결해주기
		newNode.prev = tail.prev;
		newNode.next = tail;
		
		//기존 노드 연결 재구성
		tail.prev.next = newNode;
		tail.prev = newNode;
		
		size++;
		
	}
}


	public class 암호문3 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			for(int tc=1; tc<=10; tc++) {//총 10개의 테스트 케이스가 주어진다.
				//LinkedList 생성
				DoublyLinkedList list = new DoublyLinkedList();
				
				//4줄을 받아와야 함
				//1. 원본 암호문의 길이 N
				
				int N = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) { //2. 원본 암호문의 숫자들을 LinkedList에 저장
					//int code = sc.nextInt();
					int code = Integer.parseInt(st.nextToken());
					list.addData(i, code);
				}
				
				//3.명령어의 개수
				//int icount = sc.nextInt();
				
				int icount = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<icount; k++) {//icount개의 명령어 받아올 준비
					String Q = st.nextToken(); //4. 명령문 시작
					
					//Q가 I라면 add
					if(Q.equals("I")) {
						int x = Integer.parseInt(st.nextToken()); //curr(x 위치 다음부터 숫자 삽입)
						int y = Integer.parseInt(st.nextToken()); //y개의 숫자 삽입
						for(int m=0 ; m<y ; m++) { //x위치부터 y개의 데이터 받아오기
							//int newCode = sc.nextInt();
							int newCode = Integer.parseInt(st.nextToken());
							list.addData(x+m, newCode);
						}
					} else if (Q.equals("D")) { //Q가 D라면 remove
						int x = Integer.parseInt(st.nextToken()); //curr(x 위치 다음부터 숫자 삽입)
						int y = Integer.parseInt(st.nextToken()); //y개의 숫자 삽입
						for(int m=0; m<y; m++) {
							list.removeData(x); //인덱스가 삭제되므로 계속 x자리에 있는 친구를 삭제해야 한다.!!!!!
						}
					} else { //Q가 A라면 add
						int y = Integer.parseInt(st.nextToken()); //y개의 숫자 삽입
						for(int m=0; m<y; m++) {
							int newCode = Integer.parseInt(st.nextToken());
							list.appendData(newCode);
						}
					}
					
				}//명렁의 개수에 따라 icount개의 명령어를 해당 위치에 삽입함
				
				//수정된 암호문의 처음 10개 항을 출력한다.
				System.out.print("#" + tc);
				Node curr = list.head.next; //head 다음부터 출력
				for(int p=0; p<10; p++) {
					System.out.print(" " + curr.data);
					curr = curr.next;
				}
				System.out.println();//엔터 넣기.......
				
				
			}
		}
		
	}
		
	
