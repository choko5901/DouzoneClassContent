package step00;

import model.domain.Student;

public class LombokTest {

	public static void main(String[] args) {
		Student student1 = new Student(1, "IT", 36);
		
		System.out.println(student1.getAge());
	}

}
