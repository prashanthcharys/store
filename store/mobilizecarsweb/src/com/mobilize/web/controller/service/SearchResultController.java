package com.mobilize.web.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.data.SearchLogMapper;
import com.mobilize.core.domain.value.SearchLogVO;

@Controller
public class SearchResultController {

	//@Autowired
	//private SearchLogService searchLogService;

	@Autowired
	private SearchLogMapper searchLogService;

	@RequestMapping(value="/user/getUserSearch/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public SearchLogVO getSearchLogById(@PathVariable("userId") String userId) {
		System.out.println("User ID received : " + userId );
		SearchLogVO searchLogVO = searchLogService.getSearchLogById(userId);
		return searchLogVO;
	}

	@RequestMapping(value="/user/addUserSearch", method=RequestMethod.POST)
	public @ResponseBody int addSearchLog(@RequestBody SearchLogVO searchLogVO) {
		int rcount = searchLogService.insertSearchLog(searchLogVO);
		return rcount;
	}

	@RequestMapping(value="/user/updateUserSearch", method=RequestMethod.POST)
	public @ResponseBody int updateSearchLog(@RequestBody SearchLogVO searchLogVO) {
		int rcount = searchLogService.updateSearchLogById(searchLogVO);
		return rcount;
	}

	/** Search Deletion should not be allowed  **/
	@RequestMapping(value="/user/deleteUserSearch/{searchCriteriaId}", method=RequestMethod.GET)
	private @ResponseBody int deleteSearchLogById(@PathVariable("searchCriteriaId") String searchCriteriaId) {
		int rcount = searchLogService.deleteSearchLogById(searchCriteriaId);
		return rcount;
	}
}
