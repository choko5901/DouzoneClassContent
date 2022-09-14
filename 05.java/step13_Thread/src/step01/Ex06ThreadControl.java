package step01;

class A extends Thread{
	private boolean flag  = true;
	private boolean stop  = false;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	@Override
	public void run() {
		while(!stop) {
//			System.out.println(Thread.currentThread().getState());
			if(flag) {
				System.out.println("A 는 작업중!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//이건 인터럽트 사용시 이미 멈춰져 있는데 멈추면 인터럽트익셉트 에러가 난다
					e.printStackTrace();
				}
			} else {
				Thread.yield();
			}
			
		}
		
	}
	
	
}

class B extends Thread{
	private boolean flag  = true;
	private boolean stop  = false;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	@Override
	public void run() {
		while(!stop) {
			if(flag) {
				System.out.println("B 는 작업중!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				Thread.yield();
			}
			
		}
		
	}
	
	
}

//join()

class SumThread extends Thread{
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	
	
	@Override
	public void run() {
		for(int i = 0; i <= 100; i++) {
			sum += i;
		}
	}
	
}



public class Ex06ThreadControl {

	public static void main(String[] args) {
		
		/*
		
		// sleep
		
		// yield()
		A threadA = new A();
		B threadB = new B();
		
		
		// A, B 시작
		
		threadA.start();
		threadB.start();
		
		// B만 실행 하도록 설정 (A 플래그로 종료)
		threadA.setFlag(false);
		// A의 상태는 RUNNALBLE
		
//		System.out.println(threadA.getState());
		
		
		// A,B모두를 종료
		
		threadA.setStop(true);
		threadB.setStop(true);
		
		threadA.interrupt();
		
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		
		*/
		
		
		// join() : 다른 스레드의 작업 종료 후에 실행 하도록 호출하는 메소드
		//			-> 특정 스레드의 결과 값을 활용하여 자신의 기능 수행
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		System.out.println("전체 총합은: " + sumThread.getSum() + " 입니다");
		
		// main 매소드도 하나의 스레드 이기 때문에 sum 스래드 랑 동시에 작업 하면 main 이 더 빨리 작업 되어 sum 이 완료되기전에 출력 되기때문에 0값이 나오는데
		// join 을 사용해서 sum 이 끝나는데로 main을 수행하게끔 하여 결과값을 제대로 출력 되게끔 하면 됨
		
		/*
		 * sumThread.start()가 실행되면 1부터 100까지 총합을 구하게 되는데
		 * 그 결과를 출력하기 위해 140 라인에서 getSum을 통해 결과 값을 반한 받았으나
		 * 출력 결과는 5050이 아닌 0이 출력 되었다.
		 * sumThread의 run()가 실행되는 동안 메인 스레드에서 총 합이 더해지기 전의
		 * sum 변수값을 참조 하였기 때문에 0이라는 결과를 가져 오게 된 것이다.
		 * 따라서 제대로 된 결과 값을 가져오기 위해서는 메인 스레드를 잠시 정지 시켰다가
		 * sumThread의 모든 결과가 끝나고 나서 해당 변수값을 참조하게 해야한다.
		 * 이떄, join() 활용하여 해결 할 수 있다.
		 * 
		 * */
		
	}

}
