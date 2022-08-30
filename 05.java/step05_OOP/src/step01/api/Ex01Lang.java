package step01.api;

import java.util.StringTokenizer;

class IT {
	
	public int num;
	
	public IT(int num) {
		this.num =num;
		System.out.println("IT" + num + "가 생성되었습니다.");
	}
	
	
	// finalize는 toString과 마찬가지로 자동으로 호출되는 메소드
	// 단, finalize는 객체가 사라지는 경우 동작
	public void finalize() {
		System.out.println("IT" + num + "가 제거 되었습니다.");

	}
	
}



public class Ex01Lang {

	public static void main(String[] args) {
//		Object 클래스
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		//같은 객체인지 비교방법
		System.out.println(obj1 == obj2);
		// 스트링과 다르게 값만 비교 하는게 아닌 equals는 객체에서는 동일 개체인지 비교후 결과 반환
		System.out.println(obj1.equals(obj2));
		
		//hashCode() : 객체 주소값을 정수로 변환 반환
		
		System.out.println(obj1.hashCode());
		
		//toString() : 객체 정보를 문자열로 반환
		// 개발자가 호출하지 않아도 객체 호출 시 자동적으로 실행되는 메소드
		System.out.println(obj1);
		System.out.println(obj1.toString());
		
		// System 클래스
		// gc(): 쓰레기 수집기 메소드
		
		IT it;
		
//		it = new IT(1);
//		it = null;
//		it = new IT(2);
//		it = new IT(3);

		// 어플리케이션이 구동되는 동안 , 메모리 상에서 제거된 객체를 삭제하는 메소드
		// 직접 호출 하지 않아도 알아서 실행되는 메소드
		
		
//		System.gc();
		
		// getProperty() : 시스템 속성값
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.runtime.name"));
		
		
		//String 클래스
		// 객체 비교 : == , != / equals
		
		// charAt() : 지정 인덱스의 위치 문자를 반환
		String str1 = "Java API";
		System.out.println(str1.charAt(6));
//		System.out.println(str1.charAt(8)); 에러
		
		// length() : 문자열 길이 반환
		System.out.println(str1.length());
		
		// indexOf() : 찾고자 하는 문자의 위치 반환
		System.out.println(str1.indexOf("API"));
		
		// 대소문자로 변경
		
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		// substirng() 지정 위치에서 또 다른 지정 위치의 문자열을 반환
		
		System.out.println(str1.substring(0));
		System.out.println(str1.substring(0,5));
		
		// replace() : 지정 문자열을 변경 하는 메소드 
		
		System.out.println(str1.replace("Java", "자바"));
		
		
		// trim() : 문자열의 앞, 뒤 공백을 제거
		
		String strTrim = " Java API		";
		System.out.println(strTrim.trim());
		
		
		// split() : 특정 구분자를 기준으로 분리된 문자열 반환
		
		String strSplit = "Java API String Test";
		
		System.out.println(strSplit.split(""));
		//결과가 [Ljava.lang.String;@7852e922 나오는데 주소 값 앞에 [ 있다는건 이  split의 결과값은 베열로 나온다는 뜻이다
		
		// Split 은 정규 표현식을 사용
		String[] strSplitArr = strSplit.split("");
		for(String str: strSplitArr) {
			System.out.println(str);
		}
		
		// StringTokenizer 클래스  이아이는 Lang 소속이 아닌 util 소속이다
		// StringTokenizer는 일반 문자열로 
		StringTokenizer strTokenizer = new StringTokenizer(strSplit, " ");
		
		while(strTokenizer.hasMoreTokens()) {
			System.out.println(strTokenizer.nextToken());
		}
		
		// StringBuilder
		// String vs StringBuilder
		// String은 불변 객체 !!!
		String str = "abc";
		System.out.println("before :" + str.hashCode());	
		// 걍 문자를 추가한 거 뿐인데 해쉬코드를보면 다른 객체가 생성 되어진 것을 알 수 있다.
		str += "def";
		System.out.println(str);
		System.out.println("after :" + str.hashCode());
		
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		System.out.println("berfore :  " + sb.hashCode());
		// StringBuilder를 사용하면 같은 객체 하나에 더붙여 줄 수 있어 메모리 자원관리에 있어 더 효율적
		sb.append("def");
		System.out.println("after :  " +sb.hashCode());
		
		
		sb.delete(4, 5);
		System.out.println(sb);
		
		sb.insert(4, "e");
		System.out.println(sb);
		
		// getClass는 어떤 클래스의 객체로 생성되어있는지 알수 있는 문법
		System.out.println(sb.getClass());

		
		
		// valueOf() : 기본타입을 문자열로 변환
		int i = 10;
		System.out.println(String.valueOf(i));
		// 원시타입은 객체로 생성되는게 아니기 때문에 getClass사용 불가
//		System.out.println(i.getClass()); 사용 못함
		
		
		// Wrapper 클래스: 기본타입의 값을 갖는 객체를 생성하는 클래스 (기본타입의 첫 문자를 대문자로 가지는 특징 있음)
		//박싱
		Integer intgr2 = new Integer(10);
		
		System.out.println(intgr2.getClass());
		
		//언박싱
		int i2 = intgr2.intValue();
		System.out.println(i2);
		
		// 자동 박싱 _ 자동 언박싱
		
		Integer intgr3 = 3;
		int i3 = intgr3;
		
		// parseXXX : 문자열을 기본타입으로 변경
		System.out.println(Integer.parseInt("3"));
		System.out.println(Double.parseDouble("3"));
		
		// Math 클래스
		// abs() : 절대값 표현하는 메소드
		
		System.out.println(Math.abs(-6.3));
		
		// ceil() 올림, floor() 내림, round() 반올림
		
		System.out.println(Math.ceil(2.1));
		
		// max() min()
		
		System.out.println(Math.max(3, 4));
		
		// random() 0.0 ~ 1.0 사의의 무수한 값
		
		// 1~ 10까지의 난수
		
		System.out.println((int)(Math.random()*11));
		
		
		
		
	}

}
