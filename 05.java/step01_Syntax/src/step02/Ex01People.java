/* ���� Ÿ��
 *  - �⺻ Ÿ��ó�� ���� ������ ���� �ƴ� ��ü�� �ּҸ� �����ϴ� Ÿ��
 *  - ���� ����(stack), ��ü ��(heap) �������� ����
 *  - �⺻ �� : null
 *  	- ������ ��ü�� ���� ���, NullPointerException �߻�
 */
/* Ŭ������ ��ü
 *  - ������ ���� ���� �� ����
 *  
 *  - ����
 *   1. ������ : name, age
 *   2. ��� : name, age ��ȯ / �ܼ� ���
 * 
 *  - ����
 *   1. ������ ���忡 �ʿ��� �޸�
 *   2. ��� ����, ������ ���� �ڵ� �ۼ�
 *   	* ��ü ����
 *   
 *  - Ŭ������ �����ϴ� ���� ��ü�� ����� ���� �ƴϴ�
 */


package step02;

public class Ex01People {
	// ��� ����(�ʵ�)�� ��� class �ؿ� ��� �Ǵ� ��
	
	String name = "java";
	int age = 26;
	
	// �⺻������
	// - Ŭ������ �����ϴ� �޼ҵ��� �� ����
	// - ��ü ������ �ڵ����� ȣ��
	// - Ŭ������ �̸��� ����, Ÿ�� x , ��ȯ�� x
	// - ��ü ���� �� �ʱ�ȭ�� ����
	
	
	Ex01People() {};
	
	// �޼ҵ�
	// �̸� ��ȯ �޼ҵ�
	// - ��� : �̸� ��ȯ(return)
	// - �޼ҵ��: getName
	
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	
	//return ���ٸ� ??
	
	void printInfo() {
		System.out.println("�ƹ����� ���ٸ�");
		System.out.println(age + " " + name);
	}
	// ������ �ڹٴ� ������ Ÿ���� ����Ѵ� �ƹ��� �ƹ� ����� ������ �ƹ���� ���� void Ÿ���� �����
	
	// main �޼ҵ�: ���α׷��� ������ !
	public static void main(String[] args) {
		Ex01People ppl1 = new Ex01People();
		System.out.println(ppl1.name);
		System.out.println(ppl1.age);
		System.out.println(ppl1.getName());
		System.out.println(ppl1.getAge());
		// !!! print �Լ� ���ο��� �� �ٸ� print �Լ� ȣ�� X 
//		System.out.println(ppl1.printInfo());
		ppl1.printInfo();

	}

}
