package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class IM대비문제 {
	//봉사동아리에서 교육봉사를 나가는데 학생 N명을 대상으로 교육한다.
	//학생이 많아 세 그룹으로 나누어 진행(우수/보통/부진)
	//분반을 나는 기준은 학생들이 미리 제출한 점수를 토대로 score1, score2를 임의로 선정하여 나눈다.
	
	//score2 이상: 우수 분반
	//score1 - score2 : 보통 분반
	//score1 미만: 부진 분반
	
	//각 분반은 원활한 교육을 위해 최소 인원(min) 이상 최대 인원(max) 이하를 만족해야 한다.
	//3개의 분반으로 나누었을 때 학생이 가장 많은 분반과 적은 분반의 학생 수 차의 최솟값을 구하세요.
	
	//만족하는 기준인 score1, score2가 없다면 -1을 출력하세요.
	
	//나의 풀이방법: 세 그룹  a+b+c=N /a,b,c를 for문으로 돌리는데 시작점을 최소 인원, 끝나는 지점을 최대 인원으로 하여 그룹별 수를 미리 지정한다.
	// 여기서 최대 최솟값을 구하여 뺴주면 된다!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) { //한 테스트케이스 시작
			
			int N = sc.nextInt(); //학생수
			int min = sc.nextInt(); //반 학생 수 최소값
			int max = sc.nextInt(); //반 학생 수 최대값
			int maxScore=0;
			
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				maxScore = Math.max(maxScore, score[i]);
			}
			
			Arrays.sort(score); // 숫자 순서대로 맞춰주기 //같은 점수끼리 묶어주기 
			
			//점수를 잘라야 하므로 카운팅 배열 만들어주기
			int[] count = new int[maxScore+1];
			for(int i=0; i<N; i++) {
				count[score[i]]++;
			}
			
			//System.out.println(Arrays.toString(count));
		
			int maxCnt = Integer.MIN_VALUE;
			int minCnt = Integer.MAX_VALUE;
			
			//조건: a+b+c = N | 최소: min 최대: max | 
			for( int a=min ; a<=max; a++) {
				for(int b=min; b<=max; b++) {
					int c = N-a-b;

					int A = a;
					int B = b;
					int C = c;
					
					System.out.println(A+","+B+","+C);
					
					//담아갈 수 미리 다 정함 
					//점수들을 이러한 기준으로 나누기
					//어떻게 수를 상호배타적으로 나누지..? => 카운팅 배열
					
					for(int i=0; i<count.length; i++) {
						if(A>=count[i]) {
							A = A-count[i]; //점수 같은 사람들 a 그룹에 넣어주기
						} else if(B>=count[i]) {
							B = B-count[i];
						} else if(C>=count[i]) {
							C = C-count[i];
						} else { //만약 c가 min을 못 넘는다면 -1을 출력해야 함
							maxCnt = -1;
						}
					}
					
					maxCnt = Math.max(a, Math.max(b, c));
					minCnt = Math.min(a, Math.min(b, c));
					
				}
			}
			
			int result = maxCnt - minCnt;
			
			if(maxCnt == -1) {
				System.out.println("#" + tc + " " + -1 );
			}
				System.out.println("#" + tc + " " + result );
			
			
		} //테스트케이스 끝
	}
	
	

}
