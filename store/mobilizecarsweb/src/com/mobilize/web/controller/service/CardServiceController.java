package com.mobilize.web.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.domain.value.CardDetailsVO;
import com.mobilize.core.service.CardDetailsService;

@Controller
public class CardServiceController {
	@Autowired
	private CardDetailsService cardService;

	@RequestMapping(value="/card/getCard/{cardNumber}", method=RequestMethod.GET)
	@ResponseBody
	public CardDetailsVO getCardDetails(@PathVariable("cardNumber") String cardNumber) {
		CardDetailsVO cardDetails = cardService.getCardDetailsByCardNumber(cardNumber);
		return cardDetails;
	}

	@RequestMapping(value="/card/addCard", method=RequestMethod.POST)
	public @ResponseBody int addCardDetails(@RequestBody CardDetailsVO cardDetails) {
		int rcount = cardService.insertCardDetails(cardDetails);
		return rcount;
	}

	@RequestMapping(value="/card/updateCard", method=RequestMethod.POST)
	public @ResponseBody int updateCardDetails(@RequestBody CardDetailsVO cardDetails) {
		int rcount = cardService.updateCardDetailsById(cardDetails);
		return rcount;
	}

	@RequestMapping(value="/card/deleteCard/{cardNumber}", method=RequestMethod.GET)
	public @ResponseBody int deleteCardDetails(@PathVariable("cardNumber") String cardNumber) {
		int rcount = cardService.deleteCardDetailsById(cardNumber);
		return rcount;
	}
}