package com.mobilize.core.service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.CardDetailsMapper;
import com.mobilize.core.domain.value.CardDetailsVO;


@Service("cardDetailsService")

public class CardDetailsService {
	@Autowired
	private CardDetailsMapper cardDetailsMapper;
	private static Logger logger = Logger.getLogger( CardDetailsService.class );

	public List<CardDetailsVO> getCardDetailsById(String uid) {
		List<CardDetailsVO>  carDettailsList = null;
		try{
			carDettailsList = cardDetailsMapper.getCardDetailsById(uid);
		}catch(Exception e){
			logger.info("Error while getCardDetailsById  service:" + e );
		}
		return carDettailsList;
	}
	public CardDetailsVO getCardDetailsByCardNumber(String cardNumber) {
		CardDetailsVO  carDettails = null;
		try{
			carDettails = cardDetailsMapper.getCardDetailsByCardNumber(cardNumber);
		}catch(Exception e){
			//logger.info("Error while getCardDetailsByCardNumber service:" + e );
			
			logger.error("Error while getCardDetailsByCardNumber service:" + e );
		}
		return carDettails;
	}
	public int insertCardDetails(CardDetailsVO cardDetailsVo){
		int returnStatus = 0;
		try{
			returnStatus = cardDetailsMapper.insertCardDetails(cardDetailsVo);
		}catch(Exception e){
			logger.info("Error while insertCardDetails:" + e );
		}
		return returnStatus;
	}
	public int deleteCardDetailsById(String cardNumber){
		//return cardDetailsMapper.deleteCardDetailsByCardNumber(cardNumber);
		int retStatus = 0;
		try {	
			retStatus = cardDetailsMapper.deleteCardDetailsByCardNumber(cardNumber);
		}catch(Exception e){
			logger.info("Error while deleteCardDetailsById:" + e );
		}
		return retStatus;
	}
	public int updateCardDetailsById(CardDetailsVO cardDetailsVo){
		int retStatus = 0;
		try {	
			retStatus = cardDetailsMapper.updateCardDetailsById(cardDetailsVo);
		}catch(Exception e){
			logger.info("Error while updateCardDetailsById:" + e );
		}
		return retStatus;
	}
}
