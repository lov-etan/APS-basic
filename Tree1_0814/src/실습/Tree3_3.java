package 실습;

public class Tree3_3 {
	static class Node {
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
	}

}
