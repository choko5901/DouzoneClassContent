package step02;

class People {
	// ��� ����
	// ��� ������ people �̶�� ��ü�� ����� ���� ��ġ�� ���� ���� ����
	// ������ �Լ��� �Ķ���ͷ� ���� ���� �� ���·� �ҷ��� �޾Ƽ�(���� 21��°��) People�� �޾� ���� 
//	String name = "java";
//	int age = 26;
	
	String name;
	int age;
	char test;
	
	//�⺻������ -> ����� ���� �����ڰ� �ִ� ��쿡�� �ݵ�� �����ڰ� ��������� ������ �ȳ���
	
	People() {} 
//	
	
	
	// ����� ���� ������
	//�̶� �Ķ���� ������ ���¸� �����ϴ°� �ϴ� ���Ŀ� �ɹ��Լ��� �°� �޴� �Ű� �׿ܿ��� 
	// ��ü ������ �Ķ������ ���¸� �����ִ� ���� 2�����̴�
	People(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	//�޼ҵ�
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
			System.out.println("������ ���̷� ������Ʈ �Ұ�");
		}
					
}
}




public class Ex02People {
	
	

	public static void main(String[] args) {
		
		People ppl1 = new People();
		System.out.println(ppl1.name);
		System.out.println(ppl1.age);
		System.out.println(ppl1.test);
//		 �⺻ ������ ���� �Ǿ������� �ڵ����� ��� ��
		
		// step01 : �ʱⰪ�� ���� �ִ� ������ ��ü ���� -- ����� ���� �����ڰ� �� �ʼ�
		People ppl2 = new People("apple", 30);
		System.out.println(ppl2.getName());
		System.out.println(ppl2.getAge());
		
		// step02 ��ü�� ������ ��ȣ --> set �Լ��� �̿�
		
		People ppl3 = new People("google", 20);
//		ppl3.age = -10 ;  ���� ������ �ȵǴ� ������ �̹Ƿ� ��ȣ �ʿ�
		
		// ? setAge �޼ҵ� ����: ���ο� ���̸� ���� , �� ������ ���� ���� �ʵ��� !
		ppl3.setAge(40);
		
		System.out.println(ppl3.getAge());
		
		
		
		
		
		
	}

}
