package model.domain;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6999244172818817102L;
	private String name;
	private int age;
	private int phoneNumber;
	private transient int personalNumber;
	private int count;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(int personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", personalNumber="
				+ personalNumber + "]";
	}
	
	
	
}
