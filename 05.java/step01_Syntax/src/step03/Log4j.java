package step03;


// 시스템 로그 기록과 관련되어 있는 클래스 예제

public class Log4j {
	
	private static Log4j instance =new Log4j();
	
	private Log4j() {}
	
	public static Log4j getInstance() {
		return instance;
	}
			
	
	public String info() {
		return "알림 : 관리자 접근";
	}
	
	
	public String warn() {
		return "경고: 접근불가";
	}
	
	
	

}
