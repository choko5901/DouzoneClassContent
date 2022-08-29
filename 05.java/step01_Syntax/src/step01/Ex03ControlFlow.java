// condition
/* ���ǹ�(Condition) : �־��� ������ ���� ���, �־��� ��� ����
1. if��
	- ����
		if(���ǽ�) {
			���� �ڵ�;
			...
		}else if(���ǽ�){
			���� �ڵ�;
			...
		}else {
			���� �ڵ�;
		}
	
	- ����
		1. if : ������ �ϳ��� ���
		2. if -else : ������ �ϳ�, ������ ���� -> else ���� �ڵ尡 ����
		3. if -else if -else... : ������ ������
		
2. switch/case�� : ���� ���� ���� �����ڵ� ����
	- ����
		switch(������){
			case �Է°�1:
				���� �ڵ�;
			case �Է°�2:
				���� �ڵ�;
			
			...
		
			default:
				���� �ڵ�;
		}
 */

/*�ݺ���(Loop)
1. for�� : �ݺ� Ƚ���� ��Ȯ�� ��
	- ����
		for(���� ����� �ʱ�ȭ; ���ǽ�; ������){
			���� �ڵ�;
			...
		}
		
	- ����
		1. �⺻ for��
		2. for Each��
			for(Ÿ�� ���� : ������ ���尴ü){
				���� �ڵ�;
				...
			}
			
2. while�� : �ݺ� Ƚ���� �Ҹ�Ȯ �Ǵ� ����
	- ����
		�ʱ��;
		while(���ǽ�){
			���� �ڵ�;
			...
			������;
		}

3. do ~ while�� : �ݺ� ���� ������ �ѹ� ������, while��
	- ����
		�ʱ��;
		do{
			���� ����, ������;
		}while��(���ǽ�);

 */

package step01;

public class Ex03ControlFlow {

	public static void main(String[] args) {
		
		// ���ǹ�
		// id�� admin ��� , ���� ���� ���ڿ� ���
		String id = "admin";
		
		if(id.equals("admin")) {
			System.out.println("���� ����");
			
		}
		else {
			System.out.println("���� ����");
			
		}
		
		// �ݺ���
		// 1~10
		System.out.println("for��");

		for(int i = 0; i < 11; i++) {
			System.out.println(i);
		}
		
		// 10~1 ���� ���
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
		}
		
		
		// while 1~10
		System.out.println("while��");
		int i =1;
		while ( i <=10) {
			System.out.println(i);
			i ++;

		}

		// do while 1~10
		
		System.out.println("do while");
		
		int j = 1;
		do {
			System.out.println(j);
			j++;
		}
		while(j < 11);
		
	}

}
