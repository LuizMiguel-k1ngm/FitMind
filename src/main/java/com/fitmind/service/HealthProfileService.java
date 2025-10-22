package com.fitmind.service;
import com.fitmind.resource.HealthProfileResource;
import org.springframework.stereotype.Service;

import com.fitmind.entity.HealthProfile;
import com.fitmind.entity.User;
import com.fitmind.repository.HealthProfileRepository;
import com.fitmind.repository.UserRepository;

@Service
public class HealthProfileService {

	
	private HealthProfileRepository profileRepository;
	private UserRepository userRepository;
	
	public HealthProfileService(HealthProfileRepository profileRepository, UserRepository userRepository) {
		this.profileRepository = profileRepository;
		this.userRepository = userRepository;
	}
	
	public HealthProfile add(HealthProfile u) {
		return profileRepository.save(u);	
	}
	
	public HealthProfile findById(Integer id) {
		return profileRepository.findById(id).get();	
	}
			
	public Integer findUserById (Integer id) {
		
		HealthProfile p = profileRepository.findByUserId(id);
		
		return p.getUserId();		
		
	}
	
	
	
	
	
	
	
	

	// Lesao muscular
	public Boolean hasMuscularInjury(Integer id) {
		
		HealthProfile p = findById(id);
		
		if(p.getJointIssue() == 1 
				&& p.getWorkoutFrequency() >= 3
				&& p.getWorkingStanding()  == 1 
				&& p.getSmoke() == 1) {
			return true;			
		}
		return false;
		
		
		
	}
	
	
  public Integer getBMI (Integer id ){
	  
	  //bmi = weight / height* height
	  HealthProfile p = findById(id);
	  Integer height = p.getHeight() / 100;
	  
	  Integer bmi = p.getWeight()/ height * height ; 
	  return bmi;
	    
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// atrofia
	public Boolean hasAtrofiaInjury() {
		
		// O que tem que ser True do perfil, para ser AtrofiaInjury
		
		return true;
	}
	
	public Boolean fatUser(Integer id) {
		
		HealthProfile p = findById(id);
		
		Integer FAT_LIMIT = 100;
		
		if ( p.getWeight() > FAT_LIMIT ) {
			return true;
		}
		return false;
	}
	
	public Boolean userTall(Integer id) {
		
		HealthProfile p = findById(id);
		
		if ( p.getHeight() > 190 ) {
			return true;
		}
		return false;	
	}
	
	
}
