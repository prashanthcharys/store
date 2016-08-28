package com.mobilize.web.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.BaseVO;
import com.mobilize.core.domain.value.BuyerCriteriaSummaryVO;
import com.mobilize.core.domain.value.BuyerCriteriaVO;
import com.mobilize.core.service.BuyerCriteriaService;

@Controller
public class UserCriteriaController {

	@Autowired
	private BuyerCriteriaService userCriteriaService;
		
	@RequestMapping(value="/userCriteria/getUserCriteriaByUserId", method=RequestMethod.POST)
	public @ResponseBody List<BuyerCriteriaSummaryVO> getAutoDetailsByUserId(@RequestBody BaseVO baseVO) {
		List<BuyerCriteriaSummaryVO> userCriteriaList = userCriteriaService.getBuyerCriteriaSummaryById(baseVO.getUid());
		return userCriteriaList;
	}

	@RequestMapping(value="/userCriteria/getUserCriteriaByCritId", method=RequestMethod.POST)
	public @ResponseBody BuyerCriteriaVO getCarDetailsByCarId(@RequestBody BaseVO baseVO) {
		BuyerCriteriaVO userCriteria = userCriteriaService.getBuyerCriteriaByCritId(baseVO);
		return userCriteria;
	}

	@RequestMapping(value="/userCriteria/addUserCriteria", method=RequestMethod.POST)
	public @ResponseBody int addUser(@RequestBody BuyerCriteriaVO userCriteria) {
		int rcount = userCriteriaService.insertBuyerCriteria(userCriteria);
		return rcount;
	}
	
	@RequestMapping(value="/userCriteria/updateUserCriteria", method=RequestMethod.POST)
	public @ResponseBody int updateUserCriteria(@RequestBody BuyerCriteriaVO userCriteriaVO) {
		int rcount = userCriteriaService.updateBuyerCriteria(userCriteriaVO);
		return rcount;
	}

	@RequestMapping(value="/userCriteria/deleteUserCriteriaById", method=RequestMethod.POST)
	public @ResponseBody int deleteUserCriteriaById(@RequestBody BuyerCriteriaSummaryVO userCriteriavo) {
		int cnt = userCriteriaService.deleteBuyerCriteriaById(userCriteriavo.getUid());
		return cnt;
	}

	@RequestMapping(value="/userCriteria/deleteUserCriteriaByCritId", method=RequestMethod.POST)
	public @ResponseBody int deleteUserCriteriaByCritId(@RequestBody BuyerCriteriaSummaryVO userCriteriavo) {
		int cnt = userCriteriaService.deleteBuyerCriteriaByCritId(userCriteriavo);
		return cnt; 
	}
}
