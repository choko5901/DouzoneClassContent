package step01_enumex;
// enum은 상수라 대문자로 사용된다.

public enum Color {
	RED(1, "red"),
	BLUE(2, "blue"),
	GREEN(3, "green");
	
	/*
	 * 마치 이 enum타입의 상수 는 원래 풀어서 말하자면 다음과 같음
	 * class Color {
	 * 	public static final RED = new RED();
	 * }
	 * 
	 * static fainal 이라는 상수 를 단순히 값을 넣은게 아니고
	 * 객체러 저장 하는 형태를 축약한게 enum 이라 생각하면된다.
	 * 
	 * */
	
	
	// 일단 컬러 자체가 객체이기떄문에 각 요소에 숫자를 포함하끔 설정해주려면
	// 사용자 생성 객체로 숫자를 가지도록 설정 해줘야한다.
	
	
	// 파라미터 값으로 받을 숫자를 저장할 맴버 변수 하나 생성 후
//	private int num ;
//	
//	Color() {}
//	Color(int num) {
//		 // this i는 맴버 변수 왼쪽 i는 파라미터 값 i
//		this.num = num;
//	}
//	
	//내가 객체의 private로 묶긴 정보를 Enum test에서 출력하고 싶으면
	// 따로 호출하는 메소드를 만들어 그 메소도를  Enumtest든 다른 곳에서 사용 하게끔 만든다
	public int getNum() {
		return this.num;
	}
	public String getColName()  {
		return this.colName;
	}
	
	// 1) 소문자 문자열을 정보를 포함시키려하니 4~6 에러 떠있는데 어케하면 해결될까
	// 2) 해결 후 Enum test에서 출력 시켜봐라
	
	private int num ;
	private String colName;
	
	Color() {}
	Color(int num , String colName) {
		// this i는 맴버 변수 왼쪽 i는 파라미터 값 i
		this.num = num;
		this.colName = colName;
	}
	

}
