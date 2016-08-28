package com.mobilize.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.BuyerCriteriaMapper;
import com.mobilize.core.domain.value.BaseVO;
import com.mobilize.core.domain.value.BuyerCriteriaSummaryVO;
import com.mobilize.core.domain.value.BuyerCriteriaVO;

@Service("buyerCriteriaService")
public class BuyerCriteriaService {
	
	@Autowired
	private BuyerCriteriaMapper buyerCriteriaMapper;
	private static Logger logger = Logger.getLogger(BuyerCriteriaService.class );

	public List<BuyerCriteriaVO> getBuyerCriteriaById(String uid) {
		List<BuyerCriteriaVO>  buyerCriteriaList = null; 
		try {
			buyerCriteriaList = buyerCriteriaMapper.getBuyerCriteriaById(uid);
		} catch(Exception e){
			logger.info("Error while getBuyerCriteriaById"+e);
		}
		return buyerCriteriaList;
	}
	
	public List<BuyerCriteriaSummaryVO> getBuyerCriteriaSummaryById(String uid) {
		List<BuyerCriteriaSummaryVO>  buyerCriteriaList = null; 
		try {
			buyerCriteriaList = buyerCriteriaMapper.getBuyerCriteriaSummaryById(uid);
		} catch(Exception e){
			logger.info("Error while getBuyerCriteriaById"+e);
		}
		return buyerCriteriaList;
	}
	
	public BuyerCriteriaVO getBuyerCriteriaByCritId(BaseVO basevo) {
		BuyerCriteriaVO  buyerCriteria = null; 
		try {
			buyerCriteria = buyerCriteriaMapper.getBuyerCriteriaByCritId(basevo);
		} catch(Exception e){
			logger.info("Error while getBuyerCriteriaByCritId"+e);
		}
		return buyerCriteria;
	}
	
	public int insertBuyerCriteria(BuyerCriteriaVO buyerCriteriaVO) {
		int retStatus = 0;
		try {
			
			retStatus = buyerCriteriaMapper.insertBuyerCriteria(buyerCriteriaVO);
		}catch(Exception e){
			logger.info("Error while insertBuyerCriteria"+e);
		}
		return retStatus;
	}
	
	public int updateBuyerCriteria(BuyerCriteriaVO buyerCriteriaVO) {
		int retStatus = 0;
		try {
			retStatus = buyerCriteriaMapper.updateBuyerCriteria(buyerCriteriaVO);
		}catch(Exception e){
			logger.info("Error while updateBuyerCriteria"+e);
		}
		return retStatus;

	}
	
	public int deleteBuyerCriteriaById(String uid) {
		int retStatus = 0;
		try {
			retStatus = buyerCriteriaMapper.deleteBuyerCriteriaById(uid);
		}catch(Exception e){
			logger.info("Error while deleteBuyerCriteriaById"+e);
		}
		return retStatus;
	}
	
	public int deleteBuyerCriteriaByCritId(BuyerCriteriaSummaryVO userCriteriavo) {
		int retStatus = 0;
		try {
			retStatus = buyerCriteriaMapper.deleteBuyerCriteriaByCritId(userCriteriavo);
		}catch(Exception e){
			logger.info("Error while deleteBuyerCriteriaByCritId"+e);
		}
		return retStatus;
	}
}
