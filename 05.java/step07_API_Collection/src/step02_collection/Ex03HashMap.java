package step02_collection;

//import 필요한거 단축키 컨트롤 쉬프트 o
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.domain.Student;

public class Ex03HashMap {

	public static void main(String[] args) {
		//Map이라는 인터페이슬 수행하기 위한 Hash 클래스
		//K: 기본타입 불가능 항상 Wrapper클래스 입력 
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		
		// put() : 추가
		hm1.put("a",1);
		hm1.put("b",2);
		hm1.put("c",3);
		hm1.put("d",4);
		
		System.out.println(hm1);
		
		System.out.println();
		// get(key): key -> value
		
		System.out.println(hm1.get("a"));
		
		//remove(key) key -> key : value 키로 값 삭제후 그 삭제한 값 리턴해줌
		System.out.println();
//		System.out.println(hm1.remove("b"));
		System.out.println(hm1.get("b")); // null 값으로 출력
		System.out.println(hm1);
		
		
		//
		
		HashMap<String, Student> hm2 = new HashMap<String, Student>();
		hm2.put("k1", new Student("IT", 10001, "Junior"));
		
		//hm2 junior 출력하기
		
		System.out.println(hm2.get("k1").getGrade());
		
		// HashMap<String, ArrayList>
				ArrayList<String> arr3 = new ArrayList<>();
				arr3.add("a");
				arr3.add("b");
				arr3.add("c");
				arr3.add("d");	
				
				HashMap<String, ArrayList<String>> hm3 = new HashMap<String, ArrayList<String>>();
				hm3.put("arr3", arr3);
				
				System.out.println(hm3); // 결과 {arr3=[a, b, c, d]}
				
				// b값만 출력??
				System.out.println(hm3.get("arr3").get(1));
			
				//HashMap<String, HashMap>
				HashMap<String, HashMap> hm4 = new HashMap<String, HashMap>();
				hm4.put("hm3", hm3);
				
				System.out.println(hm4);
				
				// b값 출력?
				
				System.out.println(((ArrayList)hm4.get("hm3").get("arr3")).get(1));
				
				//hm4.get("hm3").get("arr3")).get(1) ? 이렇게 바로 출력하고 싶으면?
				//애초에 생성할때 HashMap 에 넣어줄 HashMap에 대한 제네릭 타입까지 전부 적어주면 된다
				HashMap<String, HashMap<String, ArrayList<String>>> hm5 = new HashMap<>();
				hm5.put("hm3", hm3);
				System.out.println(hm5.get("hm3").get("arr3").get(1));
				
				// key를 알아야 value를 알수 있는게 지금까지 배운 거다
				// keyset :해당 객체가 갖고 있는 key만을 출력
				
				System.out.println(hm1);
				System.out.println(hm1.keySet());
				
				// hm1 -> values() : 해당 객체가 갖고 있는 value만을 출력
				System.out.println(hm1.values());
				
				
				Set<String> keySet = hm1.keySet();
				Iterator<String> iter = keySet.iterator();
				while(iter.hasNext()) {
//					System.out.println(iter.next());
				// key만 출력되고 있는 상황 key:value 한쌍으로 출력 하고 싶으면 ??
//					System.out.println(iter.next() + " " + hm1.get(iter.next()));
					// 문제점 위에 는 next를 할때마다 다음값을 가져오기때문에 처음에는 a 값불러올때는 이미 next로 b로 갔기때문에 2
					// 이런식의 문제가 발생한다
					
					// 해결책으로 key 값을 다른 변수에다 저장 을 하고 그 변수에 저장된 키값을 이용해 출력 하면 해결된다
					
					String key = iter.next();
					
					System.out.println(key + "" + hm1.get(key));
					
				
					
				}
				
				

		
	}

}
