package com.mobilize.web.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.service.LoginService;

@Controller
public class LoginServiceController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserVO login(@PathVariable("userId") String userId) {
		System.out.println("userId 1: "+userId);
		UserVO user = loginService.getUserById(userId);
		
		System.out.println("UID 2: "+user.getUserId());
		System.out.println("userId 2: "+user.getUserId());
		System.out.println("Password 2: "+user.getPassword());
		System.out.println("Guru Test 2: ");
		return user;
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public @ResponseBody UserVO findCars(@RequestBody UserVO user) {
		UserVO uservo = loginService.getUserById(user.getUserId());
		if (uservo != null) {
			if (uservo.getUserId().equals(user.getUserId()) && uservo.getPassword().equals(user.getPassword())) {
				// do nothing
			} else {
				uservo = null;
			}
		}
		return uservo;
	}
	
	@RequestMapping(value="/user/addUser", method=RequestMethod.POST)
	public @ResponseBody int addUser(@RequestBody UserVO user) {
		int cnt = loginService.insertUser(user);
		return cnt;
	}

	@RequestMapping(value="/user/updateUser", method=RequestMethod.POST)
	public @ResponseBody int updateUser(@RequestBody UserVO user) {
		int cnt = loginService.updateUser(user);
		return cnt;
	}

	@RequestMapping(value="/user/deleteUser", method=RequestMethod.POST)
	public @ResponseBody int deleteUser(@RequestBody UserVO user) {
		int cnt = loginService.deleteUser(user);
		return cnt;
	}
}