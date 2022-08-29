/* 변수
 * 1. 명명
 * 		- 시작은 문자, $, _
 * 		- 대소문자 구분
 * 		- 첫번째 문자는 소문자 시작
 * 		- 개발시 의미있는 이름으로 지정
 * 		- 단어가 이어지는 경우 대문자로 구분
 * 		- 자바 예약어는 주의
 * 		- https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
 * 		- https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 *
 */

package step01;

public class Ex01Variable {

	public static void main(String[] args) {
		// 항상 자바는 타입을 지정 후 변수명 선언 후 값 입력
		// Java Data types
		
		// 정수
		byte vb1 = -128;
		
//		byte vb2 = 128;
		
		short vs1 = 128;
		
		int vi1 = 1008;
		
		long vl1 = 1008;
		
		long vl2 = 10000000000L; //자바는 기준이 int이기 때문에 숫자 뒤에 L 로 long으로 사용
		
		
		// 실수: float
		float vf1 = 3.14f; //float 도 실수의 기준은 double이기 때문에 float로 사용 시에 f를 붙여줘라
		
		// * double
		double vd1 = 3.14;
		
		// char
		
		char vc1 = 'A';
		
		System.out.println(vc1);
		
		char vc2 = 65;
		System.out.println(vc2);
		
		char vc3 = '\u0041';
		System.out.println(vc3);
		
		
		//논리 : boolean
		
		boolean isTrue =true;
		boolean isFalse =false;
		
//		vb1 =127;
//		System.out.println(vb1);
		
//		int vb1 = 10;
		
		
		
		
		
		
	}

}
