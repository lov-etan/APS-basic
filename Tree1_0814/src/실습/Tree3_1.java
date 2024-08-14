package 실습;

import java.util.Scanner;

public class Tree3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//총 10개의 테스트 케이스가 주어진다.
		for(int tc=1; tc<=10; tc++) {
			//첫 줄에는 정점의 개수 N이 주어진다.
			int N = sc.nextInt();
			//N+1 크기의 배열 생성 - 트리의 인덱스와 값을 저장
			char[] tree = new char[N+1];
			
			for(int i=0; i<N; i++) { //정점 읽어오기
				int idx = sc.nextInt(); //정점 idx
				char node = sc.next().charAt(0); //인덱스에 해당하는 노드값
				tree[idx] = node;
				
			}
		}
	}
	
	//중위 순회로 읽기
	public static void inorder(char[] tree, int root) {
		inorder(tree, root*2);
		System.out.println(tree[root]);
		inorder(tree, root*2 +1);
	}

}
