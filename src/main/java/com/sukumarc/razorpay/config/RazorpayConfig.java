package com.sukumarc.razorpay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
	
	@Value("${apikey}")
	private String apikey;
	
	@Value("${secretkey}")
	private String secretkey;
	
	public String getApikey() {
		return apikey;
	}

	public String getSecretkey() {
		return secretkey;
	}

}
