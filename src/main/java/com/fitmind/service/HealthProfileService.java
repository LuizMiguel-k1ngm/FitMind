package com.fitmind.service;
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
	
	public HealthProfile findById(Long id) {
		return profileRepository.findById(id).get();	
	}
	
	
			
	public Long findUserById (Long id) {
		
		HealthProfile p = profileRepository.findByUserId(id);
		
		return p.getUserId();		
		
	}
	
	
	

	// Lesao muscular
	public Boolean hasMuscularInjury(Long id) {
		
		HealthProfile p = findById(id);
		
		if(p.getJointIssue() == 1 
				&& p.getWorkoutFrequency() >= 3
				&& p.getWorkingStanding()  == 1 
				&& p.getSmoke() == 1) {
			return true;			
		}
		return false;
		
		
		
	}
	
	
	//BMI
	
  public Double getBMI (Long id ){
	  
	  //bmi = weight / height* height
	  HealthProfile p = findById(id);
	  Double squareHeight = p.getHeight() * p.getHeight();
	  
	  Double bmi = p.getWeight() / squareHeight ; 
	  return bmi;	    
  }
  
  //BMR - basal metabolic rate
  
  public Double getBMR(Long id) {
	  HealthProfile p = findById(id);
	  Long userId = findUserById(id);
	  User u = userRepository.findById(userId).get();
	  Integer gender = u.getGender();
	  Double weightToCm = p.getHeight()*100;
	  	  
	  
	  Double variableForGender = gender == 1 ? (10 * weightToCm) + (6.25 * weightToCm ) -  (5* u.getAge()) + 5 : (10 * weightToCm) + (6.25 * weightToCm ) -  (5* u.getAge())-161;
	  return variableForGender;
	  
  }
  
  
  public Double  totalCaloricExpenditure (Long id){
	  // niveis : sedantário: fator 1.2; levemente ativo 1.55
	  // muito ativo: 1.725; extremantente ativo 1.90;
	 // variableForGender * nivel
	  Double bmr = getBMR(id);
	  HealthProfile p = findById(id);
	  Double activityFactor;
	  Double frequency = p.getWorkoutFrequency();
	  
	  if(frequency == 0) {
		  activityFactor = 1.2;
	  }else if (frequency <= 2) {
		  activityFactor = 1.55;
	  }else if (frequency <= 4) {
		  activityFactor = 1.725;
	  }else {
		  activityFactor = 1.90;
	  }
	  
	  return bmr * activityFactor;
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  
  }
  
  
    
  
  
  
  
	// atrofia
	public Boolean hasAtrofiaInjury() {
		
		// O que tem que ser True do perfil, para ser AtrofiaInjury
		
		return true;
	}
	
	public Boolean fatUser(Long id) {
		
		HealthProfile p = findById(id);
		
		
		Integer FAT_LIMIT = 100;
		
		if ( p.getWeight() > FAT_LIMIT ) {
			return true;
		}
		return false;
	}
	
	public Boolean userTall(Long id) {
		
		HealthProfile p = findById(id);
		
		if ( p.getHeight() > 190 ) {
			return true;
		}
		return false;	
	}
	
	
}
