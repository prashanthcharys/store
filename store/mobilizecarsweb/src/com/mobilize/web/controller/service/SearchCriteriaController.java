package com.mobilize.web.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.SearchCriteriaVO;
import com.mobilize.core.service.SearchCriteriaService;

@Controller
public class SearchCriteriaController {

	@Autowired
	private SearchCriteriaService searchCriteriaService;
	
	
	@RequestMapping(value="/searchCriteria/getSearchCriteriaByUid/{uid}", method=RequestMethod.GET)
	@ResponseBody
	public List<SearchCriteriaVO> getSearchCriteriaByUid(@PathVariable("uid") String uid) {
		System.out.println("User ID received : " + uid );
		List<SearchCriteriaVO> searchCriteriaVO = searchCriteriaService.getSearchCriteriaByUid(uid);
		return searchCriteriaVO;
	}
	
	@RequestMapping(value="/searchCriteria/getSearchCriteriaByCriteriaId/{criteriaId}", method=RequestMethod.GET)
	@ResponseBody
	public SearchCriteriaVO getSearchCriteriaByCriteriaId(@PathVariable("criteriaId") String criteriaId) {
		System.out.println("User ID received : " + criteriaId );
		SearchCriteriaVO searchCriteriaVO = searchCriteriaService.getSearchCriteriaByCriteriaId(criteriaId);
		return searchCriteriaVO;
	}	

	@RequestMapping(value="/searchCriteria/addSearchCriteria", method=RequestMethod.POST)
	public @ResponseBody int addSearchCriteria(@RequestBody SearchCriteriaVO searchCriteriaVO) {
		int rcount = searchCriteriaService.insertSearchCriteria(searchCriteriaVO);
		return rcount;
	}
	
	@RequestMapping(value="/searchCriteria/updateSearchCriteria", method=RequestMethod.POST)
	public @ResponseBody int updateSearchCriteria(@RequestBody SearchCriteriaVO searchCriteriaVO) {
		int rcount = searchCriteriaService.updateSearchCriteriaById(searchCriteriaVO);
		return rcount;
	}

	@RequestMapping(value="/searchCriteria/deleteSearchCriteria/{uid}", method=RequestMethod.GET)
	public @ResponseBody int deleteSearchCriteria(@PathVariable("uid") String uid) {
		int rcount = searchCriteriaService.deleteSearchCriteriaById(uid);
		return rcount;
	}
}
