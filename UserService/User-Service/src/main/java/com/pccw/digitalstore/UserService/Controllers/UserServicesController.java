package com.pccw.digitalstore.UserService.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServicesController{
	
	@Autowired
	UserService userService;
	
	
}