package step01;

class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업 내용 저장");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				break;
			}
			save();
		}
	}
}


// 스레드 그룹 관련 객체 

class StudyThread extends Thread {
	
	public StudyThread(ThreadGroup group, String name) {
		super(group,name);
	}
	
	
	
	@Override
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted");
				break;
			}
			
			
		}
		System.out.println(getName() + " 종료");
		
	}
}



public class Ex07DeamonGroup {
	public static void main(String[] args) {
		//데몬 스레드
		
//		AutoSaveThread autoSaveThread = new AutoSaveThread();
//		autoSaveThread.setName("AutoSave");
//		autoSaveThread.setDaemon(true);
//		autoSaveThread.start();
//		
//		try {
//			
//			System.out.println(Thread.currentThread().getName() );
//			Thread.sleep(3000);
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("메인 스레드 종료");
		
		
		// 스레드 그루프
		
		// 1) 그룹 생성
		// 2) 생성된 스레드를 그룹에 할당
		ThreadGroup it = new ThreadGroup("IT");
		
		StudyThread studyJava = new StudyThread(it, "java");
		StudyThread studySpring = new StudyThread(it, "spring");
		
		studyJava.start();
		studySpring.start();
		
//		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//		
//		mainGroup.list();
		// 메인이랑 it 스레드 그룹 두개가 있다는 것 을 알 수 있다
		
		// IT 그룹의 모든 스레드가 멈추도록 메소드 호출
		// 스레드를 안전하게 멈추고 싶으면 interrupt를 명시적으로 호출하고 그리고 스레드 그룹에 속한 스레드 한번에 정지하고  싶으면
		// 그룹으로 인터럽트 하면 손쉽다
		
		it.interrupt();
		
		// 만약 그룹으로 안묶어 놨으면 하나하나 정지 시켰어야 한다
		//studyJava.interrupt();
		//studySpring.interrupt();
		// 요로케
		
		
		
		
		
		
		
		
		
		
	}


}
