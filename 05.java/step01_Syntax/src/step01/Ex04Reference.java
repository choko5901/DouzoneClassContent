package step01;

public class Ex04Reference {

	public static void main(String[] args) {
		//���ڿ� String
		
		String str1 = "java";
		System.out.println(str1);
		// toString() :���� ��ü�� ������ �ִ� ���� ���
		System.out.println(str1.toString());

//		str1 = null;
//		System.out.println(str1);
//		System.out.println(str1.toString());
		// java.lang.NullPointerException -> NPE
		
		// �迭 Array : �����͸� �Ѱ��� ������ ����
		/* - ���� : Ÿ��: [] ������ = {};
		 * - Ư¡ : ���� (�迭 ��ü�� ���� �Ǿ��ִ� ������ ����)�� ���� <- �̰� �ٽ�
		 * - �ʱ�ȭ �ҋ�, ������ ����� �迭�� ���� -> new �����ڸ� �ݵ�� ���
		 * -����: 1����, ������ �迭
		 */
		
		int[] arr1= {1,2,3};
		
		String[] arr2 = {"1","2","3"};
		// �ڹٿ��� �迭�� ������ ����� ���ÿ� �Ҵ��� �̷������ ��(�ݵ�� �ʱ�ȭ �� �� ������Ѵ�)
	
		int[] arr3;
//		arr3 = {4,5,6} // �̷��� �����ٿ� �Ҵ��ϸ� �̰� ������ ����
		arr3 = new int[] {4,5,6};
		
//		int[] arr4 = new int[]; ����(�� �迭�� ���鶧) ��? �̰� �ʱ⿡ �迭�� ���̰� ������ ���� �ʱ� ������ ������ ��迭 ����� ��������
		int[] arr4 = new int[3]; //[����] ���� ��ŭ �迭 ���̸� ���� �� �迭 ���� �� �� �迭�� �ݵ��� ���̰� 3���� ������ 3���� ����
		
		// �迭�� ���� : index
		
//		System.out.println(arr1[2]);
//		System.out.println(arr1[3]); //����
		//java.lang.ArrayIndexOutOfBoundsException �� �� �� �ش��ϴ� �ε��� ��ȣ ���� ��¥���� ��� ��
		
		// �迭�� ���� : length
//		System.out.println(arr1.length);
		
		//�迭 ���
		// ���� ����� [1,2,3] => ���� ��°� 
		System.out.println("�߸��� ���");

		System.out.println(arr1);
		
		for(int i =0 ; i <arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
	//��� �� for������ ���
		
		for(int i : arr1) {
			
			System.out.println(i);
		}
		
		

		
		//����
		// ���� ����
		int[] arr5= {1,2,3};
		int[] arr5copy = arr5; // �ּҰ��� ���޵�
		arr5copy[0] =10 ;
		System.out.println("���� ����");

		System.out.println(arr5[0]); //1�� �ƴ϶� 10�� ��µǴ� ������ �ٲ�
		
		// ���� ����
		
		int[] arr6 = {1,2,3};
		int[] arr6Copy = new int[arr6.length];

		for(int i = 0; i < arr6Copy.length; i++) {
			
			
			arr6Copy[i] = arr6[i];
			
		}
		
		for(int i : arr6Copy) {
			System.out.println(i);
		}
		
		arr6Copy[0] = 10;
		System.out.println("��������");
		System.out.println(arr6Copy[0]);
		System.out.println(arr6[0]); // ���� �ȹٲ�� ���纻�� �ٲ�
		
		
		
		
		
		
	}

}
