package com.secure.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
