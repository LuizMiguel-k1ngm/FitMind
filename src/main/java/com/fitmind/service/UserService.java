package com.fitmind.service;


import org.springframework.stereotype.Service;
import com.fitmind.FitMindAiApplication;
import com.fitmind.entity.User;
import com.fitmind.repository.UserRepository;

@Service
public class UserService {

    private final FitMindAiApplication fitMindAiApplication;
	
	private UserRepository repository;

	public UserService(UserRepository repository, FitMindAiApplication fitMindAiApplication) {
		
		this.repository = repository;
		
		this.fitMindAiApplication = fitMindAiApplication;
	}
	
	public User add (User u){
	return repository.save(u);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User findById(Integer id) {
		return repository.findById(id).get();
	}
	
	public User updateUser(Integer id, User u){
		User oldUser = findById(id);
		User newUser = new User();
		newUser.setId(oldUser.getId());
		newUser.setAge(u.getAge());;
		newUser.setEmail(u.getEmail());
		newUser.setName(u.getName());
		add(newUser);
		delete(oldUser.getId());
		return newUser;
		
		
		
		
	}
	
	

}
