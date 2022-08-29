package step01;

public class Ex04Reference {

	public static void main(String[] args) {
		//문자열 String
		
		String str1 = "java";
		System.out.println(str1);
		// toString() :현재 객체가 가지고 있는 정보 출력
		System.out.println(str1.toString());

//		str1 = null;
//		System.out.println(str1);
//		System.out.println(str1.toString());
		// java.lang.NullPointerException -> NPE
		
		// 배열 Array : 데이터를 한개의 변수로 관리
		/* - 구조 : 타입: [] 변수명 = {};
		 * - 특징 : 길이 (배열 객체에 저장 되어있는 데이터 개수)가 고정 <- 이게 핵심
		 * - 초기화 할떄, 주의점 선언된 배열의 변수 -> new 연산자를 반드시 사용
		 * -종류: 1차원, 다차원 배열
		 */
		
		int[] arr1= {1,2,3};
		
		String[] arr2 = {"1","2","3"};
		// 자바에서 배열은 무조건 선언과 동시에 할당이 이루어져야 함(반드시 초기화 를 꼭 해줘야한다)
	
		int[] arr3;
//		arr3 = {4,5,6} // 이렇게 다음줄에 할당하면 이건 에러가 난다
		arr3 = new int[] {4,5,6};
		
//		int[] arr4 = new int[]; 에러(빈 배열을 만들때) 왜? 이건 초기에 배열의 길이가 정해져 있지 않기 때문에 저렇게 빈배열 만들면 에러난다
		int[] arr4 = new int[3]; //[숫자] 숫자 만큼 배열 길이를 가진 빈 배열 만듬 단 이 배열은 반듯이 길이가 3개니 정보도 3개만 들어간다
		
		// 배열의 접근 : index
		
//		System.out.println(arr1[2]);
//		System.out.println(arr1[3]); //에러
		//java.lang.ArrayIndexOutOfBoundsException 마 니 그 해당하는 인덱스 번호 없다 이짜슥아 라고 뜸
		
		// 배열의 길이 : length
//		System.out.println(arr1.length);
		
		//배열 출력
		// 예상 결과값 [1,2,3] => 실제 출력값 
		System.out.println("잘못된 출력");

		System.out.println(arr1);
		
		for(int i =0 ; i <arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
	//향상 된 for문으로 출력
		
		for(int i : arr1) {
			
			System.out.println(i);
		}
		
		

		
		//복사
		// 얕은 복사
		int[] arr5= {1,2,3};
		int[] arr5copy = arr5; // 주소값이 전달됨
		arr5copy[0] =10 ;
		System.out.println("얕은 복사");

		System.out.println(arr5[0]); //1이 아니라 10이 출력되는 원본이 바뀜
		
		// 깊은 복사
		
		int[] arr6 = {1,2,3};
		int[] arr6Copy = new int[arr6.length];

		for(int i = 0; i < arr6Copy.length; i++) {
			
			
			arr6Copy[i] = arr6[i];
			
		}
		
		for(int i : arr6Copy) {
			System.out.println(i);
		}
		
		arr6Copy[0] = 10;
		System.out.println("깊은복사");
		System.out.println(arr6Copy[0]);
		System.out.println(arr6[0]); // 원본 안바뀐다 복사본만 바뀜
		
		
		
		
		
		
	}

}
