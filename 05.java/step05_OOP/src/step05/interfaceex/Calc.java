package step05.interfaceex;

public abstract class Calc {
	public static final double PI = 3.14;
	public static final int ERORR = -999999;
	
	abstract int add(int num1, int num2);
	abstract int sub(int num1, int num2);
	abstract int times(int num1, int num2);
	abstract int divide(int num1, int num2);
	
	void description() {
		System.out.println("정수 계산기를 구현 합니다.");
		
	}
}
