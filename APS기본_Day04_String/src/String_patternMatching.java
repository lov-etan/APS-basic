
public class String_patternMatching {
	public static void main(String[] args) {
		String text = "This is a abookd";
		String pattern = "is";
		
		System.out.println(bruteForce(text,pattern));
	}

static int bruteForce(String text, String pattern) {
	int ti = 0;
	int pi = 0;
	
	while(ti<text.length() && pi<pattern.length()) {
		if (text.charAt(ti) != pattern.charAt(pi)) {
			ti -= pi; //pi만큼 움직였으니까 pi를 빼주고
			pi = -1;// (txt와 패턴이 다르니까 자리 그대로 하고싶음)
			
		}
		ti++;
		pi++; //비교하는 문자가 같이 한 칸씩 올라간다
		
	}
	if (pi == pattern.length()) {
		//찾았다
		return ti-pi;
	} else {
		//못 찾았다
		return -1;
	}
		
	}
	
	
}
