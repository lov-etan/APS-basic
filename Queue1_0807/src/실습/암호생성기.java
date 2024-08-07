package 실습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++) {
			int tc = sc.nextInt(); //테스트케이스의 번호
			Queue<Integer> queue = new LinkedList<>();
			
			for(int j=0; j<8; j++) {//8개의 데이터 받아서 queue에 채워넣기
				int num = sc.nextInt();
				queue.add(num);
			}
			
			//rear(가장 마지막 입력된 수)가 0이 될 때까지 순회
			int rear = -1;
			while (rear != 0) { //마지막으로 입력된 값이 0이면 순회 끝
				for(int k=5; k>=1; k--) {
					int front = queue.poll(); //일단 맨 앞거 빼
					rear = front - (6-k); //1,2,3,4,5 순으로 빼줘 그 값은 맨 뒤로 가게 될거야
					if(rear<=0) { //만약 뺀 결과 rear 값이 0보다 작거나 같다면 rear 값은 
						queue.add(0);
						rear =0;
						break;//break문이 있으면 for문을 즉시 종료하고 while문에서 조건 비교 바로 하게 됨
					} else {
						queue.add(rear); //뺀 결과 0,음수 아니면 그냥 rear에 넣고 반복
					}
				}
			}
			
			//System.out.println(queue); //역방향 순회 가능..?
			System.out.print("#" + tc + " " );
			for(int p=0; p<8; p++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
			
			
			
		}//한 케이스 끝
		
	}

}
