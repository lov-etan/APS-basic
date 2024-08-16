package D2;

import java.util.Scanner;

public class 간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) { // 1,2,3,4,5,6....
			String num = Integer.toString(i);// 수를 string으로 변환

			if(is369(num)) {
				System.out.print(lets369(num) +" ");
			} else {
				System.out.print(num + " ");
			}

		}
	}

	static String lets369(String num) {
		String clap = "";

		for (int j = 0; j < num.length(); j++) {
			int numb = num.charAt(j) - '0';
			if (numb == 3 || numb == 6 || numb == 9) {
				clap += "-";
			} 
		}
		return clap;

	}

	static boolean is369(String num) {
		for (int j = 0; j < num.length(); j++) {
			int numb = num.charAt(j) - '0';
			if (numb == 3 || numb == 6 || numb == 9) {
				return true;
			}
		}
		return false;
	}
}
