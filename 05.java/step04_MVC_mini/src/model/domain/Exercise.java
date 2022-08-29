package model.domain;

public class Exercise {
	private int reps;
	private String type;
	private String name;
	private int weight;
	
public Exercise() {}

public Exercise( String type, String name,int weight, int reps ) {
	this.reps = reps;
	this.type = type;
	this.name = name;
	this.weight = weight;

}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}
public int getReps() {
	return reps;
}

public void setReps(int reps) {
	if(reps > 0) {
		this.reps =reps;
	}else {
		System.out.println("잘못 된 횟수 입력 입니다");
	}
}
public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	if(weight > 0) {
		this.weight =weight;
	}else {
		System.out.println("잘못 된 무게 입력 입니다");
	}
}









	
	

}
