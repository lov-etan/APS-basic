package 수업;

public class Tree2_최소힙 {
	
	static int[] heap = new int[100]; 
	static int heapSize = 0;
	
	public static void main(String[] args) {
		
		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);
		
		int size = heapSize; //그래서 사이즈를 미리 할당해서 고정값으로 돌리면 됨
		
		//아니면
		//while(hipSize != 0)
		
		for(int i=0; i< size; i++) { //착각: heapSize(6번)돌면서 pop 하면 되겠네 -> 왜 3번밖에 안 나오지? -> 중간에 pop을 하면 힙 사이즈가 점점 줄어듦
			int popItem = heapPop();
			System.out.println(popItem);
		}
		
	}
	
	//swap
	
	static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	//삽입 연산
	static void heapPush(int data) {
		//1. 완전이진트리 마지막에 data 추가
		heap[++heapSize] = data; //heapSize 먼저 하나 올려주고 거기에 데이터 삽입
		
		int p = heapSize /2 ;
		int ch = heapSize;
		
		
		while(ch != 1 && heap[p] > heap[ch]) {
			//2.부모와 비교해서 자식이 더 작으면 swap
			swap(p,ch);
			
			//3.swap 이후의 인덱스 갱신
			ch = p; //자식이 1이 되면 더이상 swap을 할 필요가 없음 -> while 조건문에 추가
			p = ch/2; //완전이진트리이므로 부모의 인덱스는 자식 인덱스의 정확히 반
		}
		
		
	}
	
	//삭제 연산
	static int heapPop() {
		//1. 루트에 있는 데이터 저장
		int popItem = heap[1]; //삭제는 맨 위 루트에서 이뤄짐
		
		// 2. 마지막 노드를 루트로 옮긴다.
		heap[1] = heap[heapSize--]; //마지막 애 데리고 오고 size 하나 지워주기
		
		//3. 자식과 부모 비교하여 swap 반복
		//자식이 부모보다 작은 swap
		//자식이 둘 이상이면 더 작은 자식과 swap
		int p = 1;
		int ch = p*2;
//		int leftCh = p * 2;
//		int rightCh = p*2+1; 
		
		if(ch+1 <= heapSize && heap[ch] > heap[ch+1]) {//오른쪽 자식이 있는지 확인하고 싶음
			ch++; //오른쪽 자식이 더 크면 오른쪽 자식으로 ㄱㄱ
		} 
		
		while( ch<= heapSize && heap[ch] < heap[p]) { //부모가 자식으로 계속 내려가는 중 //자식이 힙 사이즈 이내에 있는 동안만 반복 가능
			swap(p,ch);
			
			//4. swap 이후 인덱스 갱신
			p = ch;
			ch = p*2;
		}
		
		return popItem;
	}

}
