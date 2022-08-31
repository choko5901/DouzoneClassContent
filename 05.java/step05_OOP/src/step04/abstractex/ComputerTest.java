package step04.abstractex;

public class ComputerTest {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook();
		noteBook.display();
		
		Computer computerNoteBook = new NoteBook();
		computerNoteBook.display();
		
		Desktop deskTop = new Desktop();
		deskTop.display();
		
//		Computer computer = new Computer(); // 생성 불가 : Computer 추상 클래스 이기 때문에 객체 생성 불가능
		// --> 생성 가능하게 끔 하려면 내부에 있는 추상 메소드가 완전히 정의가 되어야만 객체 생성이 가능함
		
		
		
	}

}
