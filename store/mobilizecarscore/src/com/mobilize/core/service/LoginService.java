package com.mobilize.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.UIDGenMapper;
import com.mobilize.core.data.UserMapper;
import com.mobilize.core.domain.value.UIDGenVO;
import com.mobilize.core.domain.value.UserVO;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UIDGenMapper uidGenMapper;

	private static Logger logger = Logger.getLogger( CarDetailsService.class );

	public UserVO getUserById(String userId) {
		UserVO user = null;
		try{
			user = userMapper.getUserById(userId);
		}catch(Exception e){
			logger.info("Error while insertUser"+e);
		}
		return user;
	}

	public boolean validateUser(String userId,String passWord){
		UserVO userVo = userMapper.getUserById(userId);

		if(userVo != null && userVo.getUserId().equals(userId) && userVo.getPassword().equals(passWord)){
			return true;			
		}else{
			return false;
		}

	}
	
	public int updateUser(UserVO userVo){
		int row = 0;
		try{
			row = userMapper.updateUser(userVo);
		}catch(Exception e){
			logger.info("Error while insertUser"+e);
		}
		return row;
	}
	
	public int deleteUser(UserVO userVo){
		int row = 0;
		try{
			row = userMapper.deleteUser(userVo);
		}catch(Exception e){
			logger.info("Error while insertUser"+e);
		}
		return row;
	}
	
	public int insertUser(UserVO userVo){
		int row = 0;
		try {
			UIDGenVO uidgen = uidGenMapper.getUIDObjByType("USER");
			String uid = "UID"+uidgen.getCount();
			userVo.setUid(uid);
			row = userMapper.insertUser(userVo);
		} catch(Exception e){
			logger.info("Error while insertUser"+e);
		}
		return row;
	}
	
	public List<UserVO> getUsers(String id){
		return userMapper.getUsers(id);
	}
}
