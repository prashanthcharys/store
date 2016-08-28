package com.mobilize.core.service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.PaymentDetailsMapper;
import com.mobilize.core.domain.value.PaymentDetailsVO;


@Service("paymentDetailsService")

public class PaymentDetailsService {
	@Autowired
	private PaymentDetailsMapper paymentDetailsMapper;
	private static Logger logger = Logger.getLogger( PaymentDetailsService.class );


	public List<PaymentDetailsVO> getPaymentDetailsById(String uid) {
		List<PaymentDetailsVO> paymentDetailsList = null;
		try{
			paymentDetailsList =  paymentDetailsMapper.getPaymentDetailsById(uid);
		}catch(Exception e){
			logger.info("Error while getPaymentDetailsById"+e);
		}
		return paymentDetailsList;
	}
	public int insertPaymentDetails(PaymentDetailsVO paymentDetailsVO){
		int retStatus = 0;
		try{
			retStatus = paymentDetailsMapper.insertPaymentDetails(paymentDetailsVO);
		}catch(Exception e){
			logger.info("Error while insertPaymentDetails"+e);
		}
		return retStatus;
	}
	public int deletePaymentDetailsById(PaymentDetailsVO paymentDetailsVO){		
		int retStatus = 0;
		try{
			retStatus = paymentDetailsMapper.deletePaymentDetailsById(paymentDetailsVO);
		}catch(Exception e){
			logger.info("Error while deletePaymentDetailsById"+e);
		}
		return retStatus;
	}
	public int updatePaymentDetailsById(PaymentDetailsVO paymentDetailsVO){
		int retStatus = 0;
		try{
			retStatus = paymentDetailsMapper.updatePaymentDetailsById(paymentDetailsVO);
		}catch(Exception e){
			logger.info("Error while updatePaymentDetailsById"+e);
		}
		return retStatus;

	}
}
