package com.carnacorp.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnacorp.dscatalog.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
