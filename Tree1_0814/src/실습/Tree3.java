package 실습;

import java.util.Scanner;

public class Tree3 {
	
	//1 - 2 3 자식의 주소가 확실하게 주어짐
	static class Node{
		boolean isOp; //연산자인지 아닌지
		int num; //정수 노드
		String op; //연산자 노드라면 연산자 저장
		int left; //왼쪽 자식의 번호
		int right; //오른쪽 자식의 번호
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//총 10개의 테스트 케이스가 주어진다.
		for(int tc=1; tc<=10; tc++) {
			//첫 줄에는 정점의 개수 N이 주어진다.
			int N = sc.nextInt();
			//N+1 크기의 배열 생성 - 트리의 인덱스와 값을 저장
			String[] tree = new String[N+1];
			tree[0] = "0";
			
			for(int i=0; i<N; i++) { //정점 읽어오기
				int idx = sc.nextInt(); //정점 idx
				String node = sc.next(); //인덱스에 해당하는 노드값
				tree[idx] = node;
				
				if(!node.matches("\\d+")) { //연산자인 경우 // [\\d]는 숫자 하나를 의미함
					sc.next(); //자식노드1
					sc.next(); //자식노드2
				} //연산자가 아닌 경우 - 그냥 pass
			}//tree 배열에 수 넣기 끝!
			
			inorder(tree,1); //88-65-10 //우리가 알아들을 수 있는 식으로 나타나게 됨
			
			
			
			
		}//한 테스트 케이스 끝
	}
	
	//중위 순회로 읽기
	public static void inorder(String[] tree, int root) {
		if(root >= tree.length)
			return;
		inorder(tree, root*2);
		System.out.print(tree[root]);
		inorder(tree, root*2 +1);
	}
	
	//계산기 만들어보기
	//public static int calculator(String[] tree) {
		//for(int)
	//}

}
