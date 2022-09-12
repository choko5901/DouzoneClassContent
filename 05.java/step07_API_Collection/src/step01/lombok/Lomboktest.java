package step01.lombok;

import model.domain.Student;

public class Lomboktest {

	public static void main(String[] args) {

		Student student = new Student("IT", 10001, "junior");
		
		System.out.println(student);
		
	}

}
