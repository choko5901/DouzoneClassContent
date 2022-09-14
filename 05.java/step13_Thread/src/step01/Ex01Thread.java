package step01;

// 스레드 생성 - 스레드 클래스 이용
public class Ex01Thread extends Thread{

	public static void main(String[] args) {
		Ex01Thread thread1 = new Ex01Thread();
		
		thread1.start();
		thread1.setName("스레드1");
		System.out.println(thread1.getName());
		
		Ex01Thread thread2 = new Ex01Thread();
		thread2.start();
		thread2.setName("스레드2");
		
		System.out.println(thread2.getName());
		
		System.out.println(Thread.currentThread().getName());
		
		
		
		
		
	}

}
