package model.domain;

public class Customer {
	
	private int customerId;
	private String customerName;
	protected String customerGrade;
	
	
	int bonusPoint;
	double bonusRatio;
	
	
	// step01
	
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	// step02
	
	public Customer(int customerID, String customerName) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
	}
	
	
	
	
	// 주석의 의미로 컴파일러에게 특별한 정보를 제공
	/* - 종류
	 * 	@Override : 재정의된 메서드
	 *  반환타입 메소드명 argument list는 100% 동일
	 *  @FunctionalInterface : 함수영 인터페이스
	 *  @Deprecated : 이후 버번에서 사용되지 않을 수 있는 변수, 메서드
	 *  @SuppressWarnings : 특정 경고 제외
	 * 
	 */
	
	// 고객이 물품 구매시 포인트를 적립하는 기능
	
	public int calPrice (int price) {
		//물품 구매시 보너스 비율 만큼 가격을 할인
		
		price -= (int)(price*bonusRatio);
		
		// 물품 구매시 가격 * 보너스 비율 = 보너스 포인트로 적립
		bonusPoint += (int)price * bonusPoint;
		
		return price ;
	}

	//get xx , setxx
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}

	
}
