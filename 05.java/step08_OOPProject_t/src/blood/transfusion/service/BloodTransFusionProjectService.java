package blood.transfusion.service;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.People;
import blood.transfusion.dto.Recipient;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BloodTransfusionVirtualDB;

public class BloodTransFusionProjectService {
	private static BloodTransFusionProjectService instance = new BloodTransFusionProjectService();
	private BloodTransfusionVirtualDB projectVirtualData = BloodTransfusionVirtualDB.getInstance();

	private BloodTransFusionProjectService(){}
	public static BloodTransFusionProjectService getInstance(){
		return instance;
	}
	
	// 모든 프로젝트 반환
	public ArrayList<BloodTransfusionProject> getAllProjects(){
		return projectVirtualData.getProjectList();
	}
	
	// 프로젝트 검색_
	// 1.모든 프로젝트를 들고와야하고
	// 2.검색하고자 입력한 projectname == 해당 이름을 갖고 있는 프로젝트
	// 3. return
	public BloodTransfusionProject getProject(String projectName) throws NotExistException {
		BloodTransfusionProject project = null;
		ArrayList<BloodTransfusionProject> projectList = projectVirtualData.getProjectList();
		
		//for문은 해당 조건의 프로젝트 리턴
		for(int i = 0; i < projectList.size(); i++) {
			if(projectList.get(i).getBtProjectName().equals(projectName)) {
				project = projectList.get(i);
			}
		}
		// 그런데 ! 만약 for 조건에 맞지 않는다면 해당 객체는 null이 넘겨져 올 것이다 !
		if(project == null) {
			// 예외를 발생 시킬 것이다
			throw new NotExistException("검색 요청하신 프로젝트는 존재하지 않습니다.");
			
		}
		return project;
	}

	// 새로운 프로젝트 추가
	public void projectInsert(BloodTransfusionProject newProject) {
		projectVirtualData.insertProject(newProject);
	}
	
	// 프로젝트 수정 - 프로젝트 명으로 현혈자 혹은 수혈자 수정_
	public void projectUpdate(String projectName, People people) throws NotExistException{
		BloodTransfusionProject project= getProject(projectName);
		
		//첫번쨰  먼저 프로젝트 객체가 있는지 부터 확인! -> 프로젝트가 있을때에만 정보가 수정 되어야 하기 때문에
		// 근데 이미 getproject 메소드 내부에서 이미 존재 여부를 검증하고 있어서
		// 첫번재 과정이 필요없는게 맞는데 그럼 확장성을 위해서 기능을 따로 메소드 생성 후 
		// 호출하는 형태로 변경가능한지 추후에 고민 해봐라
		
	
		//두번쨰 여기서 우리는 파라미터로 넘겨져 오는 people 객체 타입이 헌혈자 인지 수혜자인지 구분해줘야하고
		// 구분한 그 타입에 대한 내용을 변경 해야한다.
		// 타입을 헌혈자 수혈자 타입 두개를 각각받으면 비효율적이니 people타입으로 한번에 받아서
		// 다형성으로 비교해 밑에 와  같은 로직을 세워 처리한다.
		
		if(project == null) {
			throw new NotExistException("수정하고자 하는 프로젝트가 존재하지 않습니다.");
		}else if(people instanceof Donor){
			// 파라미터로 넘겨져온 people이란 객체가 Donor객체로 변경이 가능하다면 임마는 Donor에대한 정보임
			// 그럼 setDonor매소드는 Donor타입만 사용이 가능하니 people타입의 people객체를 
			// Donor 타입으로 강제 형변환하여 사용 하면 된다.
			project.setDonor((Donor)people);
		}else if(people instanceof Recipient){
			// 파라미터로 넘겨져온 people이란 객체가 Recipient객체로 변경이 가능하다면 임마는 Recipient에대한 정보임
			project.setRecipient((Recipient)people);
		}else {
			
		}
		
		
	}
	
	// 프로젝트 삭제_
	// 어떤 프로젝트를 삭제할 것인지 선택하기 위해 프로젝트를 들고와야 하니 getproject로 들고온다
	public void projectDelete(String projectName) throws NotExistException{
		BloodTransfusionProject project= getProject(projectName);
		//getAllProjects()가 ArrayList 타입이기 떄문에 제거시 내부의 remove 메소드 사용하면됨
		
		if(project == null) {
			throw new NotExistException("삭제하고자 하는 프로젝트가 존재하지 않습니다.");
		}
		
		getAllProjects().remove(project);
	}	
}
