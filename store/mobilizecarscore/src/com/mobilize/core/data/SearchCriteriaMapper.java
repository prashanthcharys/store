package com.mobilize.core.data;

import java.util.List;

import com.mobilize.core.domain.value.SearchCriteriaVO;


public interface SearchCriteriaMapper {
	public List<SearchCriteriaVO> getSearchCriteriaByUid(String uid);
	public SearchCriteriaVO getSearchCriteriaByCriteriaId(String criteriaId);
	public int insertSearchCriteria(SearchCriteriaVO searchCriteriaVO);
	public int updateSearchCriteriaById(SearchCriteriaVO searchCriteriaVO);
	public int deleteSearchCriteriaById(String uid);
}
