package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test6 {
	public static void main(String[] args) {
		
		// Test6 Iterator를 이용하여 ArrayList 요소 출력 및 삭제 
		/*
		 * Koala
		 * Hippo
		 * Kingkong
		 * Camel
		 * --------------
		 * Kingkong 삭제완료
		 * --------------
		 * Koala
		 * Hippo
		 * Camel
		 */
		ArrayList<String> list = new ArrayList<String>();
		
		list.add( "Koala" );
		list.add( "Hippo" );
		list.add( "Kingkong" );
		list.add( "Camel" );
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------------------");
		Iterator<String> list2 = list.iterator();
		 while (list2.hasNext()) {
	            String item = list2.next();
	            if (item.equals("Kingkong")) {
	           	list2.remove();
	           	
	           	System.out.println("Kingkong 삭제완료 ");
	            }
	        }
		 System.out.println("---------------------");
		 
		 for(int i = 0 ; i < list.size() ; i++) {
				System.out.println(list.get(i));
			}
		
		
		
	}
}
