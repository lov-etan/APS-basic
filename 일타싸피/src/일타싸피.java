
public class 일타싸피 {
	
	public static void main(String[] args) {
		
		double WIDTH = 254;
		double HEIGHT = 127;
		//공의 크기: 5.73
		double R = 5.73/2;
		
		//두 공의 위치
		double x1 = 70;
		double y1 = 60;
		
		double x2 = 167;
		double y2 = 100;
		
		double angle = Math.atan((y2-y1)/(x2-x1));
		System.out.println(angle);  //라디안: 각을 실수로 나타낸 것
		double degree = Math.toDegrees(angle); //라디안 -> 각도
		System.out.println(degree);//22도
		
		//20도로 했는데 예상과 다른 방향으로 간다? -> 기준이 다를 수 있다 
		//90도에서 해당 값을 빼줘야 하는 것과 같은 것들이 있을 수 있따
		
		//y1-y2 좌표 음수 나오면 헷갈릴 수 있다. 180도 넘어가면 그르니까...
		//switch나 if문 사용해서 180-각도 //이렇게 해줘야 할 것이다
		
		 
		
	}

}
