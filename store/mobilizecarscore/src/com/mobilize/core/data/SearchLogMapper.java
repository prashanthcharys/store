package com.mobilize.core.data;

import com.mobilize.core.domain.value.SearchLogVO;



public interface SearchLogMapper {
	public SearchLogVO getSearchLogById(String id);
	public int updateSearchLogById(SearchLogVO searchLog);
	public int insertSearchLog(SearchLogVO searchLog);
	public int deleteSearchLogById(String carId);
}
