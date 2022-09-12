package exception;

// NotAdminException는 예외 발생시 수행 되어지니 이 클래스를 예외 클래스로 변경하기 위해 상속으로 Exception을 받는다
public class NotAdminException extends Exception{
	//NotAdminException 이것도 객체를 생성하기 때문에 기본생성자가 분명 있을텐데 파라미터값으로 Ex03에보면 스트링값 받으니 다음과 같은 사용자 정의 생성자가 필요하다
	// 기본생성자는 생략 가능하다
	public NotAdminException(String msg) {
		super(msg);
		// super로 부모요소인 Exception에 다음과 같은 파라미터 값을 던지면 
		// Exception 내부에는 스트링 파라미터를 출력하는 기능을 가지고 있어 내가 설정한 에러 예외처리 메세지를 표시 가능하다.
	}
	
}
