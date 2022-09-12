package model.domain;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor // 기본생성자랑 같은 의미
@AllArgsConstructor // 사용자 생성자 같은 의미
@ToString
@Getter
@Setter

public class Student {
	private String name;
	private int no;
	private String grade;
	
	
	//기본 생성자 
//	public Student() {}
	
//	//사용자 생성자
//	public Student(String name, int no, String grade) {
//		super();
//		this.name = name;
//		this.no = no;
//		this.grade = grade;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getNo() {
//		return no;
//	}
//
//	public void setNo(int no) {
//		this.no = no;
//	}
//
//	public String getGrade() {
//		return grade;
//	}
//
//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
//
//	
//	//정보 출력 하기 위한 toSting
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", no=" + no + ", grade=" + grade + "]";
//	}
//	
//	// 위의 행위조차 간편하게 할 수 있게 롬복Lombok을 이용함
//	
 
	
	
	
	
	
}
