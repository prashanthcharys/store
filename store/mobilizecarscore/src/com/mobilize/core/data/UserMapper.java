package com.mobilize.core.data;

import java.util.List;

import com.mobilize.core.domain.value.UserVO;

public interface UserMapper {
	public UserVO getUserById(String id);
	public List<UserVO> getUsers(String id);
	public int updateUser(UserVO userVo);
	public int deleteUser(UserVO userVo);
	public int insertUser(UserVO userVo);
}
