package com.fitmind.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fitmind.entity.enums.ProfileType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tb_workout")
@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String details;
	private ProfileType target;
	
	@OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Activity> workout = new ArrayList<>();
	
	
	public Workout() {
	}

	public Workout(Long id, String name, String details, ProfileType target) {
		this.id = id;
		this.name = name;
		this.details = details;
	}

	public ProfileType getTarget() {
		return target;
	}

	public void setTarget(ProfileType target) {
		this.target = target;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<Activity> getWorkout() {
		return workout;
	}


	@Override
	public String toString() {
		return "Workout [name=" + name + ", details=" + details + ", workout=" + workout + "]";
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
		Workout other = (Workout) obj;
		return Objects.equals(id, other.id);
	}	
}
