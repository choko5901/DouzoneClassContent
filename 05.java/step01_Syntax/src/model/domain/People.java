/* 도메인 모델(Domain Model)
 * - 객체 지향 분석 설계 기반으로 구현하고자 하는 도메인(비즈니스 영역)의 모델을 생성하는 패턴
 * 공통적으로 사용하는 부분을 도메인으로 만들어 재사용하는 방식
 * - 도메인에서의 객체 판별, 목록 작성, 객체간의 관계
 * - 속성과 기능 분리
 * - 단순 : 테이블 하나 = 하나의 도메인 객체
 * - 재사용성, 유지보수 용이, 확장성
 * - 모델 구축의 어려움
 */


package model.domain;

public class People {
	// 멤버 변수 : 캡슐화(객체를 보호) --> setXXX
		public String name;
		private int age;
		
		// 기본생성자 : 사용자 정의 생성자가 있는 경우에는 반드시 개발자가 지정!!!
		public People() {}
		
		// 사용자 정의 생성자 : 객체 생성 시, 초기화
		public People(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		// 메소드
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			if (age > 0) {
				this.age = age;
			}else {
				System.out.println("지정한 나이로 update 할수 없음");
			}
		}
}
