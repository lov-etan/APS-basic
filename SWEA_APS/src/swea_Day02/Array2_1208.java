package swea_Day02;

import java.util.Arrays;
import java.util.Scanner;

public class Array2_1208 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			int N = scanner.nextInt(); //덤프 횟수
			int[] boxes = new int[100];
			for(int j=0; j<100; j++) {
				boxes[j] = scanner.nextInt();
			}
			selectionSort(boxes);
			//System.out.println(Arrays.toString(boxes));
			int result = dump(N,boxes);
			System.out.println("#" + (i+1) + " " +result);
		}
	
		
		
	}//main 함수 끝
	
	static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			//최솟값의 인덱스를 저장할 변수
			int minIdx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[minIdx]) {
					minIdx = j;
				}
			}
			//minIdx 해당 값과 i 값 바꿔치기
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}//selectionSort 함수 끝
	
	static int dump(int N, int[] arr) {
		//제한된 덤프 횟수만큼 for문 돌리기
		for(int i=0; i<N ; i++) {
			if(arr[arr.length -1] - arr[0] <= 1){
				break;
			}
			//첫번째 행이 두 번째 행보다 커지기 전까지는 최고점에서 최저점으로 보내기
			arr[arr.length-1]--;
			arr[0]++;
			selectionSort(arr);
		}
		selectionSort(arr);
		return arr[arr.length-1]-arr[0];
	}//dump 함수 끝

}
