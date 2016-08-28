package com.mobilize.core.data;

import java.util.ArrayList;
import java.util.List;

import com.mobilize.core.domain.value.LocationVO;
import com.mobilize.core.domain.value.UserDetailsVO;

public interface SellerMapper {
	public ArrayList<UserDetailsVO> getAllSellers();
	public UserDetailsVO getUserDetailsById(String uid);
	public int updateUserDetailsById(UserDetailsVO userDetailsVo);
	public int deleteUserDetailsById(String uid);
	public int insertUserDetails(UserDetailsVO userDetailsVo);
	public int updateLocation(LocationVO locVO);
	public List<LocationVO> getLocations();
}
