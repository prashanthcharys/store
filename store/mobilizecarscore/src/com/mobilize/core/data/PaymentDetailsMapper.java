package com.mobilize.core.data;

import java.util.List;

import com.mobilize.core.domain.value.PaymentDetailsVO;

public interface PaymentDetailsMapper {
	public List<PaymentDetailsVO> getPaymentDetailsById(String uid);
	public int updatePaymentDetailsById(PaymentDetailsVO paymentDetailsVO);
	public int insertPaymentDetails(PaymentDetailsVO paymentDetailsVO);
	public int deletePaymentDetailsById(PaymentDetailsVO paymentDetailsVO);
}
