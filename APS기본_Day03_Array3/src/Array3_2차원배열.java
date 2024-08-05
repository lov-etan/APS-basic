import java.util.Arrays;

public class Array3_2차원배열 {
	public static void main(String[] args) {
		//2차원 배열의 선언 및 초기화
		//int[][] arr = {{1,2,3},{4,5,6,7,8},{7,8,9}};
		int[][] arr = new int[3][3];
		
		//정방향 행 우선순회 하면서 초기화
		int num=1;
		
		for(int r = 0; r<arr.length;r++ ) { //2차원 배열의 크기가 곧 행의 크기임
			for(int c =0; c<arr[0].length;c++) {
				arr[r][c] = num++;
			}
		}
		
		//2차원 배열 출력
		System.out.println(Arrays.deepToString(arr));
		
		
		
		//역방향 행 우선순회
		for(int r =0; r<arr.length;r++) {
			for(int c=arr[0].length-1; c>=0; c--) {
				System.out.print(arr[r][c] + ",");
			}
		}
		System.out.println();
		
		
		//정방향 열 우선순회
		for(int c=0; c<arr[0].length; c++) {
			for(int r=0; r<arr.length; r++) {
				System.out.print(arr[r][c]);
			}
		}
	} //m
}
