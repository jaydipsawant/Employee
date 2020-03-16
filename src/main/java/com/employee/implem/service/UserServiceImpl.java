package com.employee.implem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.UserRepository;
import com.employee.demo.ws.ui.controller.userService;
import com.employee.entity.userEntity;
import com.employee.shared.dto.UserDTO;

@Service
public class UserServiceImpl implements userService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDTO createUser(UserDTO userdt) {

		userEntity userent = userRepo.findByEmail(userdt.getEmail());

		if (userent != null)
			throw new RuntimeException("Record already exist");
		
		// if (userRepo.findByEmail(userdt.getEmail()) != null)throw new
		// RuntimeException("Record already exist");
		
		userEntity uentity = new userEntity();
		BeanUtils.copyProperties(userdt, uentity);

		uentity.setEncryptedPassword("Test");
		uentity.setUserId("jaydips");
		userEntity storedUserDetails = userRepo.save(uentity);

		UserDTO returnval = new UserDTO();
		BeanUtils.copyProperties(storedUserDetails, returnval);

		return returnval;
	}

}
