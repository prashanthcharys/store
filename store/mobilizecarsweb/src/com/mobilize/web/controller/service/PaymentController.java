package com.mobilize.web.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobilize.core.data.PaymentDetailsMapper;
import com.mobilize.core.domain.value.PaymentDetailsVO;

@Controller
public class PaymentController {

	//@Autowired
	//private PaymentDetailsService paymentDetailsService;
	
	@Autowired
	private PaymentDetailsMapper paymentDetailsService;
	
	@RequestMapping(value="/payment/getPayment/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public List<PaymentDetailsVO> getPaymentDetailsById(@PathVariable("userId") String userId) {
		System.out.println("User ID received : " + userId );
		List<PaymentDetailsVO> paymentDetailsVO = paymentDetailsService.getPaymentDetailsById(userId);
		return paymentDetailsVO;
	}

	@RequestMapping(value="/payment/addPayment", method=RequestMethod.POST)
	public @ResponseBody int insertPaymentDetails(@RequestBody PaymentDetailsVO paymentDetailsVO) {
		int rcount = paymentDetailsService.insertPaymentDetails(paymentDetailsVO);
		return rcount;
	}
	
	@RequestMapping(value="/payment/updatePayment", method=RequestMethod.POST)
	public @ResponseBody int updatePaymentDetailsById(@RequestBody PaymentDetailsVO paymentDetailsVO) {
		int rcount = paymentDetailsService.updatePaymentDetailsById(paymentDetailsVO);
		return rcount;
	}

	@RequestMapping(value="/payment/deletePayment", method=RequestMethod.POST)
	public @ResponseBody int deletePaymentDetailsById(@RequestBody PaymentDetailsVO paymentDetailsVO) {
		int rcount = paymentDetailsService.deletePaymentDetailsById(paymentDetailsVO);
		return rcount;
	}
}
