// Ex04Static.java
/* 정적(Static)
 * - '고정'이라는 의미를 가지며 객체 소속이 아닌 클래스 소속
 * - 객체 생성 없이도 사용 가능
 * - 구조 및 종류
 * 		- static 타입 변수
 * 		- static 리턴타입 메소드
 * - 사용 : 공용 데이터 값 지정
 */



package step02;

class Student {
	String name;
	int age;
	static String schoolName;
	
	// static 타입은 클래스 소속이고
	// 나머지 형태는 객체 소속이라
	// 클래스 데이터 메로미 생성될때 static이 생성되고
	// 객체가 생성되고 메모리에 올라가야 나머지 타입들이 생성이 된것이다.
	
	// static 초기화 블럭
	
	static {
		schoolName="IT";
	}
	
	
	// static final 상수 : 상수는 대문자로 항상_로 표시 , 
	static final double PI_VALUE = 3.14;
	
	Student() {}
	
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
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
			System.out.println("지정한 나이로 update 할수 없음");
		}
	}
}



public class Ex04Static {

	public static void main(String[] args) {
		Student stu1 = new Student("friday", 32);
		
		System.out.println(stu1.age);
		System.out.println(stu1.schoolName);
		
		System.out.println(Student.schoolName);
		System.out.println(Student.PI_VALUE);
		
//		Student.PI_VALUE = 3.15462;
	}

}
