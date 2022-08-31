package model.domain;
/*
 * 할인 가격은 제품 가격의 10%
 * 보너스 포인트 적립은  제품 가격의 5%
 * 개별 상담원 배정
 * 
 * */

public class GoldCustomer extends Customer {

	String counsellerId;
	
	//step01
	public GoldCustomer() {
		customerGrade = "GOLD";
		bonusRatio = 0.05;
	}
	
	
	//생성자 오버로딩
	
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "GOLD";
		bonusRatio = 0.05;
		
	}
	
}
