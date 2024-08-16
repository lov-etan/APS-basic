package 실습;

import java.util.Scanner;

public class Tree1_최대힙 {
	static int[] heap = new int[(int) Math.pow(10, 5) + 1];
	static int heapSize = 0;

	static void swap(int p, int ch) {
		int tmp = heap[p];
		heap[p] = heap[ch];
		heap[ch] = tmp;
	}

	// 삽입
	static void heapPush(int data) {
		// 일단 자식 노드에 data를 넣어준다.
		heap[++heapSize] = data; // 마지막 노드 연결 //heapSize 하나 더 올리고 그 값 넣어주기

		// 들어온 자식 - 부모 자식 인덱스 설정
		int p = heapSize / 2;
		int ch = heapSize; // 새로 들어온 자식의 index

		// 부모의 값이 자식 값보다 작아지기 전까지 계속 swap 해주기
		while (ch != 1 && heap[p] < heap[ch]) { // ch 1이 된다는 건 루트가 하나라는 뜻
			swap(p, ch); // 부모 자식 자리 바꿔주기

			// 노드 위치 잘 만들어줬으면 부모 인덱스와 자식 인덱스도 재정비
			ch = p; // 부모가 자식으로 가고
			p = ch / 2; // 이제 부모는 그 자식의 인덱스 절반(완전이진트리이므로)
		}

	}

	// 삭제
	static int heapPop() {
		//루트 값을 출력하고 - 존재하지 않는다면(heapSize==0) -1 출력
		//해당 노드를 삭제한다!
		
		//루트가 존재할 때,
		if(heapSize >0) {
			//1. 루트 값 뽑아놓기
			int popItem = heap[1]; //가장 최상단의 숫자
			
			//2. 해당 루트 값을 맨 뒤 노드로 보내고 배열 사이즈 하나 줄여주기
			//맨 뒤 값을 루트에 넣어주면서 완전 이진 트리 구조를 유지하게끔 한다.
			heap[1] = heap[heapSize--];
			
			//3. 트리 재정렬 - 맨 위에서부터 재정렬하게 된다. 
			int p = 1;
			int ch = p*2; //왼쪽 노드와 부모 비교하는 것을 default 값으로
			
			if(ch+1<=heapSize && heap[ch] < heap[ch+1]) { //만약 오른쪽 노드가 더 크면 걜 써야지
				ch = p*2+1;
			}
			
			//자식이 루트가 되거 부모가 자식보다 값이 작아지기 전까지 수행
			while(ch <= heapSize  && heap[p] <heap[ch]) {
				swap(p,ch);
				
				//인덱스 값 재정렬
				p = ch;
				ch = p*2;
			}
			
			return popItem;
			
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<N; i++) {
				int type = sc.nextInt();
				if( type == 1) {
					int data = sc.nextInt();
					heapPush(data);
				} else {
					System.out.print(heapPop() + " ");
				}
			}
			System.out.println();
			
		}
	}
}
