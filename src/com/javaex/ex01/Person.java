package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String company;

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public String getHp() {
		return hp;
	}

	public String getCompany() {
		return company;
	}

	public void showInfo() {
		System.out.println(name + "    " + hp + "\t" + company);
	}

}