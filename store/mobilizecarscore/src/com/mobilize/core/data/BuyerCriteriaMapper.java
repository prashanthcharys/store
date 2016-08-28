package com.mobilize.core.data;

import java.util.List;

import com.mobilize.core.domain.value.BaseVO;
import com.mobilize.core.domain.value.BuyerCriteriaSummaryVO;
import com.mobilize.core.domain.value.BuyerCriteriaVO;

public interface BuyerCriteriaMapper {
	public List<BuyerCriteriaVO> getBuyerCriteriaById(String uid);
	public BuyerCriteriaVO getBuyerCriteriaByCritId(BaseVO basevo);
	public List<BuyerCriteriaSummaryVO> getBuyerCriteriaSummaryById(String uid);
	public int insertBuyerCriteria(BuyerCriteriaVO buyerCriteriaVO);
	public int updateBuyerCriteria(BuyerCriteriaVO buyerCriteriaVO);
	public int deleteBuyerCriteriaById(String uid);
	public int deleteBuyerCriteriaByCritId(BuyerCriteriaSummaryVO userCriteriavo);
}
