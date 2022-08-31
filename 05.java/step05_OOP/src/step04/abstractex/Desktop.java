package step04.abstractex;

public  class Desktop extends Computer {

	@Override
	public void display() {
		System.out.println("Desktop 화면 구성");
	}
	
	@Override
	 void typing() {
		System.out.println("Desktop 타이핑 가능");
	}

	
}
