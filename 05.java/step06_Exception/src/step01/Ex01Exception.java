package step01;
class A{}
class B extends A{}
class C extends A{}



public class Ex01Exception {

	public static void main(String[] args) {
		//NPE NullPointerExcetion
		
		String str1 = null ;
		
//		System.out.println(str1.length());

		// NumberFormatException
		String str2 = "three";
//		Integer.parseInt(str2);
		
		//ArrayIndexOutOfBoundsException
		int[] i1 = {1,2,3};
//		System.out.println(i1[3]);
		
		
		//ArithmeticException
//		System.out.println(10/0);
		
		A a = new B();
		
		// A 타입인 B객체는 생성 가능 할까? 가능하다 A 는 부모이고 B는 자식이기 때문에 부모타입의 자식 객체는 생성가능
		
		B b = new B();
		C c = (C) a;
		
		// C c = (C) a; 여기서 에러가난다 왜냐하면 a는 A타입인 B객체인데 결국 객체는 B이기때문에 B객체를 C타입으로 변경하는것은
		// B와 C는 부모가 같을 뿐이지 아무런 영향이 없다 그래서 에러가난다 ClassCastException
 
		
		
	}

}
