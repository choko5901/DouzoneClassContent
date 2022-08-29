package step01;

public class EX02Operation {

	public static void main(String[] args) {
		// Ex03Operation.java
//		 ���� ����
//		 �⺻ ���� : +, -, *, /, %
		System.out.println("===�⺻����===");
		int v1 = 10;
		int v2 = 3;
		
//		System.out.println(v1 + v2);
//		System.out.println(v1 - v2);
//		System.out.println(v1 * v2);
//		System.out.println(v1 / v2);
//		System.out.println(v1 % v2);
		
		// ���� ���� : ++, --
		System.out.println("===��������===");
//		System.out.println(v1);
//		System.out.println(v1++);
//		System.out.println(v1);
//		System.out.println(++v1);
//		System.out.println(v1);
		
		// 3.33.... ���� ���?
		// Ÿ�Ժ�ȯ�� �ʿ��ϴ� --> Wrapper Class
		
//		System.out.println(v1/(float)v2);

		// Infinity, NAN
//		System.out.println(v1 % 0.0);
		// 0 : java.lang.ArithmeticException
		// 0.0: Infinity
		// % 0.0 : NaN
		
		
//		// �� ���� : &&, ||, ^, !
		System.out.println("===������===");
		boolean t = true;
		boolean f = false;
		
		// && : ��� �����ڰ� true��� ����� true
//		System.out.println(t & t);
//		System.out.println(f & f);
//		System.out.println(t & f);
//		System.out.println(f && t);
		
		// || : �������� �ϳ��� true�� ����� true
//		System.out.println(t || t);
//		System.out.println(f || f);
//		System.out.println(t || f);
//		System.out.println(f || t);
		
		// ^ : ������ �ϳ��� true, �ٸ� �ϳ��� false�϶� ����� true
		System.out.println(t ^ t);
		System.out.println(f ^ f);
		System.out.println(t ^ f);
		System.out.println(f ^ t);
		
		// ! : ������ ���� (t -> f, f -> t)
//		System.out.println(f);
//		System.out.println(!f);
		
		// �񱳿��� : <, >, <=, >=, ==, !=
		System.out.println("===�񱳿���===");
		int num1 = 1;
		int num2 = 10;
//		System.out.println(num1 == num2);
//		System.out.println(num1 != num2);
//		
//		double num3 = 1.0;
//		System.out.println(num1 == num3);
		
		// ���Կ��� : =, +=, -=, ...
		System.out.println("===���Կ���===");
//		int assign = 0;
//		System.out.println(assign);
//		assign += 10;
//		System.out.println(assign);
//		assign -= 5;
//		System.out.println(assign);
//		assign *= 5;
//		System.out.println(assign);
		
		
		
		// ���� !== ���ڿ� ��
		// ���ڴ� '' �� �ϳ��� ���ڸ� ��� ���ڿ��� "" �� ���� ���� ���
		// ���ڿ�(String) ����
		
		
		String str1 = "���ڿ� ����1";
		String str2 = "���ڿ� ����1";
		String str3 = new String("���ڿ� ����1");
		// �ڹٿ����� ���ڿ� ������ ���� ����� �ȵȴ�
		System.out.println(str1 +" "+ str2 + " " + str3);

		
		// ���ڿ� �� ������
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		// �� 2������ false �ϱ� == �� ��ü �������� (��ü �ּ� ) �� �ϱ� �����̴� 
		
		// equals : ��ü �����Ͱ��� ��
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		
		// ���� ����
		
		
		// ��Ʈ����
		// <<, >> , >>>
		// a << b : ����  a��  b ��Ʈ �� ��ŭ �ڸ� �̵� ��  �� ���� 0 ä���� ���� ����
		// �̹��� ����
		//16
//		System.out.println(2 << 3);
		// 0
//		System.out.println(2 >> 3);
		
		// |, &, ^, ~
		// 00000010 //00010010

		// & ���� ��ġ�� ��Ʈ���� 1�϶��� 1�� ���
		System.out.println(2 & 18);
		
		// | �� ��Ʈ�ڸ� �� �ϳ��� 1�̸� 1�� ���
		System.out.println(2 | 18);
		// ^ �� ��Ʈ �ڸ��� 0,0 �̳� 1,1�� �ƴҶ��� 1�� ���
		System.out.println(2 ^ 18);
		
		// ~
		System.out.println(~25);
		
		// 00011001
		// ������ �� ���� �غ��ôٿ�
		// 11100110 
		
		
		
		
		
	}

}
