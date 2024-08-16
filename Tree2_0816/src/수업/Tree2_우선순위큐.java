package 수업;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.age;
	}

	@Override
	//o:상대방
	//(나, 상대방)
	public int compareTo(Person o) {
		//비교기준은 나이 
		// -1(음수), 0 , 1(양수) 셋 중 하나를 리턴
		// -1, 0, 1 셋 중 하나를 리턴
		// 0: 동일하다
		// 1: 위치를 바꾼다.
		// -1: 위치를 바꾸지 않는다.
		
		if(this.age == o.age)
			return 0;
		if(this.age > o.age) //오름차순으로 해. 내 나이가 더 커. 내가 더 뒤로 가야 해
			return 1;
		return -1;
		
		//return this.age - o.age; - 그냥 나이 빼서 양수, 음수, 0 출력하게끔 해도 됨
	}
	

		 
		

	
}

public class Tree2_우선순위큐 {
	public static void main(String[] args) {
		//기본: 최소힙 (오름차순)
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(-10);
		pq.add(40);
		
		while(!pq.isEmpty()) {
			int data = pq.poll();
			System.out.println(data);
		}
		
		
		//최대힙으로는 어떻게 바꿀까?
		//1.부호를 반대로 바꿔서 넣어주기
		//2.우선순위 큐 생성자 안에 Collections.reverseOrder() 넣기
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq2.add(10);
		pq2.add(20);
		pq2.add(30);
		pq2.add(-10);
		pq2.add(40);
		
		while(!pq2.isEmpty()) {
			int data = pq2.poll();
			System.out.println(data);
		}
		
		//나이순으로 출력하고 싶다.
		PriorityQueue<Person> personPQ = new PriorityQueue<>(new PersonComparator());
		//PriorityQueue<Person> personPQ 
		//								= new PriorityQueue<>((p1,p2) -> {return p1.age - p2. age});
		
		personPQ.add(new Person("루나", 3));
		personPQ.add(new Person("데이지", 1));
		personPQ.add(new Person("맥스", 5));
		
		while(!personPQ.isEmpty()) {
			Person p = personPQ.poll();
			System.out.println(p);
		}
		//정렬 기준이 없어 pq 안에 person 객체를 넣을 수 없다.
		// 정렬기준
			// 1. comparable 인터페이스 구현
			//2. comparator 객체를 하나를 만들어 우선순위 생성자에 넣어주는 방법 - 밖에서 정렬 기준 정하기
	}

}
