package step05.interfaceex;

public interface Calinterface {
	
	// 인터페이스에서는 Calc.java랑 다르게 구지 필드를 상수로 	public static final double PI = 3.14;
//	 적을 필요없이 자동으로 적용한다
	double PI = 3.14;
	int ERORR = -999999;
	
	//인터 페이스에서는 Calc.java랑 다르게 구지 메소드 선언시 abstract 할 필요가 없이 자동으로 적용됨
	 int add(int num1, int num2);
	 int sub(int num1, int num2);
	 int times(int num1, int num2);
	 int divide(int num1, int num2);
	 
	 
	 // 인터페이스에서는 void 타입은 default를 붙여 줘야함
	 // 인터페이스에서는 static 메소드는 사용가능
	 
	 default void description() {
			System.out.println("정수 계산기를 구현 합니다.");
			
		}
	 
	
	
}
