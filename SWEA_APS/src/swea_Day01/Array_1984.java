package swea_Day01;

import java.util.Scanner;

public class Array_1984 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		for(int n=0; n<N; n++) {
			int[] arr = new int[10];
			int max = 0;
			int min = 10000;
			int sum = 0;
			
			for(int i=0; i<10; i++) {
				arr[i] = scanner.nextInt();
				sum += arr[i];
				if(arr[i]>max)
					max = arr[i];
				if(arr[i]<min)
					min = arr[i];
			}
			//소수점 첫째 자리에서 반올림한 정수를 출력한다
			int finalSum = sum - max - min;
			double avg = finalSum/8.0; //8.0 즉, double값으로 해야 정확한 값이 나온다!!!
			int roundedAvg = (int) Math.round(avg);
			System.out.println("#"+(n+1) + " "+ roundedAvg);
		}
		}

}
