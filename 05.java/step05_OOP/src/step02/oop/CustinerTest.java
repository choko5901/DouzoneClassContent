package step02.oop;


import model.domain.Customer;
import model.domain.GoldCustomer;


public class CustinerTest {

	public static void main(String[] args) {
		Customer customerIT = new Customer(10001, "IT"); 
//		Customer customerIT = new Customer(10002, "DEV", "GOLD"); 
		
		System.out.println(customerIT.calPrice(1000));
		
		
		GoldCustomer customerDev = new GoldCustomer(10002,"DEV");
		System.out.println(customerDev.calPrice(1000));
		 
		
	}

}
