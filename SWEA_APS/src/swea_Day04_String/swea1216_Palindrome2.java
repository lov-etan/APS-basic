package swea_Day04_String;

import java.util.Scanner;

public class swea1216_Palindrome2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//10개의 테스트케이스 시작
		for(int tc=0; tc<10; tc++) {
			int T = sc.nextInt();
			char[][] arr = new char[100][100];
			
			//100*100 배열칸에 우선 값 채워넣기
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					String str = sc.next();
					arr[r][c] = str.charAt(0); //문자열의 첫 번째 문자 추출 후 넣기
				}
			}
			
			//가장 긴 회문의 길이
			int max = 0;
			
			
			//가로 정방향 순회 시작
			//N길이의 배열칸에 넣고 회문 판단하기(100->1칸으로 줄여나간다)
			for(int N=100; N>0; N--) { //length 100부터 줄여나가서 범위 안 검사
				int tmp =0; //행 안에서 적정 길이를 찾으면 여기다가 저장할 것 임(tmp=N예정)
				for(int r=0; r<100; r++) { //행 검사 
					for(int c=0; c<100-N+1; c++) { //N뭉텅이로 자를 때의 열
						//___N 뭉텅이로 자를 (r,c) 좌표 설정 끝
						
						boolean isPalindrome = true;
						for(int i=c; i<(N-c)/2;i++){
							if(arr[r][i] != arr[r][(N-1)-i]) { //첫 열 끝 열 비교비교
								isPalindrome = false;
								break;
							}
						}
						tmp = (isPalindrome ? N:0);
					}
						
				}
				if(tmp>max) {
					max = tmp;
				}
			}
			
			
			//세로 정방향 순회 시작
			//N길이의 배열칸에 넣고 회문 판단하기(100->1칸으로 줄여나간다)
			for(int N=100; N>0; N--) { //length 100부터 줄여나가서 범위 안 검사
				int tmp =0; //행 안에서 적정 길이를 찾으면 여기다가 저장할 것 임(tmp=N예정)
				for(int c=0; c<100; c++) { //행 검사 
					for(int r=0; r<100-N+1; r++) { //N뭉텅이로 자를 때의 열
						//___N 뭉텅이로 자를 (r,c) 좌표 설정 끝
						
						boolean isPalindrome = true;
						for(int i=r; i<(N-r)/2;i++){
							if(arr[i][c] != arr[(N-1)-i][c]) { //첫 열 끝 열 비교비교
								isPalindrome = false;
								break;
							}
						}
						tmp = (isPalindrome ? N:0);
					}
						
				}
				if(tmp>max) {
					max = tmp;
				}
			}
			
			System.out.println("#" + T + " " + max );
				
		}//케이스 돌고돌아
		
						
			
		}
	
		
	}


