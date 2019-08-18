package com.secure.app.User.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.secure.app.model.User;
import com.secure.app.repo.RoleRepository;
import com.secure.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	 
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	private RoleRepository roleRepository;
	 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
	public UserServiceImpl() {
		super();
		//this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    user.setRoles(new HashSet<>(roleRepository.findAll()));
	    userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
