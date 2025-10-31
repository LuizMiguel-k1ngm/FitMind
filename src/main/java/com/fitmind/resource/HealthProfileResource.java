package com.fitmind.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmind.entity.HealthProfile;
import com.fitmind.repository.HealthProfileRepository;
import com.fitmind.service.HealthProfileService;


@RestController
@RequestMapping(value = "/api/v1/profiles")
public class HealthProfileResource {

    private final HealthProfileRepository healthProfileRepository;
	private HealthProfileService servico;
	
	public HealthProfileResource(HealthProfileService servico, HealthProfileRepository healthProfileRepository) {
		this.servico = servico;
		this.healthProfileRepository = healthProfileRepository;	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HealthProfile> findbyId(@PathVariable Long id){
		HealthProfile p  = servico.findById(id);
		return ResponseEntity.ok().body(p);
		
		
	}	
	@PostMapping("/create")
	public ResponseEntity<HealthProfile> add(@RequestBody HealthProfile p){
		
		System.out.println(p);
		HealthProfile newHealthProfile = servico.add(p); 
		return ResponseEntity.ok().body(newHealthProfile);
		
	}
	
	@GetMapping(value = "/{id}/bmi")
	public ResponseEntity<Double> getBMI(@PathVariable Long id){
		
		Double bmi = servico.getBMI(id);

		return ResponseEntity.ok().body(bmi);
	}
	
	
	
	
	

	
}
