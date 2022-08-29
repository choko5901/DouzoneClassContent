package step03;

public class Log4jTest {

	public static void main(String[] args) {
//		Log4j log = new Log4j();
		//이런식으로 매번 외부에 있는 Log4j객체를 생성해 불러 오믄건 메모리적 으로 낭비
		
		//그럼 Log4j 자체를 싱글톤 패턴으로 적용하면 낭비를 축소 가능
		
		Log4j log = Log4j.getInstance();
		
		String admin = "admin";
		String user = "it";
		
		if(user.equals(admin)) {
			log.info();
					
		}else {
			log.warn();
		}
		
		
		
	}

}
