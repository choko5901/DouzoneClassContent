package step02;

class People {
	// 멤버 변수
	// 멤버 변수는 people 이라는 객체가 사용할 변수 명치과 형을 정해 놓고
	// 생성자 함수로 파라미터로 각각 정의 된 형태로 불러와 받아서(라인 21번째줄) People이 받아 쓴다 
//	String name = "java";
//	int age = 26;
	
	String name;
	int age;
	char test;
	
	//기본생성자 -> 사용자 정의 생성자가 있는 경우에는 반드시 개발자가 지정해줘야 에러가 안난다
	
	People() {} 
//	
	
	
	// 사용자 정의 생성자
	//이때 파라미터 값으로 형태를 정의하는건 일단 최후에 맴버함수에 맞게 받는 거고 그외에도 
	// 객체 생성시 파라미터의 형태를 정해주는 역할 2가지이다
	People(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	//메소드
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}

	void setAge(int age) {
		if (age > 0) {
		
		this.age = age;
		}else {
			System.out.println("지정한 나이로 업데이트 불가");
		}
					
}
}




public class Ex02People {
	
	

	public static void main(String[] args) {
		
		People ppl1 = new People();
		System.out.println(ppl1.name);
		System.out.println(ppl1.age);
		System.out.println(ppl1.test);
//		 기본 생성자 생략 되어있으면 자동으로 출력 됨
		
		// step01 : 초기값을 갖고 있는 상태의 객체 생성 -- 사용자 정의 생성자가 꼭 필수
		People ppl2 = new People("apple", 30);
		System.out.println(ppl2.getName());
		System.out.println(ppl2.getAge());
		
		// step02 객체의 데이터 보호 --> set 함수를 이용
		
		People ppl3 = new People("google", 20);
//		ppl3.age = -10 ;  본래 들어가서는 안되는 데이터 이므로 보호 필요
		
		// ? setAge 메소드 생성: 새로운 나이를 지정 , 단 음수는 지정 되지 않도록 !
		ppl3.setAge(40);
		
		System.out.println(ppl3.getAge());
		
		
		
		
		
		
	}

}
