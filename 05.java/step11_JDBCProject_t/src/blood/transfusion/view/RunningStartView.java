package blood.transfusion.view;

import blood.transfusion.contoller.BTController;
import blood.transfusion.dto.BTProjectDTO;

public class RunningStartView {

	public static void main(String[] args) {
		BTController controller = BTController.getInstance();
		
		System.out.println("=====모든 프로젝트 검색=====");
		controller.allBTProjects();
		
		// 특정 프로젝트 검색 (무엇으로 검색할지)
		System.out.println("=====특정 프로젝트 검색=====");
		controller.SearchBTprojects("");
		
		
		// 프로젝트 입력(필수적으로 들어가야 하는 데이터는 무엇인지? -NOT NULL / Default....)									.
		
		
		// 외래키 참조된 데이터를 추가시에는 참조 테이블에 존재하는 키값을 사용해야한다.
		
		controller.newBTprojects(new BTProjectDTO("AB-","bt6","donor3","recipient3", "AB-형간의 수혈"));
		System.out.println();
		controller.allBTProjects();
		
//		
		
		// 프로젝트 수정(어떤 프로젝트(검색)의 무슨 내용(데이터의 형태)을 변경 시킬 것인지)
		
		// 프로젝트 삭제 (어떤 프로젝트를 삭제할 것인지)
		
		// 사람관련 로직 - emp 
		
		
		
	}
}
