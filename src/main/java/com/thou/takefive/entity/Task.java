package com.thou.takefive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Variables
	private int taskId;
	private String category;
	private String description;
	private int coinReward;
	private int healthReward;
	private int happyReward;
	private int smartReward;
	private int creativeReward;
	
	// Constructors
	public Task() {}
	
	public Task(int taskId, String category, String description, int coinReward, int healthReward, int happyReward,
			int smartReward, int creativeReward) {
		super();
		this.taskId = taskId;
		this.category = category;
		this.description = description;
		this.coinReward = coinReward;
		this.healthReward = healthReward;
		this.happyReward = happyReward;
		this.smartReward = smartReward;
		this.creativeReward = creativeReward;
	}

	// Getters and Setters
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCoinReward() {
		return coinReward;
	}

	public void setCoinReward(int coinReward) {
		this.coinReward = coinReward;
	}

	public int getHealthReward() {
		return healthReward;
	}

	public void setHealthReward(int healthReward) {
		this.healthReward = healthReward;
	}

	public int getHappyReward() {
		return happyReward;
	}

	public void setHappyReward(int happyReward) {
		this.happyReward = happyReward;
	}

	public int getSmartReward() {
		return smartReward;
	}

	public void setSmartReward(int smartReward) {
		this.smartReward = smartReward;
	}

	public int getCreativeReward() {
		return creativeReward;
	}

	public void setCreativeReward(int creativeReward) {
		this.creativeReward = creativeReward;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + coinReward;
		result = prime * result + creativeReward;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + happyReward;
		result = prime * result + healthReward;
		result = prime * result + smartReward;
		result = prime * result + taskId;
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
		Task other = (Task) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (coinReward != other.coinReward)
			return false;
		if (creativeReward != other.creativeReward)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (happyReward != other.happyReward)
			return false;
		if (healthReward != other.healthReward)
			return false;
		if (smartReward != other.smartReward)
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

	// toString method
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", category=" + category + ", description=" + description + ", coinReward="
				+ coinReward + ", healthReward=" + healthReward + ", happyReward=" + happyReward + ", smartReward="
				+ smartReward + ", creativeReward=" + creativeReward + "]";
	}

}
