package step01_enumex;

public class EnumTest {

	public static void main(String[] args) {
		
		// enum 타입의 데이터 1개 불러서 출력
//		System.out.println(Color.RED.getClass());
		
		//RED 가 들고 있는 숫자 NUM 1을 출력 하고싶다
		
		System.out.println(Color.RED.getNum());
		System.out.println(Color.RED.getColName());
		
		//3가지 전부 출력
		//2-1) 좀 많이 아쉬운 방법
		System.out.println(Color.RED.getColName());
		System.out.println(Color.BLUE.getColName());
		System.out.println(Color.GREEN.getColName());
		//2-2)
		
		System.out.println();
		for	(Color color : Color.values()) {
			System.out.println(color.getColName());
			
		}
		
		
		//values() 그냥 프린트하면 주소값이 나오는걸보니 [Lstep01_enumex.Color;@15db9742
		//values 배열 형태로 받아온다
		
		// enum 타입의 데이터를 모두 불러서 확인 할떈 for문으로 사용
//		System.out.println(Color.values());
//		for (Color color : Color.values() ) {
//			System.out.println(color);
//		}

		
		
		// Paytype 테스트
		System.out.println("Paytype 테스트 \n");
		System.out.println(PayType.CASH);
		
		if(PayType.CASH.getTypeCategory().equals("현금")) {
			for(String cashType :PayType.CASH.getTypeList()) {
				if(cashType.equals("계좌이체")) {
					System.out.println("계좌이체 로직 실행");
				}else if(cashType.equals("무통장입금")) {
					System.out.println("무통장입금 로직 실행");
				}
			}
				
		}
		
		
		
		
		
		
		
	}

}
