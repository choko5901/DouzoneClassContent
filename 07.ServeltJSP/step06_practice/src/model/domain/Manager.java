package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//롬복
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manager {
	//멤버 변수
	private String id;
	private String pw;
	private String dept;
	
	

}
