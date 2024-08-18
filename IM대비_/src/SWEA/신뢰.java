package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신뢰 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
		
		//테스트케이스 시작~!!
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //눌러야 하는 버튼 수
			String[] Br = new String[N*2]; //B 2 O 2 이렇게 넣을 예정  
			
			//배열에 버튼 저장하기 
			for(int i=0; i<N*2; i++) {
				Br[i] = st.nextToken();
			}
			
			//움직인 거리 | O,B 시간과 현재 위치 | 총 시간 | 
			int moveDistance =0;
			int totalTime =0;
			int oLoc =1;
			int bLoc= 1;
			int oTime = 0; // 수행시점까지 O가 쓴 시간
			int bTime = 0; // 수행시점까지 B가 쓴 시간 **총 시간과 다름. 나머지가 돌아가고 있을 때 얘의 시간은 멈춰있음을 나타내고자 함
			
			//배열 순회하며 최소 시간(time) 구하기
			for(int i=0; i<N*2 ; i+=2) { //O인지 B인지만 읽는다 
				if(Br[i].equals("O")) {
					int target = Integer.parseInt(Br[i+1]);
					moveDistance = Math.abs(target - oLoc); // 움직인 거리 
					oTime += ++moveDistance; //oTime이 이전까지 쓴 시간에 지금 움직여서 버튼 누른 시간 더해주기 //1을 먼저 더하고 oTime에 넣어줘야 함!! ++moveDistance
					
					if(oTime > totalTime) {
						totalTime = oTime; //O가 지금까지 쓴 시간이 총 시간보다 많다면 시간을 새로 쓴 거기 때문에 총시간 업데이트 
					}else { //만약 totalTime이 더 큰 경우는, b가 움직일 때 시간 알차게 쓰는 것
						totalTime += 1; //버튼 누른 경우만 포함하여 총시간 1초 올려주기 //바보야.. 1초 올려주는거.. += 1 이잖아..
						oTime = totalTime; //현재 시간으로 업뎃해주
					}
					
					//O위치 target 위치로 옮겨주기
					oLoc = target;
					
				} else {
					//B인 경우 
					int target = Integer.parseInt(Br[i+1]);
					moveDistance = Math.abs(target - bLoc); // 움직인 거리 
					bTime += ++moveDistance; //oTime이 이전까지 쓴 시간에 지금 움직여서 버튼 누른 시간 더해주기
					
					if(bTime > totalTime) {
						totalTime = bTime; //O가 지금까지 쓴 시간이 총 시간보다 많다면 시간을 새로 쓴 거기 때문에 총시간 업
					}else { //만약 totalTime이 더 큰 경우는, b가 움직일 때 시간 알차게 쓰는 것
						totalTime += 1 ; //버튼 누른 경우만 포함하여 총시간 1초 올려주기
						//System.out.println(totalTime);
						bTime = totalTime;
					}
					
					//O위치 target 위치로 옮겨주기
					bLoc = target;
					
				}
			}
			
			System.out.println("#" + tc + " " + totalTime);
			
			
			
		}//테스트케이스 
	}

}
