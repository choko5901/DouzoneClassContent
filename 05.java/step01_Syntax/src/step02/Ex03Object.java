/*객체 생성과정
 * */





package step02;

public class Ex03Object {

	public static void main(String[] args) {
		/*
		 * 왜 결과가 AAB 로 출력 될까?
		 * ====> B 객체 생성 시점 언제가 되는가 ???
		 * 	====> 객체 생성은 객체가 보유하고 있는
		 * 			모든 멤버 변수(필드)가  메모리에 생성되어야만  객체의 생성이 완료가 된다 !!!!!
		 * 
		 * 
		 * */
		A a = new A();
		B b = new B();
//		C c = new C();
//프로그램 순서는 main 안에서 코드들에 의해 정해지지지 밖에서 안정해지짐
		
		
	}

}


class A {
	A() {
		System.out.println("Class A");
	}
	
}
class B {
	A a = new A();
	B() {
		System.out.println("Class B");
	}
	
}
class C {
	C() {
		System.out.println("Class C");
	}
	
}
