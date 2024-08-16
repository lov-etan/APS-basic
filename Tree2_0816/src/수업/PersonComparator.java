package 수업;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
	
	@Override
	//(o1,02)
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}

}
