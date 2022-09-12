package step02_collection;

import java.util.ArrayList;

import model.domain.Student;

public class Ex01ArrayList {

	public static void main(String[] args) {

		//ArrayList
		
		ArrayList arr1 = new ArrayList();
		
		// add();
		arr1.add("java");
		arr1.add(new Student("IT",10001,"junior"));
		arr1.add(3); // ArrayList는 객체 타입만 들어갈 수 있으니 3은 비록 원시타입으로 적혀 있으나 integer의 객체타입으로 저장 (오토 박싱이 수행 되었다고 볼수 잇다)
		
		//System.out.println(arr1); 는 그냥 배열과 다르게 arr1을 적으면 메모리 주소가 나오는게 아닌
		//바로 해당 데이터가 바로 출력된다 그말은 ArrayList안에 toString이 재정의 되어 있다는 것이다.
		System.out.println(arr1);
		
		//get(index) : 해당 index 객체 리턴
		// student 객체의 grade 값 출력 ?
		
		System.out.println(arr1.get(1));
		
		// arr1.get 다음에 . 찍어보면 getgrade 매소드가 없고 getClass라던지 빠게 없다 이말은 
		// arr1.get으로 불러 온것 은 object 타입의 객체이며 
		// 내가 getgrade를 사용하려면 그 해당 객체가 Student 객체여야하니
		System.out.println(((Student)(arr1.get(1))).getGrade());
		//비슷한 예로 ArrayList에 java라는 아이의 v만 출력 하고싶다
		// arr1,get(0)에서 바로 charAt이 안써지고 반드시 형변환 후 에 사용이 가능하다
		System.out.println(((String)arr1.get(0)).charAt(2)); 
		
		

		
		
		// size() : 객체 수
		System.out.println(arr1.size());
		
		// remove(index) : 해당 index 객체 삭제
		System.out.println(arr1);
		System.out.println(arr1.remove(0)); // 해당 인덱스의 객체를 삭제 + return
		System.out.println(arr1);
		
		// 제네릭 : 데이터의 타입을 정하는 기능 <Element>
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add("java");
//		arr2.add(new Student("IT",10001,"junior"));
//		arr2.add(3);
		//이 위두개는 애초에 내가 ArrayList로 타입을 제네릭으로 정해놨기 때문에 객체 타입과 integer 타입은 저장이 안되는 것이다
		
		// 위와 다르게 이미 String으로 타입이 정해 져 있기 때문에 별도의 형변환을 할 필요없이 바로 charAt을 사용 가능하다..
		System.out.println(arr2.get(0).charAt(2));
		
		
	}

}
