package step02.oop;

//부모클래스

class Parent {
	String name;
	int age;
	
	public Parent(){
		System.out.println("부모 생성자");
	}
	
	void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println("부모 메소드");
	}
	
}


//extends Parent 어떤 클래스에서 상속되었는지 표시

public class Child extends Parent{
	String wish;
	
	public Child() {
		System.out.println("자식 생성자");	
	}
	//메소드 오버라이딩 부모의 메소드의 파라미터 형태와 내용과 argument list 가 같으면 자식의 메소드를 사용하는 것을 오버라이딩 이라한다.
	void printInfo() {
//		System.out.println(name);
//		System.out.println(age);
		super.printInfo(); // 부모에 있는 자식의 공통 메소드를 부모에서 불러 사용하기 위해 super 을 사용
		System.out.println(wish);
		System.out.println("부모 메소드");
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		child.wish = "game";
		child.name = "Java";
		child.age = 26;
		
		// 자식 생성자는 반드시 부모 생성자가 생성 된 후 생성 되니까 내가 자식만 생성 했지만
		// 출력에는 부모 생성자 생성 이후 에 자식 생성자가 만들어 진 것으로 나옴
		// 사실 자식 생성자 이전에 super(); 라는 것이 생략 되어 있음
		// super(); 는 부모 생성자 호출 하는 역할
		
		child.printInfo();
		
//		Parent parent = new Parent();
//		parent.hashCode();
		
		// 모든 클래스는 extends Object가 생략 되어 있음 그렇기 때문에 모든 class 는 object 클래스의 기능을 사용이 가능
		// 자바는 단일 상속의 원칙을 하기 때문에 한번 extends가 있으면 다른 부모러 부터 상속 불가

		// 다형성: 타입을 다양하게 변경 할 수 있다.
		
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		// 부모 타입으로 자식 객체를 생성 해봄 분명 자식 객체이나 부모 타입으로 만들어 졌기 때문에 자식요소만 가진 메소드는(wish 메소드) 사용 불가
		// 단, Child클래스가 부모의 메소드를 오버라이딩 하고 있다면 자식이 호출한 메소드는
		// 오버라이딩 된 자식의 메소드가 호출 된다. -> 오버라이딩은 좀 예외 사항임
		Parent c2 = new Child();
		/*
		 * Child pc = new Child();
		 * Parent c2 = pc; 이 주석 된 2줄이
		 * Parent c2 = new Child(); 한줄 과 내용이 같다
		 * 
		 * 이렇게 자식 객체가 부모타입으로 생성되는 것을 자동 타입 변환 이라 한다.
		 * 
		 * */
		
		
		// 그럼 반대로 부모 객체가 자식 타입 으로 생성 이 될까?
//		Child p2 = new Parent(); 부모는 자식으로 자동 타입 변환이 되지 않는다 즉 생성이 불가

		// 강제 타입 변환 : 자식 객체가 부모타입으로 생성 되었다가 다시 자식 타입으로 변환
		Parent c3 = new Child();
		Child c33 = (Child)c3;
		
		c2.printInfo();
		
		
		
		
		
		
	}

}
