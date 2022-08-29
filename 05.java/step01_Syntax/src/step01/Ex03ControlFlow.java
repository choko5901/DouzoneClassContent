// condition
/* 조건문(Condition) : 주어진 조건이 참일 경우, 주어진 기능 수행
1. if문
	- 문법
		if(조건식) {
			수행 코드;
			...
		}else if(조건식){
			수행 코드;
			...
		}else {
			수행 코드;
		}
	
	- 종류
		1. if : 조건이 하나인 경우
		2. if -else : 조건이 하나, 조건이 거짓 -> else 블럭의 코드가 실행
		3. if -else if -else... : 조건이 여러개
		
2. switch/case문 : 변수 값에 따라 수행코드 결정
	- 문법
		switch(변수값){
			case 입력값1:
				수행 코드;
			case 입력값2:
				수행 코드;
			
			...
		
			default:
				수행 코드;
		}
 */

/*반복문(Loop)
1. for문 : 반복 횟수가 정확할 때
	- 구조
		for(변수 선언과 초기화; 조건식; 증감식){
			수행 코드;
			...
		}
		
	- 종류
		1. 기본 for문
		2. for Each문
			for(타입 변수 : 데이터 저장객체){
				수행 코드;
				...
			}
			
2. while문 : 반복 횟수가 불명확 또는 무한
	- 구조
		초기식;
		while(조건식){
			수행 코드;
			...
			증감식;
		}

3. do ~ while문 : 반복 조건 검증전 한번 실행후, while문
	- 구조
		초기식;
		do{
			실행 로직, 증감식;
		}while문(조건식);

 */

package step01;

public class Ex03ControlFlow {

	public static void main(String[] args) {
		
		// 조건문
		// id가 admin 경우 , 접속 성공 문자열 출력
		String id = "admin";
		
		if(id.equals("admin")) {
			System.out.println("접속 성공");
			
		}
		else {
			System.out.println("접속 실패");
			
		}
		
		// 반복문
		// 1~10
		System.out.println("for문");

		for(int i = 0; i < 11; i++) {
			System.out.println(i);
		}
		
		// 10~1 까지 출력
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		
		
		// while 1~10
		System.out.println("while문");
		int i =1;
		while ( i <=10) {
			System.out.println(i);
			i ++;

		}

		// do while 1~10
		
		System.out.println("do while");
		
		int j = 1;
		do {
			System.out.println(j);
			j++;
		}
		while(j < 11);
		
	}

}
