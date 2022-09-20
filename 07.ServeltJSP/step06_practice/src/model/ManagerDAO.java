package model;

import java.util.ArrayList;

import model.domain.Manager;


public class ManagerDAO {
	
	// 이렇게 프라이빗으로 생성자를 설정 했놓고  이것을 사용하는 서블릿(클래스)에서 싱글톤 패턴으로 한번 생성 후 계속 사용할 예정이다
	private static ManagerDAO instance = new ManagerDAO();
	
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<Manager> userData = new ArrayList<Manager>();
	
	static {
		userData.add(new Manager("DH", "DH1324", "IT"));
		userData.add(new Manager("JH", "JH1234", "DEV"));
		userData.add(new Manager("MH", "MH1234", "REACT"));
		userData.add(new Manager("JK", "JK1234", "JAVA"));
		userData.add(new Manager("GM", "GM1234", "JS"));
	}

	public static ArrayList<Manager> getUserData() {
		return userData;
	}

	public static void setUserData(ArrayList<Manager> userData) {
		ManagerDAO.userData = userData;
	}
	
	
	
	
}
