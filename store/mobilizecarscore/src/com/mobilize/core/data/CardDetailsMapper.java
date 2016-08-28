package com.mobilize.core.data;

import java.util.List;

import com.mobilize.core.domain.value.CardDetailsVO;

public interface CardDetailsMapper {
	public List<CardDetailsVO> getCardDetailsById(String uid);
	public CardDetailsVO getCardDetailsByCardNumber(String cardNumber);
	public int updateCardDetailsById(CardDetailsVO cardDetailsVo);
	public int insertCardDetails(CardDetailsVO cardDetailsVo);
	public int deleteCardDetailsByCardNumber(String cardNumber);
}
