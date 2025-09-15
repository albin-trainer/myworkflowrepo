package com.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
	@Autowired
private OrderService order;
	public String placeOrder() {
		return order.placeOrder("TShirt",1);
	}
}
