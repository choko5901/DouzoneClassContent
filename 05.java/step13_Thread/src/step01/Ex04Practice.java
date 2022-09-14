package step01;
//투욱 주운돈 막쓰기

class ATM implements Runnable {
	
	private int deposit = 1000;
	
	@Override
	public synchronized void run() {
		for(int i = 0 ; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			withdraw(1000);
		}
		
		
	}
	// withdraw : 해당 금액을 출금 하고 잔액 변경 및 현재 잔액 출력
	public void withdraw(int money) {
		if(deposit > 0 ) {
			deposit -= money;
			System.out.println(Thread.currentThread().getName() + "님이 출근 했습니다.");
			System.out.println("잔액은" + deposit + "입니다." );
		}
	}
}

public class Ex04Practice {

	public static void main(String[] args) {

		ATM atm = new ATM();
		
		Thread mu = new Thread(atm, "민욱");
		Thread kw = new Thread(atm, "경욱");
		
		 mu.start();
		 kw.start();
		
	}

}
