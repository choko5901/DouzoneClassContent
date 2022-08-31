package step02.oop;

class Parent3 {
	String name;
	
	
	public String toString() {
		return name;
	}
}

public class Child3 extends Parent3 {
	String nickName;
	
	public String toString() {
		return name + " " + nickName;
	}
	
	public static void main(String[] args) {
		Child3 child = new Child3();
		child.name = "java";
		child.nickName = "oop";
		
		System.out.println(child.toString());
		// 주소값이 아니라 name, nickName 출력?
		// toString 오버라이딩
		
		Parent3 parent = new Parent3();
		System.out.println(parent.toString());
	}

}