package swea_Day01;

import java.util.Scanner;

public class Array_2068 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		System.out.println();
		for(int n=0; n<N; n++) {
			int[] arr = new int[10];
			int max = 0;
			
			for(int i=0; i<10 ; i++) {
				arr[i] = scanner.nextInt();
				if(arr[i]>max) {
					max = arr[i];
				} 
			} System.out.println("#"+(n+1) + " " + max );
			
		}
		
	}

}
