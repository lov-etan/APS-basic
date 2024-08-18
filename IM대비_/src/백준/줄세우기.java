package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //학생 수
		int[] Or = new int[N]; //순서 배열 
		
		//최초의 줄 선 학생들 번호 
		for(int i=0; i<N; i++) {
			Or[i] = i+1;
		}
		//System.out.println(Arrays.toString(Or));
		
		for(int i=0; i<N; i++) { //번호표 뽑아서 순서 재정비 
			//지금 차례 아이 번호는 i+1 이다. 
			
			int ticket = sc.nextInt(); 
			int idxChanged = i-ticket; //바뀐 인덱스
			
			//자리 한 칸씩 미뤄주기  //겹치지 않게 원래 자리 먼저 덧대서 뒤에서부터 미뤄준다.
			for(int j=ticket; j>=1; j--) { //원래 인덱스 주인(바뀐 인덱스) ~ 해당 인덱스 이동 
				Or[idxChanged + j] = Or[idxChanged + j -1];
			}
			
			//바뀐 자리에 넣어주기
			Or[idxChanged] = i+1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(Or[i] + " ");
		}
		
		
	}

}
