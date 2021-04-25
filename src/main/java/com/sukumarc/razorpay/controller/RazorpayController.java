package com.sukumarc.razorpay.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.sukumarc.razorpay.service.RazopayService;

@RestController
@RequestMapping(value="razorpay")
public class RazorpayController {
	
	@Autowired
	RazopayService razopayService;
	
	@RequestMapping(value="/")
	public String getHome() {
		return "redirect:/index";
	}
	
	@RequestMapping(value="/index")
	public String getHomeInit() {
		return "index";
	}
	
	@PostMapping(value="order")
	public String createOrder() {
		
		JSONObject options = new JSONObject();
		options.put("amount", 30000);
		options.put("currency", "INR");
		options.put("receipt", "txn_java_123456");
		
		try {
			Order order = razopayService.getRazorpayClient().Orders.create(options);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}

}
