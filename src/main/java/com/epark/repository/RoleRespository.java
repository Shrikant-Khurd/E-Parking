package com.epark.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epark.model.UserRole;


public interface RoleRespository extends JpaRepository<UserRole, Integer> {

	boolean existsByRoleName(String roleName);
	Optional<UserRole> findByRoleName(String name);
	UserRole findByRoleId(int roleId);
}
