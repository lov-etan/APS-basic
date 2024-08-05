package array2;

import java.util.Arrays;

public class Array02_선택정렬 {
	public static void main(String[] args) {
		
		int[] nums = {10,64,5,11,28,77,34};
		
		selectionSort(nums);
		
		System.out.println(Arrays.toString(nums));
	}
	
	static void selectionSort(int[] arr) {
		//cycle 횟수: 배열 길이 -1 (최솟값을 배열길이 만큼 찾아주면 끝남)
		for(int i=0; i<arr.length;i++ ) {
			//최솟값의 인덱스를 저장할 변수
			int minIdx = i;
			for(int j=i+1; j<arr.length; j++) { //최소(i) 이후부터 최솟값 찾기
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			//i와 midIdx의 위치 변경 (swap)
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}

}
