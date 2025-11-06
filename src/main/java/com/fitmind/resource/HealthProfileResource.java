package com.fitmind.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmind.entity.Activity;
import com.fitmind.entity.HealthProfile;
import com.fitmind.entity.dto.Information;
import com.fitmind.repository.HealthProfileRepository;
import com.fitmind.service.HealthProfileService;


@RestController
@RequestMapping(value = "/api/v1/profiles")
public class HealthProfileResource {

	private HealthProfileService servico;
	
	public HealthProfileResource(HealthProfileService servico) {
		this.servico = servico;

	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<HealthProfile> findbyId(@PathVariable Long userId){
		HealthProfile p  = servico.getHealthpProfileFromUserId(userId);
		return ResponseEntity.ok().body(p);
		
		
	}	
	@PostMapping("/create")
	public ResponseEntity<HealthProfile> add(@RequestBody HealthProfile p){
		
		System.out.println(p);
		HealthProfile newHealthProfile = servico.add(p); 
		return ResponseEntity.ok().body(newHealthProfile);
		
	}
	
	@GetMapping(value = "/{userId}/bmi")
	public ResponseEntity<Double> getBMI(@PathVariable Long userId){
		Double bmi = servico.getBMI(userId);
		return ResponseEntity.ok().body(bmi);
	}
	
	
	@GetMapping(value = "/{userId}/information")
	public ResponseEntity<Information> getInformation(@PathVariable Long userId){
		
		Double caloricGoal = servico.getCaloricGoal(userId);
		Double totalCaloricExpenditure = servico.getTotalCaloricExpenditure(userId);
		Double getBMR = servico.getBMR(userId);
		Double getBMI = servico.getBMI(userId);
		Boolean hasMuscularInjury = servico.gethasMuscularInjury(userId);
		Boolean hasAtrofiaInjury = servico.gethasMuscularInjury(userId);
		Boolean userTall = servico.getUserTall(userId);
		
		Information i = new Information(caloricGoal, totalCaloricExpenditure, getBMR, getBMI, hasMuscularInjury, hasAtrofiaInjury, userTall);
		
		return ResponseEntity.ok().body(i);
		
	}
	
	@GetMapping(value = "/{userId}/workouts/{day}")
	public ResponseEntity<Activity> getWorkout(@PathVariable Long userId, @PathVariable Integer day){
		Activity a = servico.workoutRecomendation(userId, day);
		return ResponseEntity.ok().body(a);
		
	}

	
	
	
	
	
	
	
	
	
	

	
}
