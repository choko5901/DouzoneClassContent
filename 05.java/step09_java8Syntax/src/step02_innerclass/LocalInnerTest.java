package step02_innerclass;

class Outer {
	int outerNum = 10;
	
	// 로컬 클래스
	
	Runnable getRunnable(final int i) {
		
		int localnum = 100;
		
		// 자바 내부에서 Runnable 이라는 인터페이스가 있어서  implements로 상속 받고

		class MyRunnable implements Runnable{
			int num = 1000;

			@Override
			public void run() {
				System.out.println("i = " + i);
				System.out.println("outerNum(외부 클래스 인스턴스 변수) = " + outerNum );
			}
			
		}
			return new MyRunnable();
	}
	
	// 익명 클래스 : 클래스 명이 없는 클래스
	
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Runnable이 구현된 익명 클래스");
			
		}
	};
	
		
}
	
	
	




public class LocalInnerTest {

	public static void main(String[] args) {
		//지역 로컬 클래스
		Outer outer = new Outer();
		
		Runnable runner = outer.getRunnable(1);
		runner.run();
		
		// 익명 클래스
		
		outer.runner.run();
		
	}

}
