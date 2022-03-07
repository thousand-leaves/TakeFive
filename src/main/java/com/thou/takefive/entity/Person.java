package com.thou.takefive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String email;
	private int age;
	private int coinLevel;
	private int healthLevel;
	private int happyLevel;
	private int smartLevel;
	private int creativeLevel;
	
	public Person() {}
	
	public Person(int id, String name, String email, int age, int coinLevel, int healthLevel, int happyLevel,
			int smartLevel, int creativeLevel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.coinLevel = coinLevel;
		this.healthLevel = healthLevel;
		this.happyLevel = happyLevel;
		this.smartLevel = smartLevel;
		this.creativeLevel = creativeLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCoinLevel() {
		return coinLevel;
	}

	public void setCoinLevel(int coinLevel) {
		this.coinLevel = coinLevel;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public int getHappyLevel() {
		return happyLevel;
	}

	public void setHappyLevel(int happyLevel) {
		this.happyLevel = happyLevel;
	}

	public int getSmartLevel() {
		return smartLevel;
	}

	public void setSmartLevel(int smartLevel) {
		this.smartLevel = smartLevel;
	}

	public int getCreativeLevel() {
		return creativeLevel;
	}

	public void setCreativeLevel(int creativeLevel) {
		this.creativeLevel = creativeLevel;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", coinLevel=" + coinLevel
				+ ", healthLevel=" + healthLevel + ", happyLevel=" + happyLevel + ", smartLevel=" + smartLevel
				+ ", creativeLevel=" + creativeLevel + "]";
	}
	
}
