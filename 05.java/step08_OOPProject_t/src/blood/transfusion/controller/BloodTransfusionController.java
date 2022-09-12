package blood.transfusion.controller;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.People;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.service.BloodTransFusionProjectService;
import blood.transfusion.view.EndView;
import blood.transfusion.view.FailView;

public class BloodTransfusionController {
	private static BloodTransfusionController instance = new BloodTransfusionController();
	private BloodTransFusionProjectService service = BloodTransFusionProjectService.getInstance();

	private BloodTransfusionController() {}

	public static BloodTransfusionController getInstance() {
		return instance;
	}

	// 모든 프로젝트 검색
	public void projectListView() {
		
		ArrayList<BloodTransfusionProject> projectList = service.getAllProjects();
		EndView.projectListView(projectList);
	}
	
	// 특정 프로젝트 검색_
	public void projectView(String projectName) {
		try {
			EndView.projectView( service.getProject(projectName));
		} catch (NotExistException e) {
//			e.printStackTrace();
			EndView.messageView(e.getMessage());
		}
	}

	// 새로운 프로젝트 저장
	public void insertProject(BloodTransfusionProject newProject) {
		service.projectInsert(newProject);
	}
	
	// 존재하는 프로젝트 수정_
	// 1. 수정 프로젝트를 어떻게 찾을 건인가? -> 이름으로 해당 프로젝트 검색
	// 2. 해당 프로젝트의 어떤 정보를 수정할 것인가 ? -> people 과 관련된 정보가 수정 되겠구나
	public void updateProject(String projectName, People people) {
		try {
			service.projectUpdate(projectName, people);
		} catch (NotExistException e) {
//			e.printStackTrace();
			FailView.failMessageView(e.getMessage());
		}
	}

	// 이름으로 검색한 프로젝트 삭제_
	public void deleteProject(String projectName) {
		try {
			service.projectDelete(projectName);
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
}




























