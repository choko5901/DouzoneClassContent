package step05.interfaceex;

//public class Calculator extends Calc{
// 단일 상속이 원칙이라 인터페이스 와 다르게 또 다른 클래스를 상속 받을 수 없음! 

//	@Override
//	int add(int num1, int num2) {
//		
//		return num1 + num2;
//	}
//
//	@Override
//	int sub(int num1, int num2) {
//		return num1 - num2;
//	}
//
//	@Override
//	int times(int num1, int num2) {
//		return num1*num2;
//	}
//
//	@Override
//	int divide(int num1, int num2) {
//		if(num2 ==0) {
//			return ERORR;
//		}
//		return num1 / num2;
//	}
//	
//	
//
//}


// 인터페이스로 구현
//
public class Calculator implements Calinterface, CalcConnectorInterface {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2 ;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2 ==0) {
			return ERORR;
		}
		return num1 / num2;
	}

	@Override
	public void tvConnerctor() {
		System.out.println();
	}
	
	
}
