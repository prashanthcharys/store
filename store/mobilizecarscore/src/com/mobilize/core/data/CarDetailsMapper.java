package com.mobilize.core.data;

import java.util.ArrayList;
import java.util.List;

import com.mobilize.core.domain.value.CarDetailsVO;
import com.mobilize.core.domain.value.CarSummaryVO;

public interface CarDetailsMapper {
	public ArrayList<CarDetailsVO> getAllCarDetails();
	public ArrayList<CarDetailsVO> getCarDetailsByUid(String uid);
	public ArrayList<CarDetailsVO> getCarDetailsByZip(String zip);
	public ArrayList<CarSummaryVO> getCarSummaryByZipCodes(String zips);
	public ArrayList<CarSummaryVO> getCarSummaryByUserIds(List<String> uidList);
	public CarDetailsVO getCarDetailsByCarId(String careId);
	public int updateCarDetailsById(CarDetailsVO carDetailsVo);
	public int deleteCarDetailsById(String id);
	public int insertCarDetails(CarDetailsVO carDetailsVo);

}
