package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 사칙연산 {
	static Node[] tree;
	static int N;
	
	public static class Node {
		String val;
		int left;
		int right;
		
		Node(String val){
			this.val = val;
		}
		
		Node(String val, int left, int right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		boolean isOperator() {
			return val.equals("+") || val.equals("-") || val.equals("/") || val.equals("*");
		}
	}//node class 정의
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) { //테스트케이스 10개
			int N = Integer.parseInt(br.readLine()); //정점의 개수
			tree = new Node[N+1]; //트리 정보 저장할 배열 만들기 
			
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()); //정점 번호 
				String val = st.nextToken(); //정점 값 가져오기
				
				if(val.equals("+") || val.equals("-") || val.equals("/") || val.equals("*")) { //만약 정점이 연산자라면 
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					tree[num] = new Node(val, left, right);
				} else { //정점이 정수값이라면 
					tree[num] = new Node(val);
				}	
			} //tree 배열 안에 노드값 넣기 끝
			
			//값 계산하기 
			//후위순회를 통해 연산해주기 (숫자_왼 -> 숫자_오 -> 연산자를 만나면 연산자 처리)
			System.out.println("#" + tc + " " + (int)postorder(1));
			
			
			
			
		}//한 테스트케이스 
	}
	
	//후위순위 함수 생성
	static double postorder(int root) {
		if(root==0 || root >= tree.length)
			return 0;
		
		Node currentNode = tree[root];
		//value가 연산자라면? 왼쪽 노드의 값과 오른쪽 노드의 값을 연산 처리한다. 
		if(tree[root].isOperator()) {
			double leftNode = postorder(tree[root].left);
			double rightNode = postorder(tree[root].right);
			
			switch(currentNode.val) {
			case "+":
				return leftNode + rightNode;
			case "-":
				return leftNode - rightNode;
			case "*":
				return leftNode * rightNode;
			case "/":
				return leftNode / rightNode;
			}
			
		} 
		return Double.parseDouble(currentNode.val);
		
	}


}
