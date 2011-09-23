package demo;

import demo.bean.Person;

public class Hello {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("hoge");
		p.setAge(11);
		
		System.out.println(p);
	}

}
