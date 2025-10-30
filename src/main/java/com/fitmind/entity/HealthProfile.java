package com.fitmind.entity;

import java.util.Objects;

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
	private Double exercise;
	private Double workingStanding;
	private Double workoutFrequency;
	private Double heartIssue;
	private Double jointIssue;
	private Double bonesIssue;
	private Double breathIssue;
	private Double drink;
	private Double smoke;

	public HealthProfile() {
		
	}
	

	public HealthProfile(Long id, Long userId, Double weight, Double height, Double exercise,
			Double workingStanding, Double workoutFrequency, Double heartIssue, Double jointIssue,
			Double bonesIssue, Double breathIssue, Double drink, Double smoke) {
		this.id = id;
		this.userId = userId;
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


	public Double getHeartIssue() {
		return heartIssue;
	}


	public void setHeartIssue(Double heartIssue) {
		this.heartIssue = heartIssue;
	}


	public Double getJointIssue() {
		return jointIssue;
	}


	public void setJointIssue(Double jointIssue) {
		this.jointIssue = jointIssue;
	}


	public Double getBonesIssue() {
		return bonesIssue;
	}


	public void setBonesIssue(Double bonesIssue) {
		this.bonesIssue = bonesIssue;
	}


	public Double getBreathIssue() {
		return breathIssue;
	}


	public void setBreathIssue(Double breathIssue) {
		this.breathIssue = breathIssue;
	}


	public Double getDrink() {
		return drink;
	}


	public void setDrink(Double drink) {
		this.drink = drink;
	}


	public Double getSmoke() {
		return smoke;
	}


	public void setSmoke(Double smoke) {
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