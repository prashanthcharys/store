package com.mobilize.core.service;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.SellerMapper;
import com.mobilize.core.domain.value.UserDetailsVO;


@Service("sellerService")

public class SellerService {
	@Autowired
	private SellerMapper sellerMapper;
	private static Logger logger = Logger.getLogger( SellerMapper.class );


	public ArrayList<UserDetailsVO> getAllSellers() {
		ArrayList<UserDetailsVO>  sellerList = null; 
		try{
			sellerList = sellerMapper.getAllSellers();
		}catch(Exception e){
			logger.info("Error while getAllSellers"+e);
		}
		return sellerList;
	}

}
