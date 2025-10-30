package com.fitmind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitmind.entity.HealthProfile;

public interface HealthProfileRepository extends JpaRepository<HealthProfile, Long> {
	
	public HealthProfile findByUserId(Long id);

}
