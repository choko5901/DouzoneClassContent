package step04.abstractex;

public abstract class Computer {

	
	public void display() {
		System.out.println("기본 컴푸터 화면 구성");
	}
	
//	abstract public void typing() {
//		System.out.println("기본 컴푸터 화면 구성");
//
//	} 에러 왜냐하면 abstract 는 선언만 해야한다
	
	abstract void typing();
	
	public void turnOn() {
		
	}
	
	public void turnOff() {
		
	}
	
	
	
	
	
	
}
