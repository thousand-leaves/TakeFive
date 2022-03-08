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
	
	public Person(String name, String email, int age, int coinLevel, int healthLevel, int happyLevel,
			int smartLevel, int creativeLevel) {
		super();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + coinLevel;
		result = prime * result + creativeLevel;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + happyLevel;
		result = prime * result + healthLevel;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + smartLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (coinLevel != other.coinLevel)
			return false;
		if (creativeLevel != other.creativeLevel)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (happyLevel != other.happyLevel)
			return false;
		if (healthLevel != other.healthLevel)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smartLevel != other.smartLevel)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", coinLevel=" + coinLevel
				+ ", healthLevel=" + healthLevel + ", happyLevel=" + happyLevel + ", smartLevel=" + smartLevel
				+ ", creativeLevel=" + creativeLevel + "]";
	}
	
}
