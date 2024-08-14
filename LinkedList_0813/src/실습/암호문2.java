package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 암호문2 {
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
		
		//삭제
		void removeData(int i) {
			//i 인덱스 데이터 삭제
			//0이면 제일 앞에 삭제
			//(size-1)이면 제일 뒤에 삭제 //-1인 이유: 맨 앞 head는 비워져있으니까
			if(i<0 || i>= size) {
				System.out.println("삭제 불가 범위");
				return;
			}
			
			size--;
			
			//삭제할 노드의 앞으로 이동
			Node curr = head;
			for(int k=0; k<i; k++) {
				curr = curr.next;
			}
			
			curr.next = curr.next.next; //삭제할 노드 직전의 다다음이 이제 다음이 됨
		}
		
		//추가 
		void addTailData(int data) {
			//제일 마지막 인덱스 뒤에 새로운 노드 생성
			Node newNode =new Node();
			newNode.data = data;
			
			//현재 시점 제일 마지막 노드 위치
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = newNode;
			
			size++;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {//총 10개의 테스트 케이스가 주어진다.
			//LinkedList 생성
			SinglyLinkedList list = new SinglyLinkedList();
			
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
				int x = Integer.parseInt(st.nextToken()); //curr(x 위치 다음부터 숫자 삽입)
				int y = Integer.parseInt(st.nextToken()); //y개의 숫자 삽입
				
				//Q가 I라면 add
				if(Q.equals("I")) {
					for(int m=0 ; m<y ; m++) { //x위치부터 y개의 데이터 받아오기
						//int newCode = sc.nextInt();
						int newCode = Integer.parseInt(st.nextToken());
						list.addData(x+m, newCode);
					}
				} else if (Q.equals("D")) { //Q가 D라면 remove
					for(int m=0; m<y; m++) {
						list.removeData(x); //인덱스가 삭제되므로 계속 x자리에 있는 친구를 삭제해야 한다.!!!!!
					}
				} else { //Q가 A라면 add
					for(int m=0; m<y; m++) {
						int newCode = Integer.parseInt(st.nextToken());
						list.addTailData(newCode);
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