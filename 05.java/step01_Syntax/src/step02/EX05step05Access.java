
/* 접근 제한자(Access modifier)
 * modifier[제어자]
1. access modifier
	- 적용되는 위치
		1. 클래스 선언구 : public, default // 클래스에서만 2가지 나머지는 다 사용가능
		2. 변수 선언구 : public, protected, default, private
		3. 생성자 선언구 : public, protected, default, private
		4. 메소드 선언구 : public, protected, default, private
		
	- 호출가능한 범위  제한
	1. public : 동일한 클래스, 동일한 package, 외부 package에서 호출 가능
	2. protected : 동일한 클래스, 동일한 package, 
					단, 상속관계의 외부 package의 클래스에선 호출 가능
	3. default[friendly]
				- 동일한 package에서만 access 가능
	4. private : 동일한 class 내에서만 access 가능 
	
	
2. 기타 modifier
	- 옵션
	1. static
		1. 변수 - 공유자원
		2. 메소드 - 객체 생성없이 메소드 호출 가능 기능만 제공
		3. static{} - 공유자원 단 1번 실행, byte code가 로딩시 단 한번 실행 
		
	2. abstract
		- 추상
	3. final
	4. synchronized
 */


// 클래스 및 메소드 앞에 아무것도 없으면 기본값이 default 이때는 위와 같이 
// 동일한 클래스 , 패키지 안에서 만 사용가능
// 다른 패키지에서 사용하기 위해  public 을 붙여 다르 패키지에 있는
// 클래스를 사용한다.


package step02;

import model.domain.People;

public class EX05step05Access {

	public static void main(String[] args) {
		
		People ppl1 = new People("java", 26);
		System.out.println(ppl1.name);
		System.out.println(ppl1.getAge());
		
//		ppl1.age = 100;
//		ppl1.setAge(-100);

		ppl1.setAge(100);
		
		
		People ppl2 = new People("java", 26);
		
		System.out.println(ppl1.hashCode());
		System.out.println(ppl2.hashCode());
		
		System.out.println(ppl1 == ppl2); // false
		//ppl1 과 ppl2 는 메모리 주소가 달라 다른 객체로 인식
		
	}

}
