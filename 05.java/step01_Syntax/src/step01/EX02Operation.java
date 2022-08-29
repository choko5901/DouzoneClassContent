package step01;

public class EX02Operation {

	public static void main(String[] args) {
		// Ex03Operation.java
//		 숫자 연산
//		 기본 연산 : +, -, *, /, %
		System.out.println("===기본연산===");
		int v1 = 10;
		int v2 = 3;
		
//		System.out.println(v1 + v2);
//		System.out.println(v1 - v2);
//		System.out.println(v1 * v2);
//		System.out.println(v1 / v2);
//		System.out.println(v1 % v2);
		
		// 증감 연산 : ++, --
		System.out.println("===증감연산===");
//		System.out.println(v1);
//		System.out.println(v1++);
//		System.out.println(v1);
//		System.out.println(++v1);
//		System.out.println(v1);
		
		// 3.33.... 으로 출력?
		// 타입변환이 필요하다 --> Wrapper Class
		
//		System.out.println(v1/(float)v2);

		// Infinity, NAN
//		System.out.println(v1 % 0.0);
		// 0 : java.lang.ArithmeticException
		// 0.0: Infinity
		// % 0.0 : NaN
		
		
//		// 논리 연산 : &&, ||, ^, !
		System.out.println("===논리연산===");
		boolean t = true;
		boolean f = false;
		
		// && : 모든 연산자가 true라면 결과도 true
//		System.out.println(t & t);
//		System.out.println(f & f);
//		System.out.println(t & f);
//		System.out.println(f && t);
		
		// || : 연산자중 하나만 true라도 결과는 true
//		System.out.println(t || t);
//		System.out.println(f || f);
//		System.out.println(t || f);
//		System.out.println(f || t);
		
		// ^ : 연산자 하나는 true, 다른 하나는 false일때 결과는 true
		System.out.println(t ^ t);
		System.out.println(f ^ f);
		System.out.println(t ^ f);
		System.out.println(f ^ t);
		
		// ! : 논리값을 변경 (t -> f, f -> t)
//		System.out.println(f);
//		System.out.println(!f);
		
		// 비교연산 : <, >, <=, >=, ==, !=
		System.out.println("===비교연산===");
		int num1 = 1;
		int num2 = 10;
//		System.out.println(num1 == num2);
//		System.out.println(num1 != num2);
//		
//		double num3 = 1.0;
//		System.out.println(num1 == num3);
		
		// 대입연산 : =, +=, -=, ...
		System.out.println("===대입연산===");
//		int assign = 0;
//		System.out.println(assign);
//		assign += 10;
//		System.out.println(assign);
//		assign -= 5;
//		System.out.println(assign);
//		assign *= 5;
//		System.out.println(assign);
		
		
		
		// 문자 !== 문자열 임
		// 문자는 '' 로 하나의 문자만 사용 문자열은 "" 로 여러 문자 사용
		// 문자열(String) 연산
		
		
		String str1 = "문자열 연산1";
		String str2 = "문자열 연산1";
		String str3 = new String("문자열 연산1");
		// 자바에서는 문자열 연산은 덧셈 말고는 안된다
		System.out.println(str1 +" "+ str2 + " " + str3);

		
		// 문자열 비교 연산자
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		// 왜 2번쨰는 false 일까 == 는 객체 종류까지 (객체 주소 ) 비교 하기 때문이다 
		
		// equals : 객체 데이터값만 비교
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		
		// 삼항 연산
		
		
		// 비트연산
		// <<, >> , >>>
		// a << b : 정수  a를  b 비트 수 만큼 자리 이동 후  빈 곳은 0 채워진 숫자 연산
		// 이미지 있음
		//16
//		System.out.println(2 << 3);
		// 0
//		System.out.println(2 >> 3);
		
		// |, &, ^, ~
		// 00000010 //00010010

		// & 같은 위치의 비트값이 1일때만 1로 출력
		System.out.println(2 & 18);
		
		// | 각 비트자리 중 하나라도 1이면 1로 출력
		System.out.println(2 | 18);
		// ^ 각 비트 자리가 0,0 이나 1,1이 아닐때만 1로 출력
		System.out.println(2 ^ 18);
		
		// ~
		System.out.println(~25);
		
		// 00011001
		// 보수법 을 생각 해봅시다용
		// 11100110 
		
		
		
		
		
	}

}
