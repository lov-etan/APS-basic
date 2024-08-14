package 실습;

import java.util.Scanner;

public class 암호문1 {
	static class Node{
		int data;
		Node next;
		
		public Node() {
			
		}
		
		//노드의 생성자
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class SinglyLinkedList {
		Node head;
		int size;
		
		SinglyLinkedList(){
			head = new Node();
			size = 0;
		}
		
		

		//삽입
		void addData(int i, int data) {
			//i 인덱스에 데이터 삽입
			//0이면 제일 앞에 추가
			//size이면 제일 뒤에 추가
			if(i<0 || i> size) {
				System.out.println("인덱스 추가 불가");
				return;
			}
			
			//새 노드 생성
			Node newNode = new Node();
			newNode.data = data;
			
			//삽입할 위치 '앞에 있는 노드' 찾기
			Node curr = head;
			for(int k=0; k<i; k++) {
				curr = curr.next;
			}
			
			//노드 curr 다음으로 추가하기
			newNode.next = curr.next;
			curr.next = newNode;
			size++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {//총 10개의 테스트 케이스가 주어진다.
			//LinkedList 생성
			SinglyLinkedList list = new SinglyLinkedList();
			
			//4줄을 받아와야 함
			//1. 원본 암호문의 길이 N
			int N = sc.nextInt();
			for(int i=0; i<N; i++) { //2. 원본 암호문의 숫자들을 LinkedList에 저장
				int code = sc.nextInt();
				list.addData(i, code);
			}
			
			//3.명령어의 개수
			int icount = sc.nextInt();
			for(int k=0; k<icount; k++) {//icount개의 명령어 받아올 준비
				String I = sc.next(); //4. 명령문 시작
				int x = sc.nextInt(); //curr(x 위치 다음부터 숫자 삽입)
				int y = sc.nextInt(); //y개의 숫자 삽입
				
				for(int m=0 ; m<y ; m++) { //x위치부터 y개의 데이터 받아오기
					int newCode = sc.nextInt();
					list.addData(m+x, newCode);
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
