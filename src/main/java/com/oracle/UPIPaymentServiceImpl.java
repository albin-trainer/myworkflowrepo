package com.oracle;

import org.springframework.stereotype.Component;

@Component
public class UPIPaymentServiceImpl implements PaymentService {
	public String processPayment(double amount) {
	return ("UPI Payment of "+amount+" is proccessed");
	}

}
