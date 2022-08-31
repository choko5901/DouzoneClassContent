package step03.override;

/* 값 비교
 * 1. 기본타입
 * 	- ==
 * 
 * 2. 참조타입
 * 	- == : 주소값 비교
 * 	- equals() : 
 * 			
 * 
 * 3. String의 equals()
 * 	- Object 클래스의 주소값 equals() 재정의 -> 서로 다른 객체라도 데이터 값을 비교
 * 
 * 4. java.lang.Object의 equals()
 * 	- public boolean equals(Object o){
 * 	  	객체의 주소값을 비교
 * 		return true or false;
 *    }
 */


class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	/*
	 * 	equals() : 재정의
	 *
	 * 	- 매개변수로 들어온 Object 타입의 객체 -> Person 타입으로 형 변환이 가능한가?
	 *  - 형변환이 가능하다면 -> 각각의 name과 age 멤버 변수를 비교
	 *  - name과 age 같다면 -> return true
	 * */
	
	@Override // objcet의 equals를 재정의 하려면 equals에 Object관련 모든 메소드가 재정의 되어야 해서 Object o를 내부에 작성
	public boolean equals(Object o) {
		
		// equals를 사용한 객체는 모두 object로 들어오니 o에 파라미터로 받는다
		
		if(o instanceof Person) {
			if(((Person)o).name == this.name && ((Person)o).age == this.age) {
				return true;
			}
			
			
		}
		
		
		return false;
	}
	
	
	
}

class Person2{
	String name;
	int age;
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	
	
}



public class EqualsOverride {

	public static void main(String[] args) {
		Person p1 = new Person("java", 26);
		Person p2 = new Person("java", 26);
		Person2 p3 = new Person2("java", 26);
		
		// 같은 객체가 있을까? 
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		// 응 전부 false 
		
		// 주소값 출력
		
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
//		System.out.println(p3.hashCode());
//		
//		그럼 		Person p1 = new Person("java", 26); 		Person p2 = new Person("java", 26); 는 같은 데이터에 같은 객체 및 타입으로 생성 되어있는데 주소값이 다르니
		// 내가 한 의도는 둘이가 같은 주소를 가지게 끔 하고 싶다 ? 그럼 나는 equals 를 재정의 하여 같아 지게끔 해줘야한다


		
		
		
	}

}
