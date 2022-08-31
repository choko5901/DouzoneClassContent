package step04.abstractex;

public class NoteBook extends Computer{
	
	@Override
	public void display() {
		System.out.println("NoteBook 화면 구성");
	}
	
	@Override
	 void typing() {
		System.out.println("NoteBook 타이핑 가능");
	}

}
