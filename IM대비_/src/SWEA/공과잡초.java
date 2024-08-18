package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 공과잡초 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());// 테스트케이스 수
		
		//테스트케이스 시작 
		for(int tc=1; tc<=T; tc++) {
			
			String s = br.readLine(); //잡초와 함께한 초원 등장 //Line을 받아와야 함!!! sc는 공백 전까지만 받아오잖아...
			char[] Gr = s.toCharArray(); //초원 문자열 -> 배열에 넣어주기
			//System.out.println(Arrays.toString(Gr));
			
			int ballCnt = 0;
			
			for(int i=0; i<Gr.length-1; i++) {
				if(Gr[i] == '(') {
					if((Gr[i+1] == '|' || Gr[i+1] == ')' ))
						ballCnt++;
				} else if(Gr[i] == '|') {
					if(Gr[i+1] == ')')
						ballCnt++;
				} //else {
					//return; //이러면 즉시 반복문 종
				//}
			}
			System.out.println("#" + tc + " " + ballCnt);
			
		}
	}
	

}
