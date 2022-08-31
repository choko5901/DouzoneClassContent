package step02.oop;

class Parent2 extends Object{
	String name;
	int age;
	
	Parent2(){
		super();
	}
	
	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child2 extends Parent2{
	String wish;
	
	public Child2() {
		super();
	}
	
	// 메소드가 오버라이딩
	void printAll() {
		super.printAll();
		System.out.println(wish);
	}
	
	// 다형성 적용 메소드
	static Object toDo() {
		return "Study";
	}
	
	static Object toDo2() {
		return "Study,Exercise,Cleaning,Sleeping";
	}
	
	public static void main(String[] args) {
		// y만 출력하기 : toDo() 메소드 이용
		
//		System.out.println(toDo().charAt(4)); 에러 난다
		// 왜냐하면 toDo는 스트링으로 리턴하지만 toDo클래스 자체는 object 타입이기 떄문에
		// String 타입에서만 사용 할 수 있는 charAt toDo로 바로 사용 불가
		// 그래서 사용 하기 위해서 강제 타입변환을 하여 String으로 변경해 사용한다
		
		
		// Study 문자열을 char[] 배열로 저장하여 출력하기 개발
		/* 단계
		 * step1
		 * 	- toDo2() 반환값을 , 를 기준으로 String[] toDoLists 배열에 저장
		 * 	- 반환값 -> 변환(String) -> 배열로 변환
		 * 
		 * hint : charAt()/length()/split()
		 * 
		 * step2
		 * 	- toDoLists 첫번째 index에 저장된 Study이라는 문자열을 
		 * 	  새롭게 생성한 char[] cArray 배열에 저장 후 출력
		 */
		
		// step1
		/* step1의 결과값
		 *  
		 * Study
		   Exercise
		   Cleaning
		   Sleeping
		 * 
		 */
		System.out.println("=======step1 결과값=======");
		
		String str1 = (String)toDo2();

		String[] todoLists = str1.split(",");
		for(int i=0 ; i < todoLists.length; i++ )
		{
		System.out.println(todoLists[i]);
		};
		
		// step2
		/* step2의 결과값
		 * 
		 * S	
	     * t	
		 * u	
		 * d	
		 * y	
		 */
		System.out.println("=======step2 결과값=======");
//		char[] cArray = todoLists[0].toCharArray();
		char[] cArray  = new char[5];
		
		for(int i = 0; i < cArray.length; i++) {
			cArray[i] = todoLists[0].charAt(i);	
		}
		
		for(char character: cArray) {
			System.out.println(character);
		}
		
	
		
		System.out.println("===String[]의 첫번째 데이터 값으로 char[]에 저장하기===");

		
		System.out.println("===저장된 char[] 데이터값 출력해 보기===");
	
	}
}


