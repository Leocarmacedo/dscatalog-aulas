package com.carnacorp.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnacorp.dscatalog.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
