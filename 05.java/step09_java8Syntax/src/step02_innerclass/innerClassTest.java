package step02_innerclass;

class OuterClass {
	private int OuterClassNum = 10;
	private static int staticOuterClassNum = 20;
	private InnerClass inner;
	
	OuterClass() {
		inner = new InnerClass();
	}
	
	// 내부 클래스
	class InnerClass {
		int innerNum = 100;
		// static int staticInnerNum = 200;  에러발생 static 은 클래스 소속이라 클래스 가 static이든 static을 아에 사용 하지 않던 둘중 하나 해야함 특히
		// Inner 클래스는 반드시 static으로 정의되어야  즉 static innerClass로 정의
		
		void innerTest() {
			System.out.println("외부 클래스의 멤버변수(인스턴스 변수)" + OuterClassNum);
			System.out.println("외부 클래스의 static 변수 = " + staticOuterClassNum);
			System.out.println("내부 클래스의 멤버변수(인스턴스 변수) = " + innerNum);
		}
		
	}
	// 외부 클래스의 메소드 정의
	// 외부 클래스로 객체 생성 -> 내부 클래스의 innerTest 메소드에 접근 가능한지 살펴보기 위한 소스코드
	public void usingInnerClass() {
		inner.innerTest();
	}
	
	// 외부 클래스의 객체를 생성하지 않고 바로 내부 클래스의 객체를 생성하는 방법 은 정적 내부 클래스를 이용하면 됨
	static class staticInnerClass {
		int staticInnerNum = 1000;
	}
	
}

public class innerClassTest {

	public static void main(String[] args) {
		
		OuterClass outerClass = new OuterClass();
		System.out.println("외부 클래스를 이용하여 내부 클래스의 기능 호출");
		outerClass.usingInnerClass();
		
		System.out.println();
		
		System.out.println("외부 클래스를 이용하여 내부 클래스 객체 생성");
		
//		InnerClass innerClass = new InnerClass(); 내부클래스는 이렇게 생성 불가
		
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		
		innerClass.innerTest();
		
		// 정적 내부 클래스 생성하는 방법(외부 클래스의 객체 생성 없이 내부 클래스 생성)
		System.out.println();
		
		OuterClass.staticInnerClass staticInnerClass = new OuterClass.staticInnerClass();
		System.out.println(staticInnerClass.staticInnerNum);
		
		
	}

}
