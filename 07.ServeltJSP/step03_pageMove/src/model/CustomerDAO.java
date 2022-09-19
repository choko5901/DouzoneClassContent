package model;

import java.util.ArrayList;

import model.domain.Customer;

public class CustomerDAO {
	
	
	
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<Customer> userData = new ArrayList<Customer>();
	
	static {
		userData.add(new Customer("it1", "it1", "S"));
		userData.add(new Customer("it2", "it2", "A"));
		userData.add(new Customer("it3", "it3", "B"));
		userData.add(new Customer("it4", "it4", "C"));
		userData.add(new Customer("it5", "it5", "D"));
	}

	public static ArrayList<Customer> getUserData() {
		return userData;
	}

	public static void setUserData(ArrayList<Customer> userData) {
		CustomerDAO.userData = userData;
	}
	
	
	
}
