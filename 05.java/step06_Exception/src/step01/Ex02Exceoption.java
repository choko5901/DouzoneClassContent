package step01;


//info.class 

class Info {
	static {
		System.out.println("Info 클래스");
	}
}



public class Ex02Exceoption {

	public static void main(String[] args) {
		
		//step01 -baisic
//		try {
//			// 클래스를 가져다가 사용하기 위해서는
//			// 클래스의 이름이 필요하고 경로또한 필요하다
//			// 어떤패키지의 Info 인지 이클립스에서 구분 못함
////			Class.forName("Info");
//			Class.forName("step01.Info");
//		} catch (ClassNotFoundException e) {
//			//Trace() : 개발시에는 필요하나나중에는 반듯시 지워주자
//			e.printStackTrace();
//		} finally { // 파이널리는 위에 에러가 나면 캐치 구문 다음에 반드시 수행되어지는 코드
//			System.out.println("finally");
//		}
		
		
		// step02 - 예외 처리 순서
		try {
			// NPE
			String str1 = null;
//			System.out.println(str1.length());
			
			// NumberFormatException
			String str2 = "three";
			Integer.parseInt(str2);
		} catch(NumberFormatException e) {
			System.out.println("숫자처리");
		}catch(Exception e) {
			System.out.println("공통 처리");
		}
		
		// 예외 처리 순서를 이왕이면 순서대로 작성하는게 좋다
		// 예외는 다르지만 처리는 공통적으로 하고 싶으면 모든 예외를 받아줄 수있는 객체 Exception 
		// 만약 Exception 사용하기전에 구체적인 따로 예외처리하고 싶은게 있다면 Exception 위에다가 캐치문을 적어두고 마지막에 Exception 객체로 받는다
		// multi -catch 블록 
		// catch(NullPointerException | NumberFormatException e ) {} 이런식으로 같은 처리를 해야하는 것을 연산자로 연결 가능하다
		
		
	}

}
