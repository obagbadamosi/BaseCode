package com.secure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
