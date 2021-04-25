package com.sukumarc.razorpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.sukumarc.razorpay.config.RazorpayConfig;

@Service
public class RazopayServiceImpl implements RazopayService {
	
	 @Autowired
	 RazorpayConfig razorpayConfig;
	
	 private RazorpayClient razorpayClient;
	 private int amount = 500;

	 private String apiKey;
	 private String secretKey;
	 
	 @Override
	 public RazorpayClient getRazorpayClient() {
		 this.apiKey = razorpayConfig.getApikey();
		 this.secretKey = razorpayConfig.getSecretkey();
	     try {
			this.razorpayClient = new RazorpayClient(this.apiKey, this.secretKey);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return razorpayClient;
	 }

}
