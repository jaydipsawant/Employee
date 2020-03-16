package com.employee.demo.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.request.model.UserDetails;
import com.employee.response.model.UserRespDetails;
import com.employee.shared.dto.UserDTO;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	userService userService;

	@GetMapping()
	public String getUser() {
		return "jaydip";
	}

	@PostMapping
	public UserRespDetails createUser(@RequestBody UserDetails userdetails) {
		UserRespDetails returnval = new UserRespDetails();
		UserDTO userdt = new UserDTO();
		BeanUtils.copyProperties(userdetails, userdt);
		UserDTO createUsr = userService.createUser(userdt);
		BeanUtils.copyProperties(createUsr, returnval);
		return returnval;
	}

}
