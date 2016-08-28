package com.mobilize.web.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.CarSummaryVO;
import com.mobilize.core.domain.value.LocationVO;
import com.mobilize.core.location.MatchFinderService;

@Controller
public class LocationController {
	
	@Autowired
	private MatchFinderService matchFinderService;
	
	/*
	@RequestMapping(value="/location/findCars/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public List<CarDetailsVO> getUser(@PathVariable("userId") String userId) {
		System.out.println("userId: "+userId);
		//UserDetailsVO userDetails = userService.getUserDetailsById(userId);
		//return userDetails;
		return null;
	}
*/
	@RequestMapping(value="/location/findCars", method=RequestMethod.POST)
	public @ResponseBody List<CarSummaryVO> findCars(@RequestBody LocationVO locvo) {
		return matchFinderService.getCarsForLocation(locvo);
		//return null;
	}
}
