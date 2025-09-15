package com.oracle;
import java.util.HashMap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class OrderServiceImpl  implements OrderService{
   private HashMap<String, Float> products=new HashMap<>();
   {
	   products.put("TShirt", 1000.0f);
	   products.put("Mobile", 15000f);
	   products.put("Shoes", 2500.99f);
	   products.put("Laptop", 50000f);
   }
   @Autowired
  // @Qualifier("getUPI")
    private PaymentService paymentService;
	@Override 
	//client will call this fn
	public String placeOrder(String product, int quantity) {
		//calculate the price & invoke the payment service
		if(products.containsKey(product))
			return paymentService.processPayment(products.get(product)*quantity);
		else
			return ("Not a valid product");
	}

}
