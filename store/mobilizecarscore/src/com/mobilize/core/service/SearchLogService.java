package com.mobilize.core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilize.core.data.SearchLogMapper;
import com.mobilize.core.domain.value.SearchLogVO;


@Service("searchLogService")

public class SearchLogService {
	@Autowired
	private SearchLogMapper searchLogMapper;
	
	public SearchLogVO getSearchLogById(String carId) {
		return searchLogMapper.getSearchLogById(carId);
	}
	public int insertSearchLog(SearchLogVO searchLogVo){
		return searchLogMapper.insertSearchLog(searchLogVo);
	}
	public int deleteSearchLogById(String carId){
		return searchLogMapper.deleteSearchLogById(carId);
	}
	public int updateSearchLogById(SearchLogVO searchLogVo){
		return searchLogMapper.updateSearchLogById(searchLogVo);
	}
}
