package step02_collection;

import java.util.HashSet;
import java.util.Iterator;

public class Ex02HashSet {

	private static final String Iterator = null;

	public static void main(String[] args) {
		// HashSet
		HashSet<String> set = new HashSet<String>();
		
		//add()
		
		set.add("Java");
		set.add("IT");
		set.add("Dev");
		set.add("Lazy");
		set.add("Lazy");
		set.add("Happy");
		
		//중복된 Lazy 값은 단 한번만 저장 시킨다 그냥 ArrayList였음 뒤에 붙어 나왔겠지만 set은 ArrayList와 다르게 인덱스가 아닌 내부 저장 알고리즘이 있음
		System.out.println(set);
		
		//for문 이용한 출력 
		for(String str: set) {
			System.out.println(str);
		}
		System.out.println();
		//iterator : 반복 가능한 객체에 적용 할 수 있는 기능
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		System.out.println(set.isEmpty()); // set이 비어있는지 없는지 비어있음 트루 값이 있으면 펄스
		set.remove("Lazy");
		System.out.println(set.contains("Lazy")); // 해당 데이터가 있는지 없는지 묻는법
		
		
	}
	
}
