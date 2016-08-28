package com.mobilize.web.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.service.UserDetailsService;

@Controller
public class UserServiceController {

	@Autowired
	private UserDetailsService userService;
	
	/*
	@RequestMapping(value="/user/getUser/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserDetailsVO getUser(@PathVariable("userId") String userId) {
		System.out.println("userId: "+userId);
		UserDetailsVO userDetails = userService.getUserDetailsById(userId);
		return userDetails;
	}
	*/
	
	@RequestMapping(value="/user/getUserDetails", method=RequestMethod.POST)
	public @ResponseBody UserDetailsVO getUser(@RequestBody UserVO user) {
		System.out.println(user.toString());
		UserDetailsVO userDetails = userService.getUserDetailsById(user.getUid(), user.getUserType());
		return userDetails;
	}


	@RequestMapping(value="/user/addUserDetails", method=RequestMethod.POST)
	public @ResponseBody int addUser(@RequestBody UserDetailsVO userDetails) {
		System.out.println(userDetails.toString());
		int rcount = userService.insertUserDetails(userDetails);
		return rcount;
	}
	
	@RequestMapping(value="/user/updateUserDetails", method=RequestMethod.POST)
	public @ResponseBody int updateUser(@RequestBody UserDetailsVO userDetails) {
		int rcount = userService.updateUserDetailsById(userDetails);
		System.out.println(userDetails.toString());
		return rcount;
	}

	@RequestMapping(value="/user/deleteUserDetails", method=RequestMethod.POST)
	public @ResponseBody int deleteUser(@RequestBody UserVO user) {	
		int rcount = userService.deleteUserDetailsById(user.getUserId(), user.getUserType());
		return rcount;
	}
}
