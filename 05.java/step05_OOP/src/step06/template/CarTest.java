package step06.template;

public class CarTest {

	public static void main(String[] args) {
		// 추상클래스는 객체 생성이 불가능하다!!!
//		Car car = new Car();
		Car aiCar = new AICar();
		
//		aiCar.startCar();
//		aiCar.drive();
//		aiCar.stop();
//		aiCar.turnOff();
		aiCar.run();
		
		Car manualCar = new ManualCar();
//		manualCar.startCar();
//		manualCar.drive();
//		manualCar.stop();
//		manualCar.turnOff();
		manualCar.run();
	}

}
