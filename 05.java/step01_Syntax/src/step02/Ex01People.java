/* 참조 타입
 *  - 기본 타입처럼 실제 데이터 값이 아닌 객체의 주소를 참조하는 타입
 *  - 변수 스택(stack), 객체 힙(heap) 영역에서 생성
 *  - 기본 값 : null
 *  	- 참조할 객체가 없을 경우, NullPointerException 발생
 */
/* 클래스와 객체
 *  - 데이터 값을 저장 및 제공
 *  
 *  - 설계
 *   1. 데이터 : name, age
 *   2. 기능 : name, age 반환 / 단순 출력
 * 
 *  - 개발
 *   1. 데이터 저장에 필요한 메모리
 *   2. 기능 구별, 수행을 위한 코드 작성
 *   	* 객체 생성
 *   
 *  - 클래스를 개발하는 것이 객체를 만드는 것은 아니다
 */


package step02;

public class Ex01People {
	// 멤버 변수(필드)를 사용 class 밑에 사용 되는 것
	
	String name = "java";
	int age = 26;
	
	// 기본생성자
	// - 클래스에 선언하는 메소드의 한 종류
	// - 객체 생성시 자동으로 호출
	// - 클래스의 이름과 같음, 타입 x , 반환값 x
	// - 객체 생성 시 초기화를 위함
	
	
	Ex01People() {};
	
	// 메소드
	// 이름 반환 메소드
	// - 기능 : 이름 반환(return)
	// - 메소드명: getName
	
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	
	//return 없다면 ??
	
	void printInfo() {
		System.out.println("아무내용 없다르");
		System.out.println(age + " " + name);
	}
	// 무조건 자바는 데이터 타입을 써야한다 아무리 아무 기능이 없더라도 아무기능 없는 void 타입을 써야함
	
	// main 메소드: 프로그램의 시작점 !
	public static void main(String[] args) {
		Ex01People ppl1 = new Ex01People();
		System.out.println(ppl1.name);
		System.out.println(ppl1.age);
		System.out.println(ppl1.getName());
		System.out.println(ppl1.getAge());
		// !!! print 함수 내부에서 또 다른 print 함수 호출 X 
//		System.out.println(ppl1.printInfo());
		ppl1.printInfo();

	}

}
