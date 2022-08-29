/* 싱글톤 패턴(Singleton Pattern)
	- 하나의 객체만 만들어서 내부적인 메소드 혹은 정보를 사용하는 경우
	- 자원 절약 가능
	프린터 드라이버
		여러 컴퓨터에서 프린터 한대를 공유하는 경우
		하나를 끝내고 다음 작업을 하는 것이 아닌 동시에 섞여 나오면 안될 것임.
		Singleton 패턴: 여러 클라이언트(컴퓨터)가 동일 객체(공유 프린터)를 사용하지만 한 개의 객체(프린트 명령을 받은 출력물)가 
		유일하도록 상위 객체가 보장하도록 하는 것
		동일한 자원이나 데이터를 처리하는 객체가 불필요하게 여러 개 만들어질 필요가 없는 경우에 주로 사용
 */


package step03;

public class Singleton {
	// 맴버 변수 : 외부에서의 접근을 제한을 하기위해 private를 붙인다 
	private static Singleton instance = new Singleton();
	
	// 생성자에 private를 붙이면 다른 외부에서 객체 생성 불가
	
	private Singleton() {
		
	}
	
	// public 메소드: 내부에서 생성된 객체를 외부에서도 호출 하게끔 만듬
	public static Singleton getInstance() {
		// 반드시 return 하고자하는 데이터 타입을 명시해줘야하는데 이때 instance의 객체 타입은 Singleton 이라고 내가 위에 만들어 놨다 // 17번?줄
		return instance;
	}

}
