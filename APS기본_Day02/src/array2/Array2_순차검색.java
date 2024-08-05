package array2;

import java.util.Arrays;

public class Array2_순차검색 {
	
	public static void main(String[] args) {
		int[] arr = {4,9,11,23,2,19,7};
		int key = 8;
		int result = searchForNoSort(arr, key);
		int result2 = searchWhileNoSort(arr, key);
		System.out.println(result);
		System.out.println(result2);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int result3 = searchForSort(arr, 11);
		System.out.println(result3);
	}
	//정렬되지 않은 경우
	//찾고자하는 key의 index를 return
	// 빨간줄이 왜 뜰까? -> 찾고자 하는 값이 배열에 없어서 return 값을 못 찾음
	static int searchForNoSort(int[] arr, int key) { 
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		//그래서 못 찾았을 때 값 넣어줌
		return -1;
	}
	
	static int searchWhileNoSort(int[] arr, int key) {
		int i = 0;
		while (i<arr.length) {
			if(arr[i] == key) {
				return i;
			}
			i++;
		}
		//못 찾았을 때
		return -1;
	}
	
	//정렬되어 있는 경우
	static int searchForSort(int[] arr, int key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key) 
				return i;
			else if (arr[i] > key) //한번 더 비교하는 조건이 들어감
				return -1;
			
		}
		return -1; //컴퓨터는 정렬된 배열이 들어오는지 알 수 없어. 지우면 안됨
	}
	
	static int searchWhileSort(int[] arr, int key) {
		return -1;
	}
}
