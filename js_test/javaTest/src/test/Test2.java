package test;


abstract class Animal {
	abstract void cry();
	abstract void fly();
}

class Dog extends Animal{
	void cry() { System.out.println("멍멍!"); }
	void fly() {}
}

class Cat extends Animal{
void cry() { System.out.println("야옹!"); }
void fly() {}
}
class Cow extends Animal{
void cry() { System.out.println("음메!"); }
void fly() {}
}
class Animal2 extends Animal{
void cry() {}
void fly() {System.out.println("윙윙!");}
}

public class Test2 {
	public static void main(String[] args) {
		
		// Test2 결과 출력하기
		/*
		 * 윙윙!
		 * 멍멍!
		 * 야옹!
		 * 음메!
		 */
		
		Animal2 dragonfly = new Animal2();
		dragonfly.fly(); // 윙윙!
		
		Dog dog = new Dog();
		dog.cry();  // 멍멍!
		
		Cat cat = new Cat();
		cat.cry();  // 야옹!
		
		Cow cow = new Cow();
		cow.cry();  // 음메!
		
	}
}
