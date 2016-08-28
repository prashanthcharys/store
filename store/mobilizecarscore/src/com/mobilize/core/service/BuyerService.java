package com.mobilize.core.service;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.BuyerMapper;
import com.mobilize.core.domain.value.UserDetailsVO;


@Service("buyerService")

public class BuyerService {
	@Autowired
	private BuyerMapper buyerMapper;
	private static Logger logger = Logger.getLogger( BuyerMapper.class );


	public ArrayList<UserDetailsVO> getAllBuyers() {
		ArrayList<UserDetailsVO>  buyerList = null; 
		try{
			buyerList = buyerMapper.getAllBuyers();
		}catch(Exception e){
			logger.info("Error while getAllBuyers"+e);
			
			logger.debug("Error while getAllBuyers"+e);
			
			logger.fatal("Error while getAllBuyers"+e);
		}
		return buyerList;
	}

}
