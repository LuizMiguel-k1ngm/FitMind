package com.fitmind.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fitmind.entity.Activity;
import com.fitmind.entity.HealthProfile;
import com.fitmind.entity.User;
import com.fitmind.entity.Workout;
import com.fitmind.entity.enums.ProfileType;
import com.fitmind.exceptions.UserAlreadyHasProfile;
import com.fitmind.repository.HealthProfileRepository;
import com.fitmind.repository.UserRepository;
import com.fitmind.repository.WorkoutRepository;

@Service
public class HealthProfileService {

	private static final Double CALORIE_TRESHOLD = 500.;
	private static final Integer ELDERLY_TRESHOLD = 65;
	

	private HealthProfileRepository profileRepository;
	private UserRepository userRepository;
	private WorkoutRepository workoutRepository;

	

	public HealthProfileService(HealthProfileRepository profileRepository, UserRepository userRepository,
			WorkoutRepository workoutRepository) {
		this.profileRepository = profileRepository;
		this.userRepository = userRepository;
		this.workoutRepository = workoutRepository;
	}
	
	public List<Workout> loadWorkouts(){
		return workoutRepository.findAll();		
	}
	
	public HealthProfile getHealthpProfileFromUserId(Long userId) {
		return profileRepository.findByUserId(userId);
	}

	
	public List<HealthProfile>  getAllProfiles(){
		return profileRepository.findAll();
		
	}
	
	

	
	public HealthProfile add(HealthProfile p) {
		Long userId = p.getUserId();
		List<HealthProfile> profiles  = getAllProfiles();
		List<Long> userIds = profiles.stream().map(px -> px.getUserId()).toList();
		
		if(userIds.contains(userId)) {
			throw new UserAlreadyHasProfile("User already exist") ; 
		}
		return profileRepository.save(p);
	}



	

	// Lesao muscular
	public Boolean gethasMuscularInjury(Long userId) {

		HealthProfile p = getHealthpProfileFromUserId(userId);

		if (p.getJointIssue() == 1 && p.getWorkoutFrequency() >= 3 && p.getWorkingStanding() == 1
				&& p.getSmoke() == 1) {
			return true;
		}
		return false;

	}

	// BMI

	public Double getBMI(Long userId) {
		HealthProfile p = getHealthpProfileFromUserId(userId);
		Double squareHeight = p.getHeight() * p.getHeight();
		Double bmi = p.getWeight() / squareHeight;
		return bmi;
	}

	// BMR - basal metabolic rate

	public Double getBMR(Long userId) {
		HealthProfile p = getHealthpProfileFromUserId(userId);
		User u = userRepository.findById(userId).get();
		Integer gender = u.getGender();
		Double weightToCm = p.getHeight() * 100;

		Double variableForGender = gender == 1 ? (10 * weightToCm) + (6.25 * weightToCm) - (5 * u.getAge()) + 5
				: (10 * weightToCm) + (6.25 * weightToCm) - (5 * u.getAge()) - 161;
		return variableForGender;

	}

	public Double getTotalCaloricExpenditure(Long userId) {
		// niveis : sedantário: fator 1.2; levemente ativo 1.55
		// muito ativo: 1.725; extremantente ativo 1.90;
		// variableForGender * nivel
		Double bmr = getBMR(userId);
		HealthProfile p = getHealthpProfileFromUserId(userId);
		Double activityFactor;
		Double frequency = p.getWorkoutFrequency();

		if (frequency == 0) {
			activityFactor = 1.2;
		} else if (frequency <= 2) {
			activityFactor = 1.55;
		} else if (frequency <= 4) {
			activityFactor = 1.725;
		} else {
			activityFactor = 1.90;
		}

		return bmr * activityFactor;

	}

	// caloric goal

	public Double getCaloricGoal(Long userId) {
		// - manter = tce
		// - perder = tce - 500
		// - ganhar massa = tce + 500

		HealthProfile p = getHealthpProfileFromUserId(userId);
		Double tce = getTotalCaloricExpenditure(userId);
		Integer goal = p.getGoal();

		switch (goal) {

		case 0:
			return tce;
		case 1:
			return tce - CALORIE_TRESHOLD;
		case 2:
			return tce + CALORIE_TRESHOLD;

		default:
			return 0.0;
		}

	}

	
	public Boolean fatUser(Long userId) {

		HealthProfile p = getHealthpProfileFromUserId(userId);

		Integer FAT_LIMIT = 100;

		if (p.getWeight() > FAT_LIMIT) {
			return true;
		}
		return false;
	}

	public Boolean getUserTall(Long userId) {

		HealthProfile p = getHealthpProfileFromUserId(userId);

		if (p.getHeight() > 190) {
			return true;
		}
		return false;
	}

	public ProfileType classifyPerson(Long userId) {
		
		HealthProfile p = getHealthpProfileFromUserId(userId);
		
		User u = userRepository.findById(userId).get();
		
		ProfileType pType = null;

		// doenças
		if (p.getBonesIssue() == 0 && p.getBreathIssue() == 0 && p.getHeartIssue() == 0 && p.getJointIssue() == 0) {
			// genero = homem

			pType = u.getGender() == 0 ? ProfileType.HEALTHY_WOMEN : ProfileType.HEALTHY_MAN;

			if (u.getAge() > ELDERLY_TRESHOLD) {
				pType = ProfileType.ELDERLY_PERSON;
				p.setHealth(pType);
			}
		}

		if (p.getBonesIssue() == 1 || p.getJointIssue() == 1) {
			pType = ProfileType.JOINT_ISSUE_PERSON;
			p.setHealth(pType);
		}

		if (p.getBreathIssue() == 1 || p.getHeartIssue() == 1) {
			pType = ProfileType.HEART_OR_LUNG_ISSUE_PERSON;
			p.setHealth(pType);
		}
			
		return pType;

	}


	public Activity workoutRecomendation(Long userId, Integer day) {
		
		ProfileType pType = classifyPerson(userId);
		List<Workout> workouts = loadWorkouts();

		
		Workout t =  workouts.stream().filter(w -> w.getTarget() == pType).findFirst().get();
			
		List<Activity> a = t.getWorkout();
		
		Activity returningActivity = a.stream().filter(ax -> ax.getworkoutDay() == day).findFirst().get();
		
		return returningActivity;
		
		
		
		
		
		

	}

}
