package step01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.domain.Person;

public class Ex04Serialization {

	public static void main(String[] args) throws Exception {
		// 객체 출력
		
//		FileOutputStream fos  = new FileOutputStream("Object.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		oos.writeObject(new String("IT"));
//		oos.writeObject(new Integer(1));
//		
//		oos.flush(); 
//		oos.close();
//		fos.close();
		
		
		// 저장한 객체를 입력
//		
//		FileInputStream fis = new FileInputStream("Object.txt");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		
//		
//		Object obj = null;
//		
//		while(true) {
//			obj = ois.readObject();
//			System.out.println(obj);
//		}
		
		
		//직렬화
//		FileOutputStream fosPerson = new FileOutputStream("Person.txt");
//		ObjectOutputStream oosPerson = new ObjectOutputStream(fosPerson);
//		
//		Person personOut = new Person();
//		personOut.setName("IT");
//		personOut.setAge(26);
//		personOut.setPhoneNumber(10);
//		personOut.setPersonalNumber(123123);
//		personOut.setCount(1);
//		
//		
//		
//		oosPerson.writeObject(personOut);
//		oosPerson.flush();
//		oosPerson.close();
//		fosPerson.close();
		
		
		
		// 역직렬화
		
		FileInputStream fisPerson = new FileInputStream("Person.txt");
		ObjectInputStream oisPerson = new ObjectInputStream(fisPerson);
		
		System.out.println(oisPerson.readObject());
		
		
		// phoneNumber
		
//		System.out.println(((Person)oisPerson.readObject()).getPhoneNumber());
//		
//		
//		oisPerson.close();
//		fisPerson.close();
//		
		
		
	}

}
