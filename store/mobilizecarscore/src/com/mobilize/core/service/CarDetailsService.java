package com.mobilize.core.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.CarDetailsMapper;
import com.mobilize.core.domain.value.CarDetailsVO;
import com.mobilize.core.domain.value.CarSummaryVO;


@Service("carDetailsService")

public class CarDetailsService {
	@Autowired
	private CarDetailsMapper carDetailsMapper;
	private static Logger logger = Logger.getLogger( CarDetailsService.class );

	public CarDetailsVO getCarDetailsByCarId(String carId) {
		CarDetailsVO carDetails = null;
		try{
			carDetails = carDetailsMapper.getCarDetailsByCarId(carId);
		}catch(Exception e){
			logger.info("Error while insertCarDetails"+e);
		}
		return carDetails;
	}
	
	public ArrayList<CarDetailsVO> getCarDetailsByUid(String uid) {
		ArrayList<CarDetailsVO>  carDetailsList = null; 
		try{
			carDetailsList = carDetailsMapper.getCarDetailsByUid(uid);
		}catch(Exception e){
			logger.info("Error while getCarDetailsByUid"+e);
		}
		return carDetailsList;
	}

	public ArrayList<CarSummaryVO> getCarsSummaryByUid(String uid) {
		ArrayList<CarSummaryVO>  carDetailsList = null; 
		try{
			List<String> list = new ArrayList<String>();
			list.add(uid);
			carDetailsList = carDetailsMapper.getCarSummaryByUserIds(list);
		}catch(Exception e){
			logger.info("Error while getCarDetailsByUid"+e);
		}
		return carDetailsList;
	}

	public ArrayList<CarDetailsVO> getCarDetailsByZip(String zip) {
		ArrayList<CarDetailsVO>  carDetailsList = null; 
		try{
			carDetailsList = carDetailsMapper.getCarDetailsByZip(zip);
			if(null == carDetailsList){
				carDetailsList = new ArrayList<CarDetailsVO>();
			}
		}catch(Exception e){
			logger.info("Error while getCarDetailsByZip"+e);
		}
		return carDetailsList;
	}
	public ArrayList<CarDetailsVO> getAllCarDetails() {
		ArrayList<CarDetailsVO>  carDetailsList = null; 
		try{
			carDetailsList =  carDetailsMapper.getAllCarDetails();
		}catch(Exception e){
			logger.info("Error while getAllCarDetails"+e);
		}
		return carDetailsList;
	}
	public int insertCarDetails(CarDetailsVO carDetailsVo){
		int retStatus = 0;
		try {
			retStatus = carDetailsMapper.insertCarDetails(carDetailsVo);
		}catch(Exception e){
			logger.info("Error while insertCarDetails"+e);
		}
		return retStatus;
	}
	public int deleteCarDetailsById(String carId){
		int retStatus = 0;
		try {
			retStatus = carDetailsMapper.deleteCarDetailsById( carId);
		}catch(Exception e){			
			logger.info("Error while deleteCarDetailsById"+e);
		}
		return retStatus;
	}
	public int updateCarDetailsById(CarDetailsVO carDetailsVo){
		int retStatus = 0;
		try {		
			retStatus = carDetailsMapper.updateCarDetailsById(carDetailsVo);
		}catch(Exception e){			
			logger.info("Error while updateCarDetailsById"+e);
		}
		return retStatus;
	}
}
