package model;

import model.domain.Exercise;

public class ExerciseModel {
	
	//DB 배열
	
	private static Exercise[] allData = new Exercise[16];
	private static int index;
	// 데이터 저장
	
	static {
		allData[0] = new Exercise("가슴","벤치프레스",65,10);
		allData[1] = new Exercise("등","렛풀다운",70,15);
		allData[2] = new Exercise("팔","바벨 덤벨컬",30,10);
		allData[3] = new Exercise("하체","스쿼트",100,10);
		allData[4] = new Exercise("가슴","체스트프레스",65,10);
		allData[5] = new Exercise("등","시티드로우",50,15);
		allData[6] = new Exercise("팔","케이블푸쉬다운",30,20);
		allData[7] = new Exercise("하체","레그프레스",120,20);
		index = 8;
	}
	
	
	
}
