package test;

class Person{
	private String personName = "person";
	public void method1() {
		System.out.println("person");
	}
}
class Student extends Person{
	private String studentName = "student";
	
	public void method1() {
		System.out.println("student");
//		super.method1();
	}
	
}

public class Test1 {
	public static void main(String[] args) {
		
		// Test1-1 객체 생성 방법이 잘못된 부분과 그 이유는?
//		Student student1 = new Student();
//		Person student2 = new Student();
//		Person person1 = new Person();
//		Student person2 = new Person();
		
		System.out.println("정답 Test1-1");
		//Student person2 = new Person(); 이게 잘못 됬다 왜냐하면 Person은 Student 의 부모 요소로 Student가 extends로 Person을 상속 받았는데
		//그땐 부모 객체를 생성하는데 자식 타입으로 생성 할 순 없기 때문에 에러가 나는 것이다.
		
		
		// Test1-2 student3에서 자식의 메소드 호출하고 student4에서 부모의 메소드를 호출하려면?
		Person student3 = new Student();
		Student student4 = new Student();
		student3.method1();
	    student4.method1();
	     
		// 결국엔 student3 이나 student4는 Student 객체를 생성 하기 때문에 부모로부터 상속받아  오버라이딩 한 메소드는 부모 클래스의 매소드 보다 우선 순위를 가지기 때문에
		 // Student 객체의 method1 메소드 와 그 내부의 super 가 person 의 method1 보다 우선순위가 높아 둘다 Student의 method1과 그 내부의 super을 호출 하게 되는 것이다
		
	}
}
