package step06.template;

public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("사람이 운전합니다");
	}

	@Override
	public void stop() {
		
		System.out.println("브레이클를 밟아서 정지합니다");		
	}

	
}
