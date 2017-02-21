package com.sqli.formation.model;

public class Personne 
{
	int id;
	String name;
	int age;
	
	
	public Personne(int custId, String name, int age) {
		this.id = custId;
		this.name = name;
		this.age = age;
	}
	
	public int getCustId() {
		return id;
	}
	public void setCustId(int custId) {
		this.id = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [age=" + age + ", id=" + id + ", name=" + name
				+ "]";
	}
	
	
}
