package step03;

public class SingletonTest {
	public static void main(String[] args) {

//		Sigleton sigleton1 = new Singleton();
		// 이렇게는 객체 생성 불가 왜냐면 Singleton 에서 Sigleton 생성자를 private로 막아놨기 문
		Singleton singleton1 = Singleton.getInstance();
		
		System.out.println(singleton1);
		Singleton singleton2 = Singleton.getInstance();
		
		System.out.println(singleton2);
		
		// 동일한 객체를 하나를 들고와서 서로 다른 명칭의 객체로 저장 한건데
		// 주소가 같은걸 보니 하나의 객체를 가지고 기능을 수행한 것이다.
		// EX05 는 직접적으로 객체를 생성 한거 이기때문에 같은 데이터를 가지고 있어도 데이터 주소가 달라 다른 객체로 인식되
		// 메모리 주소가 다른것이지만
		// 이것은 외부에서 하나의객체를 불러와 명칭만 다른 객체에 저장한것이다.
		// 근데 왜 new로 생성 못하냐 ? 왜 싱클톤으로 설정 해놨기 때문이다
		
		
		

	}

}
