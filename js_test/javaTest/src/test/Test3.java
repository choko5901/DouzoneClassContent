package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test3 {
	public static void main(String[] args) {
		
		// Test3 전체 요소 출력하기
		// 컬렉션 프레임워크의 ArrayList 기반으로 
		// 2차원 배열을 만들어 요소를 추가하고 출력해보세요.
		/*
		 * 11 12 13 14 
		 * 21 22 23 24 
		 * 31 32 33 34 
		 */
		
		 ArrayList<Integer[]> Test3 = new ArrayList<Integer[]>();
		 Test3.add(new Integer[] {11,12,13,14});
		 Test3.add(new Integer[] {21,22,23,24,25});
		 Test3.add(new Integer[] {31,32,33,34});
		 
		 for(int i = 0 ; i < Test3.size() ; i++) {
//			 System.out.println(Arrays.toString(Test3.get(i)));
			 for(int j = 0 ; j < Test3.get(i).length; j++ ) {
				 System.out.print(Test3.get(i)[j] + " ");
			 }
			 System.out.println();
//			 System.out.println(Test3.get(i)[0] + " " + Test3.get(i)[1] + " " + Test3.get(i)[2] + " " + Test3.get(i)[3]);
		 }
		 
		 
		
	}
}
