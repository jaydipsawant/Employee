package com.employee;

import org.springframework.data.repository.CrudRepository;

import com.employee.entity.userEntity;

public interface UserRepository extends CrudRepository<userEntity,Long> {

	userEntity findByEmail(String email);
	
}
