package com.fitmind.entity;

import java.util.Objects;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_healthProfile")
@Entity

public class HealthProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
//	private User user;
	
	private Integer weight;
	
	private Integer height;
	
	private Integer exercise;
	
	private Integer workingStanding;
	
	private Integer workoutFrequency;
	
	private Integer heartIssue;
	
	private Integer jointIssue;
	
	private Integer bonesIssue;
	
	private Integer breathIssue;
	
	private Integer drink;
	
	private Integer smoke;

	public HealthProfile() {
		
	}
	

	public HealthProfile(Integer id, Integer weight, Integer height, Integer exercise,
			Integer workingStanding, Integer workoutFrequency, Integer heartIssue, Integer jointIssue,
			Integer bonesIssue, Integer breathIssue, Integer drink, Integer smoke) {
		this.id = id;
		//this.user = user;
		this.weight = weight;
		this.height = height;
		this.exercise = exercise;
		this.workingStanding = workingStanding;
		this.workoutFrequency = workoutFrequency;
		this.heartIssue = heartIssue;
		this.jointIssue = jointIssue;
		this.bonesIssue = bonesIssue;
		this.breathIssue = breathIssue;
		this.drink = drink;
		this.smoke = smoke;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/*public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}*/


	public Integer getWeight() {
		return weight;
	}


	public void setWeight(Integer weight) {
		this.weight = weight;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}


	public Integer getExercise() {
		return exercise;
	}


	public void setExercise(Integer exercise) {
		this.exercise = exercise;
	}


	public Integer getWorkingStanding() {
		return workingStanding;
	}


	public void setWorkingStanding(Integer workingStanding) {
		this.workingStanding = workingStanding;
	}


	public Integer getWorkoutFrequency() {
		return workoutFrequency;
	}


	public void setWorkoutFrequency(Integer workoutFrequency) {
		this.workoutFrequency = workoutFrequency;
	}


	public Integer getHeartIssue() {
		return heartIssue;
	}


	public void setHeartIssue(Integer heartIssue) {
		this.heartIssue = heartIssue;
	}


	public Integer getJointIssue() {
		return jointIssue;
	}


	public void setJointIssue(Integer jointIssue) {
		this.jointIssue = jointIssue;
	}


	public Integer getBonesIssue() {
		return bonesIssue;
	}


	public void setBonesIssue(Integer bonesIssue) {
		this.bonesIssue = bonesIssue;
	}


	public Integer getBreathIssue() {
		return breathIssue;
	}


	public void setBreathIssue(Integer breathIssue) {
		this.breathIssue = breathIssue;
	}


	public Integer getDrink() {
		return drink;
	}


	public void setDrink(Integer drink) {
		this.drink = drink;
	}


	public Integer getSmoke() {
		return smoke;
	}


	public void setSmoke(Integer smoke) {
		this.smoke = smoke;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthProfile other = (HealthProfile) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "HealthProfile [id=" + id + ", user=" +  ", weight=" + weight + ", height=" + height
				+ ", exercise=" + exercise + ", workingStanding=" + workingStanding + ", workoutFrequency="
				+ workoutFrequency + ", heartIssue=" + heartIssue + ", jointIssue=" + jointIssue + ", bonesIssue="
				+ bonesIssue + ", breathIssue=" + breathIssue + ", drink=" + drink + ", smoke=" + smoke + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}