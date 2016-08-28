package com.mobilize.core.service;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.SearchCriteriaMapper;
import com.mobilize.core.domain.value.SearchCriteriaVO;


@Service("searchCriteriaService")
public class SearchCriteriaService {
	@Autowired
	private SearchCriteriaMapper searchCriteriaMapper;
	private static Logger logger = Logger.getLogger( SearchCriteriaService.class );

	public List<SearchCriteriaVO> getSearchCriteriaByUid(String uid) {
		List<SearchCriteriaVO> searchCriteriaList = null;
		try{
			searchCriteriaList =  searchCriteriaMapper.getSearchCriteriaByUid(uid);
		}catch(Exception e){
			logger.info("Error whiel getting Search Criteria by uid:"+e);
		}
		return searchCriteriaList;
	}
	public SearchCriteriaVO getSearchCriteriaByCriteriaId(String criteriaId) {
		SearchCriteriaVO searchCriteriaVO = null;
		try{
			searchCriteriaVO =  searchCriteriaMapper.getSearchCriteriaByCriteriaId(criteriaId);
		}catch(Exception e){
			logger.info("Error whiel getting Search Criteria by Criteria ID:"+e);
		}
		return searchCriteriaVO;
	}
	public int insertSearchCriteria(SearchCriteriaVO searchCriteriaVo){
		int returnStatus = 0;
		try{		
			returnStatus =  searchCriteriaMapper.insertSearchCriteria(searchCriteriaVo);
		}catch(Exception e){			
			logger.info("Error whiel inserting Search Criteria"+e);
		}
		return returnStatus;
	}
	public int deleteSearchCriteriaById(String carId){
		int returnStatus = 0;
		try{
			returnStatus =  searchCriteriaMapper.deleteSearchCriteriaById(carId);
		}catch(Exception e){			
			logger.info("Error whiel deleting Search Criteria"+e);
		}
		return returnStatus;
	}
	public int updateSearchCriteriaById(SearchCriteriaVO searchCriteriaVo){
		int returnStatus = 0;
		try{
			returnStatus = searchCriteriaMapper.updateSearchCriteriaById(searchCriteriaVo);
		}catch(Exception e){			
			logger.info("Error whiel updating Search Criteria"+e);
		}
		return returnStatus;
	}
}
