package step05.interfaceex;

public class CalculatorTest {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		int num1  = 10;
		int num2 = 0;
		
		System.out.println(calculator.add(num1, num2));
		System.out.println(calculator.sub(num1, num2));
		System.out.println(calculator.times(num1, num2));
		System.out.println(calculator.divide(num1, num2));
		
		calculator.description();
	}

}
