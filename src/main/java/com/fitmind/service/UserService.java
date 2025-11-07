package com.fitmind.service;


import org.springframework.stereotype.Service;

import com.fitmind.entity.HealthProfile;
import com.fitmind.entity.User;
import com.fitmind.repository.HealthProfileRepository;
import com.fitmind.repository.UserRepository;

@Service
public class UserService {

	
	private UserRepository userRepository;
	private HealthProfileRepository profileRepository;
	private HealthProfileService profileService;

	public UserService(UserRepository userRepository, HealthProfileRepository profileRepository, HealthProfileService profileService) {
		
		this.userRepository = userRepository;
		this.profileRepository = profileRepository;
		this.profileService = profileService;
		
		
	}
	
	public User add (User u){
		return userRepository.save(u);
	
		
	}
	
	public void delete(Long userId) {
		
		HealthProfile p = profileService.getHealthpProfileFromUserId(userId);
		
		if(p != null) {
			profileRepository.deleteById(p.getId());
		}
		
		userRepository.deleteById(userId);	
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	

	
	

}
