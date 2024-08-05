import java.util.Arrays;

public class Array3_연습문제1 {
	public static void main(String[] args) {
		int N=5;
		int[][] board = new int[N][N];
		
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				board[r][c] = (int) (Math.random()*100) ;//0 이상 1미만의 실수 랜덤으로 반환
			}
		}
		
		System.out.println(Arrays.deepToString(board));
	
	
	//25개 각 요소에 대해서 이웃한 요소와의 차이의 총합을 구하는 것
	int[][] sum = new int[N][N];
	int[] dr = {0,0,-1,1};
	int[] dc = {1,-1,0,0};
	
	for (int r = 0; r<N; r++) {
		for(int c =0; c<N; c++) {
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c + dc[d];
				if(0<=nr && nr<N && 0<=nc && nc<N) {
					sum[r][c] += Math.abs(board[r][c]-board[nr][nc]);
				}
			}
//			if(r-1 >0)
//				sum[r][c] += Math.abs(board[r-1][c] - board[r][c]);
//			if (r+1 <N)
//				sum[r][c] += Math.abs(board[r+1][c] - board[r][c]);
//			if(c-1 >0)
//				sum[r][c] += Math.abs(board[r][c-1] - board[r][c]);
//			if (c+1 <N)
//				sum[r][c] += Math.abs(board[r][c+1] - board[r][c]);
		}
	}
	System.out.println(Arrays.deepToString(sum));

	}
}
