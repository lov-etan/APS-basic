import java.util.Arrays;

public class String_문자열뒤집기 {
	
	public static void main(String[] args) {
		
		//Java에서는 문자열 읽기는 가능, 원하는 특정 위치에 문자 쓰기x
		String str = new String("algorithm");
		
		char[] charArr = new char[str.length()];
		
		for(int i = 0; i<str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		System.out.println(Arrays.toString(charArr));
		
		//1. 새로운 배열을 만들어서 뒤집기
		char[] nextArr = new char[charArr.length];
		//원본 배열을 정방향 순회하면서 새 배열에 뒤에서부터 써주기
		for(int i=0; i<charArr.length; i++) {
			nextArr[(charArr.length-1) -i] = charArr[i]; //괄호 안이 제일 뒤 인덱스
		}
		
		System.out.println(Arrays.toString(nextArr));
		
		
		
		//2. 원본 배열에서 swap(더 효율적) - 이 배열을 절반만큼만 돌면서 swap해주면 되기 때문에
		char[] charArr2 = str.toCharArray();
		System.out.println(Arrays.toString(charArr2));
		
		int N = charArr2.length;
		for(int i=0; i<charArr2.length/2; i++) { //맨 앞 -> 맨뒤 두번째앞 -> 두번쨰뒤
			char tmp = charArr2[i];
			charArr2[i] = charArr2[charArr2.length -1 -i];
			charArr2[N-1-i] = tmp;
		}
		System.out.println(charArr2);
		
//		//배열에서 문자로 다시 합치기
//		String nextStr = "";
//		for(int i=0; i<charArr2.length; i++) {
//			nextStr += charArr2[i];
//		}
//		//문자열 더하는 과정 반복마다 새로운 문자열 객체 생성하게 됨
//		System.out.println(nextStr);
	}

}
