package com.fitmind.entity;

import com.fitmind.utils.ImageCode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_activity")
@Entity
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer workoutDay;
	private String details;
	private String code = ImageCode.generateImageCode(8) ;
	
	@ManyToOne
	@JoinColumn(name = "workout_id")
	private Workout workout;
	
	public Activity() {}
	
	public Activity(Long id, Integer workoutDay, String details, Workout workout) {
		this.id = id;
		this.workoutDay = workoutDay;
		this.details = details;
		this.workout = workout;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getworkoutDay() {
		return workoutDay;
	}

	public void setDay(Integer workoutDay) {
		this.workoutDay = workoutDay;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
