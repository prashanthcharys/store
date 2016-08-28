package com.mobilize.core.data;

import com.mobilize.core.domain.value.UserDetailsVO;

public interface UserDetailsMapper {
	public UserDetailsVO getUserDetailsById(String uid);
	public int updateUserDetailsById(UserDetailsVO userDetailsVo);
	public int deleteUserDetailsById(String uid);
	public int insertUserDetails(UserDetailsVO userDetailsVo);
}
