/*��ü ��������
 * */





package step02;

public class Ex03Object {

	public static void main(String[] args) {
		/*
		 * �� ����� AAB �� ��� �ɱ�?
		 * ====> B ��ü ���� ���� ������ �Ǵ°� ???
		 * 	====> ��ü ������ ��ü�� �����ϰ� �ִ�
		 * 			��� ��� ����(�ʵ�)��  �޸𸮿� �����Ǿ�߸�  ��ü�� ������ �Ϸᰡ �ȴ� !!!!!
		 * 
		 * 
		 * */
		A a = new A();
		B b = new B();
//		C c = new C();
//���α׷� ������ main �ȿ��� �ڵ�鿡 ���� ���������� �ۿ��� ����������
		
		
	}

}


class A {
	A() {
		System.out.println("Class A");
	}
	
}
class B {
	A a = new A();
	B() {
		System.out.println("Class B");
	}
	
}
class C {
	C() {
		System.out.println("Class C");
	}
	
}
