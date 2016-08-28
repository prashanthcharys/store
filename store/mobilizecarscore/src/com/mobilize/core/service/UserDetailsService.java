package com.mobilize.core.service;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.BuyerMapper;
import com.mobilize.core.data.SellerMapper;
import com.mobilize.core.data.UIDGenMapper;
import com.mobilize.core.data.UserMapper;
import com.mobilize.core.domain.value.LocationVO;
import com.mobilize.core.domain.value.UIDGenVO;
import com.mobilize.core.domain.value.UserDetailsVO;
import com.mobilize.core.domain.value.UserVO;
import com.mobilize.core.location.AddressTranslator;


@Service("userDetailsService")

public class UserDetailsService {

	@Autowired
	private UIDGenMapper uidGenMapper;
	private static Logger logger = Logger.getLogger(UserDetailsService.class);
	
	public static final String USER_TYPE_B = "B";
	//private static final String USER_TYPE_S = "S";

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BuyerMapper buyerMapper;

	@Autowired
	private SellerMapper sellerMapper;

	public List<UserDetailsVO> getAllUsersByType(String userType) {
		List<UserDetailsVO> userList = null;
		try {
			if (USER_TYPE_B.equalsIgnoreCase(userType)) {
				userList =  buyerMapper.getAllBuyers();
			} else {
				userList =  sellerMapper.getAllSellers();
			}
		} catch(Exception e) {
			logger.info("Error while getUserDetailsById:"+e);
		}
		return userList;
	}

	
	public UserDetailsVO getUserDetailsById(String userId, String userType) {
		UserDetailsVO userDetails = null;
		try {
			if (USER_TYPE_B.equalsIgnoreCase(userType)) {
				userDetails =  buyerMapper.getUserDetailsById(userId);
			} else {
				userDetails =  sellerMapper.getUserDetailsById(userId);
			}
		} catch(Exception e) {
			logger.info("Error while getUserDetailsById:"+e);
		}
		return userDetails;
	}
	
	public int insertUserDetails(UserDetailsVO userDetailsVo){
		int returnStatus = 0;
		UIDGenVO uidgen = uidGenMapper.getUIDObjByType("USER");
		String uid = "UID"+uidgen.getCount();
		uidgen.incrementCount();
		uidGenMapper.updateUIDObjById(uidgen);
		
		UserVO uservo = new UserVO();
		uservo.setUid(uid);
		uservo.setUserId(userDetailsVo.getUserId());
		uservo.setPassword(userDetailsVo.getPassword());
		uservo.setStatus("A");
		uservo.setUserType(userDetailsVo.getUserType());
		userMapper.insertUser(uservo);
		userDetailsVo.setUid(uid);
		try {
			updateLocation(userDetailsVo);
			if (USER_TYPE_B.equalsIgnoreCase(userDetailsVo.getUserType())) {
				returnStatus = buyerMapper.insertUserDetails(userDetailsVo);
			} else {
				returnStatus = sellerMapper.insertUserDetails(userDetailsVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.info("Error while insertUserDetails:"+e);
		}
		return returnStatus ;
	}
	
	public int deleteUserDetailsById(String userId, String userType){
		int returnStatus = 0;
		try {
			if (USER_TYPE_B.equalsIgnoreCase(userType)) {
				returnStatus = buyerMapper.deleteUserDetailsById(userId);
			} else {
				returnStatus = sellerMapper.deleteUserDetailsById(userId);
			}
		} catch(Exception e){
			logger.info("Error while deleteUserDetailsById:"+e);
		}
		return returnStatus ;
	}
	
	public int updateUserDetailsById(UserDetailsVO userDetailsVo){
		int rturnStatus = 0;
		try {
			updateLocation(userDetailsVo);
			if (USER_TYPE_B.equalsIgnoreCase(userDetailsVo.getUserType())) {
				rturnStatus = buyerMapper.updateUserDetailsById(userDetailsVo);
			} else {
				rturnStatus = sellerMapper.updateUserDetailsById(userDetailsVo);
			}
		} catch(Exception e){
			logger.info("Error while updateUserDetailsById:"+e);
		}
		return rturnStatus ;
	}
	
	public int updateLocation(LocationVO locVO){
		int rturnStatus = 0;
		try {
			if (USER_TYPE_B.equalsIgnoreCase(locVO.getUserType())) {
				rturnStatus = buyerMapper.updateLocation(locVO);
			} else {
				rturnStatus = sellerMapper.updateLocation(locVO);
			}
		} catch(Exception e){
			logger.info("Error while updateUserDetailsById:"+e);
		}
		return rturnStatus ;
	}

	public List<LocationVO> getLocations(String userType){
		List<LocationVO> locations = null;
		try {
			if (USER_TYPE_B.equalsIgnoreCase(userType)) {
				locations = buyerMapper.getLocations();
			} else {
				locations = sellerMapper.getLocations();
			}
		} catch(Exception e){
			logger.info("Error while updateUserDetailsById:"+e);
		}
		return locations ;
	}


	private void updateLocation(UserDetailsVO userDetailsVo) {
		try {
			if (userDetailsVo == null) return;
			ArrayList<LocationVO> list = AddressTranslator.getLatLongOnAddress(userDetailsVo.getAddress());
			if ((list != null) && (list.size() > 0)) {
				LocationVO loc = list.get(0);
				userDetailsVo.setLati(loc.getLatitude());
				userDetailsVo.setLongi(loc.getLongitude());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
