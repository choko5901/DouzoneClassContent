package step01;



// 스레드 생성 - runnable 인터페이스 구현
public class Ex02Runnable implements Runnable{
	
	public void run() {
		for(int i =0; i < 10 ; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + (i+1) + "번 실행");
		}
	}
	
	public static void main(String[] args) {

		Runnable runThread1 = new Ex02Runnable();
		Runnable runThread2 = new Ex02Runnable();
		
		Thread thread1 = new Thread(runThread1);
		Thread thread2 = new Thread(runThread2);
		
		
		thread1.setName("스레드1");
		thread2.setName("스레드2");
		
//		thread1.start();
//		thread2.start();
		
		
		// 우선 순위  기본값은 : 5가 됨 ( 1 ~ 10 ) 까지 우선 순위가 있음
//		thread1.setPriority(10);
		thread1.setPriority(Thread.MAX_PRIORITY);
//		thread2.setPriority(1);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		
		thread1.start();
		thread2.start();
		
		
		
		
		
	}

}
