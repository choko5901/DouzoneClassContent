package blood.transfusion.exception;

public class NotExistException extends Exception {

	public NotExistException() {};
	public NotExistException(String msg) {
		// Exception을 부모로 상속 받았기떄문에 에러 메세지로 super로 전달만하면 출력하는
		// 내부 기능이 있어 별도로 머 안적어도 됨
		super(msg);
	};


}
