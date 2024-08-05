package swea_Day02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Array2_2063 {
	public static void main(String[] args) {
		//중간값 찾기
		//선택 정렬 사용
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int[] nums = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = scanner.nextInt();
		}
		
		selectionSort(nums); //숫자를 오름차순으로 정렬
		int median = nums[N/2];
		System.out.println(median);
		
	}
	
	static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int minIdx = i; //minIdx는 i번째에서 가장 작은 값
			for(int j=i+1; j<arr.length; j++) {//minIdx 오른쪽부터 끝까지 가장 최솟값 구하기
				if(arr[minIdx]>arr[j]) //만약 minIdx보다 작은 값 발견하면 minIdx를 j자리로 설정
					minIdx = j; //j가 minIdx보다 작으니까 바꿔줌
			}
			//i와 minIdx 위치 변경(swap) //i가 가장 작을 수 있도록 i에 작은 값 나오게 채워주기
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		
		
	}
	
	

	
}
