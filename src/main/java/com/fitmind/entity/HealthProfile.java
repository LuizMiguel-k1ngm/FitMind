package com.fitmind.entity;

import java.util.Objects;

import com.fitmind.entity.enums.ProfileType;

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
	private Long id;

	private Long userId;
	
	private Double weight;
	private Double height;
	private ProfileType health;
	private Double exercise;
	private Integer goal;
	private Double workingStanding;
	private Double workoutFrequency;
	private Integer heartIssue;
	private Integer jointIssue;
	private Integer bonesIssue;
	private Integer breathIssue;
	private Integer drink;
	private Integer smoke;

	public HealthProfile() {
		
	}
	

	public HealthProfile(Long id, Long userId, Double weight, Double height, ProfileType health, Double exercise,
			Integer goal, Double workingStanding, Double workoutFrequency, Integer heartIssue,
			Integer jointIssue, Integer bonesIssue, Integer breathIssue,
			Integer drink, Integer smoke) {
		this.id = id;
		this.userId = userId;
		this.weight = weight;
		this.height = height;
		this.health = health; 
		this.goal = goal;
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


	public ProfileType getHealth() {
		return health;
	}


	public void setHealth(ProfileType health) {
		this.health = health;
	}


	public Integer getGoal() {
		return goal;
	}


	public void setGoal(Integer goal) {
		this.goal = goal;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUser(Long userId) {
		this.userId = userId;
	}
	
	



	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getExercise() {
		return exercise;
	}


	public void setExercise(Double exercise) {
		this.exercise = exercise;
	}


	public Double getWorkingStanding() {
		return workingStanding;
	}


	public void setWorkingStanding(Double workingStanding) {
		this.workingStanding = workingStanding;
	}


	public Double getWorkoutFrequency() {
		return workoutFrequency;
	}


	public void setWorkoutFrequency(Double workoutFrequency) {
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
	

	
	
	
	
	
	
	
	
	
}