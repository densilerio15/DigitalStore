package com.pccw.digitalstore.UserService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.UserService.DTO.ResponseDTO;
import com.pccw.digitalstore.UserService.Model.User;
import com.pccw.digitalstore.UserService.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserServicesController{
	
	@Autowired
	UserService userService;
	
	@GetMapping("/username={username}")
	public ResponseDTO getByUserName(@PathVariable("username") String username) {
		User  user = userService.getUserByUsername(username);
		return new ResponseDTO(user , "User Retrieved");
	}
	}