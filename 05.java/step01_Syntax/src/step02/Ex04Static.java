// Ex04Static.java
/* ����(Static)
 * - '����'�̶�� �ǹ̸� ������ ��ü �Ҽ��� �ƴ� Ŭ���� �Ҽ�
 * - ��ü ���� ���̵� ��� ����
 * - ���� �� ����
 * 		- static Ÿ�� ����
 * 		- static ����Ÿ�� �޼ҵ�
 * - ��� : ���� ������ �� ����
 */



package step02;

class Student {
	String name;
	int age;
	static String schoolName;
	
	// static Ÿ���� Ŭ���� �Ҽ��̰�
	// ������ ���´� ��ü �Ҽ��̶�
	// Ŭ���� ������ �޷ι� �����ɶ� static�� �����ǰ�
	// ��ü�� �����ǰ� �޸𸮿� �ö󰡾� ������ Ÿ�Ե��� ������ �Ȱ��̴�.
	
	// static �ʱ�ȭ ��
	
	static {
		schoolName="IT";
	}
	
	
	// static final ��� : ����� �빮�ڷ� �׻�_�� ǥ�� , 
	static final double PI_VALUE = 3.14;
	
	Student() {}
	
	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}else {
			System.out.println("������ ���̷� update �Ҽ� ����");
		}
	}
}



public class Ex04Static {

	public static void main(String[] args) {
		Student stu1 = new Student("friday", 32);
		
		System.out.println(stu1.age);
		System.out.println(stu1.schoolName);
		
		System.out.println(Student.schoolName);
		System.out.println(Student.PI_VALUE);
		
//		Student.PI_VALUE = 3.15462;
	}

}
