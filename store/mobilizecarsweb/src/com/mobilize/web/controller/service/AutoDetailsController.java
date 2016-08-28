/**
 * 
 * This class is a Mask for CarDetails
 * 
 * This can also be used as CarDetailsController
 */

package com.mobilize.web.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.BaseVO;
import com.mobilize.core.domain.value.CarDetailsVO;
import com.mobilize.core.domain.value.CarSummaryVO;
import com.mobilize.core.service.CarDetailsService;

@Controller
public class AutoDetailsController {

	@Autowired
	private CarDetailsService carDetailsService;
	
	@RequestMapping(value="/car/getAutoDetailsByUid/{uid}", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<CarDetailsVO> getCarDetailsByUid(@PathVariable("uid") String uid) {
		System.out.println("UID received : " + uid );
		ArrayList<CarDetailsVO> carDetailsVO = carDetailsService.getCarDetailsByUid(uid);
		return carDetailsVO;
	}
	
	@RequestMapping(value="/car/getAutoDetailsByZip/{zip}", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<CarDetailsVO> getCarDetailsByZip(@PathVariable("zip") String zip) {
		System.out.println("ZIP received : " + zip );
		ArrayList<CarDetailsVO> carDetailsVO = carDetailsService.getCarDetailsByZip(zip);
		return carDetailsVO;
	}	
	
	/*
	@RequestMapping(value="/car/getAutoDetailsByCarId/{carId}", method=RequestMethod.GET)
	@ResponseBody
	public CarDetailsVO getCarDetailsByCarId(@PathVariable("carId") String carId) {
		System.out.println("Car ID received : " + carId );
		CarDetailsVO carDetailsVO = carDetailsService.getCarDetailsByCarId(carId);
		return carDetailsVO;
	}
*/
	@RequestMapping(value="/car/getAutoDetailsByUserId", method=RequestMethod.POST)
	public @ResponseBody List<CarSummaryVO> getAutoDetailsByUserId(@RequestBody BaseVO baseVO) {
		System.out.println("Car ID received : " + baseVO.getId() );
		List<CarSummaryVO> carsList = carDetailsService.getCarsSummaryByUid(baseVO.getId());
		return carsList;
	}

	@RequestMapping(value="/car/getAutoDetailsByCarId", method=RequestMethod.POST)
	public @ResponseBody CarDetailsVO getCarDetailsByCarId(@RequestBody BaseVO baseVO) {
		System.out.println("Car ID received : " + baseVO.getId() );
		CarDetailsVO carDetailsVO = carDetailsService.getCarDetailsByCarId(baseVO.getId());
		return carDetailsVO;
	}

	@RequestMapping(value="/car/addAuto", method=RequestMethod.POST)
	public @ResponseBody int insertCarDetails(@RequestBody CarDetailsVO carDetailsVO) {
		int rcount = carDetailsService.insertCarDetails(carDetailsVO);
		return rcount;
	}
	
	@RequestMapping(value="/car/updateAuto", method=RequestMethod.POST)
	public @ResponseBody int updateCarDetailsById(@RequestBody CarDetailsVO carDetailsVO) {
		int rcount = carDetailsService.updateCarDetailsById(carDetailsVO);
		return rcount;
	}

	@RequestMapping(value="/car/deleteAuto/{carId}", method=RequestMethod.GET)
	public @ResponseBody int deleteCarDetailsById(@PathVariable("carId") String carId) {
		int rcount = carDetailsService.deleteCarDetailsById(carId);
		return rcount;
	}
}