package 수업;

import java.util.Arrays;

public class 우선순위큐1차원배열 {
	
	static int[] queue = new int[100];
	static int front =-1;
	static int rear =-1;
	
	
	public static void main(String[] args) {
		
		enQueue(10);
		enQueue(12);
		enQueue(3);
		enQueue(9);
		enQueue(8);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	

	}
	
	static void enQueue(int data) {
		int i = ++rear;
		//정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
		int j;
		for(j = i-1; j>=0 && queue[j] > data ; j--) {
			queue[j+1] = queue[j]; //data값이 작은 곳까지 queue 위치 밀어주면서 돌격
		}
		queue[j+1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}

}
