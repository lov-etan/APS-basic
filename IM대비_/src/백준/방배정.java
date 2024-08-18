package 백준;

import java.util.Scanner;

public class 방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //전체 학생 수
		int K = sc.nextInt(); //한 방의 최대 인원
		int roomCnt = 0; //방 개수 세기  
		
		int[][] Rr = new int[7][2]; //방 배열  
		
		for(int i=0; i<N; i++) { //모든 학생 방에 넣어주기
			int s = sc.nextInt(); //성별 
			int y = sc.nextInt(); //학년
			
			if( Rr[y][s] == 0 ) { //만약 방에 아무도 없다 -> 방 생성 
				roomCnt++;
				Rr[y][s]++; //해당 방에 한 명 들어갑니다~ 
			} else { //그 방에 누군가가 있어 
				int tmp = Rr[y][s]; //그 방 사람 수 tmp에 넣기
				tmp++; //한 명 더 넣어봐  
				//그런데, tmp가 최대 인원을 넘는다면? 
				if(tmp > K) {
					Rr[y][s] = 1; //새로운 방에 한 명 넣어주기(기존 방 초기화) 
					roomCnt++;
				} else {
					//최대 인원 안 넘으면 그냥 방 인원 수만 늘려주면 됨 
					Rr[y][s]++; //new person 들어갑니다~
				}
				
			}
			
		}
		System.out.println(roomCnt);
	}

}
