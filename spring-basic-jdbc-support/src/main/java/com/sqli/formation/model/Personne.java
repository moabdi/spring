package com.sqli.formation.model;

public class Personne {
	Long id;
	String name;
	int age;

	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	public Personne(String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Personne(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Personne [age=" + age + ", id=" + id + ", name=" + name + "]";
	}

}
