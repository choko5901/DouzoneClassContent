package step01;



//synchronized  
//num이 7이 아닐때에 setNum 동작하도록 지정
class NumberChange {
	int num;
	
	public synchronized void setNum(int num) {
		if(this.num != 7) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.num = num;
			System.out.println(num);
		}else {
			System.out.println("num 값을 변경할 수 없습니다.");
		}
	}
}



public class Ex04Synchronized {
	public static void main(String[] args) {
		NumberChange nc = new NumberChange();
		
		// 스레드 1 
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				nc.setNum(7);
			}
		});

		// 스레드 2 
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				nc.setNum(10);
			}
		});
		
		
		thread2.setPriority(10);
		
		thread1.start();
		thread2.start();
		
		// 예상 결과 
		// thread1이 먼저 수행되었다고 가정 -> thread2는 수행 될 수 있는가? 불가능 
		// 7 -> num 값을 변경할 수 없습니다
		
		// thread2이 먼저 수행되었다고 가정 -> thread1는 수행 될 수 있는가? 가능
		// 10 -> 7

	}
}
