package com.matrix.medical.appointment.controller;

import com.matrix.medical.appointment.entity.User;
import com.matrix.medical.appointment.repository.UserRepository;
import com.matrix.medical.appointment.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 6000)
@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value= Constants.GET_USER_BY_CONFIRMATIONCODE, method= RequestMethod.GET)
	public User findByConfirmationCode(@PathVariable String confirmationCode){
		return userRepository.findByConfirmationCode(confirmationCode);
	}

	@RequestMapping(value= Constants.SAVE_USER, method= RequestMethod.POST)
	public User saveUser(@RequestBody User userDto) {
		return userRepository.save(userDto);
	}
}


