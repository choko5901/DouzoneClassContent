package test;

class Person2 {
	String name;
	int age;
	int weight;
	
	Person2() {}
	Person2( String name, int age, int weight ) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	void wash() { System.out.println( "wash" ); }
	void study() { System.out.println( "study" ); }
	void play() { System.out.println( "play" ); }
	
	public void in2( int price, String name ) { System.out.printf( "in2Person === %s 에게서 %d원 용돈을 받았습니다.%n", name, price ); }
}

interface Allowance {
	abstract void in( int price, String name );
	abstract void out( int price, String name );
	public void in2( int price, String name );
}

interface Train {
	abstract void payTuitionFee( int tuitionFee, String name );
}

class Student2 extends Person2 implements Allowance, Train {
	Student2() {}
	Student2( String name, int age, int weight ) {
		super( name, age, weight );
	}
	
	public void in( int price, String name ) { System.out.printf( "%s 에게서 %d원 용돈을 받았습니다.%n", name, price ); }
	public void out( int price, String name ) { System.out.printf( "%d원 금액을 지출했습니다. [지출용도 --> %s]%n", price, name ); }
	public void payTuitionFee( int tuitionFee, String name ) { System.out.printf( "[%s --> %d원 입금완료]%n", name, tuitionFee ); }
	
	public void in2( int price, String name ) { super.in2(price, name); }
}

public class Test5 {
	public static void main(String[] args) {
		
		// Test5 결과 출력하기 & extends와 implements중에서 우선적으로 적용되는 것은 무엇인지 확인해보기
		/* 
		 * wash
		 * study
		 * play
		 * 엄마 에게서 10000원 용돈을 받았습니다.
		 * 5000원 금액을 지출했습니다. [지출용도 --> 편의점]
		 * [훈련비 --> 50000원 입금완료]
		 */
//		Student2 st = new Student2();
//		st.in2(1000, "test");
		
		//정답 
		// extends 와 implements 중 class 로 상속된 extends가 우선적으로 적용된다
		
		Student2 st = new Student2();
		st.wash();
		st.study();
		st.play();
		st.in(10000, "엄마");
		st.out(5000, "편의점");
		st.payTuitionFee(50000, "훈련비");
		
		
		
	}
}
