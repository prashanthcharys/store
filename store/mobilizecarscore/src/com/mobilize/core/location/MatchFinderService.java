package com.mobilize.core.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.CarDetailsMapper;
import com.mobilize.core.domain.value.CarSummaryVO;
import com.mobilize.core.domain.value.LocationVO;
import com.mobilize.core.service.UserDetailsService;

@Service("matchFinderService")
public class MatchFinderService {
	
	private static final double PREP_DIST = 100.00;
	
	@Autowired
	private CarDetailsMapper carDetailsMapper;
	
	@Autowired
	private UserDetailsService userDetailsService;

	public static void main(String args[]) {
		//40.714224,-73.961452
		//LocationServiceClient.getZipCodesByLatLng(40.714224, -73.961452);
		LocationVO locvo = new LocationVO();
		locvo.setLatitude(40.714224);
		locvo.setLongitude(-73.961452);
		
		MatchFinderService find = new MatchFinderService();
		find.getCarsForLocation1(locvo);		
	}
	
	public ArrayList<CarSummaryVO> getCarsForLocation1(LocationVO locvo) {
		// 1:  update database
		
		//USER_TYPE_B
		
		// 2:  find zip codes for that location
		
		//https://maps.googleapis.com/maps/api/geocode/output?parameters
		
		// 3:  find neibouring zipcodes.
		List list = LocationServiceClient.getZipCodesByLatLng(locvo.getLatitude(), locvo.getLongitude());
		
		StringBuffer buffer = new StringBuffer();
		int size = list.size() - 1;
		if (size > 0) {
			buffer.append("(");
			for (int i=0; i<size; i++) {
				buffer.append("'"+list.get(i)+"'");
				if (i < size) {
					buffer.append(",");
				}
			}
			buffer.append(")");
		}
		System.out.println(buffer.toString());
		// 4:  find sellers in that zip code area
		ArrayList<CarSummaryVO> carsList = carDetailsMapper.getCarSummaryByZipCodes(buffer.toString());
		
		return carsList;
	}
	
	public ArrayList<CarSummaryVO> getCarsForLocation(LocationVO locVO) {
		// 1:  update database
		userDetailsService.updateLocation(locVO);
		
		// 2:  find locations
		List<LocationVO> locList = userDetailsService.getLocations(locVO.getUserType());
		Map<String, LocationVO> matchMap = new HashMap<String, LocationVO>();
		// 3:  calculate distance
		StringBuffer buffer = new StringBuffer();
		//buffer.append("(");
		int cnt = 0;
		List<String> uidList = new ArrayList<String>();
		for (int i=0; i<locList.size(); i++) {
			LocationVO vo = locList.get(i);
			double dist = DistanceCalculator.distance(locVO.getLatitude(), locVO.getLongitude(), vo.getLatitude(), vo.getLongitude(), 'M');
			if (dist < PREP_DIST) {
				if (cnt > 0) {
					buffer.append(",");
				}
				//buffer.append("'"+vo.getUserId()+"'");
				buffer.append("'"+vo.getUserId()+"'");
				uidList.add(vo.getUserId());
				matchMap.put(vo.getUserId(), vo);
			}
			cnt++;
		}
		//buffer.append(")");		
		// 4:  find sellers in that zip code area
		ArrayList<CarSummaryVO> carsList = carDetailsMapper.getCarSummaryByUserIds(uidList);
		for (int i=0; i<carsList.size(); i++) {
			CarSummaryVO carsum = carsList.get(i);
			LocationVO locationVO = matchMap.get(carsum.getUid());
			if (locationVO != null) {
				carsum.setLatitude(locationVO.getLatitude());
				carsum.setLongitude(locationVO.getLongitude());
			}
		}
		
		return carsList;
	}	
}
