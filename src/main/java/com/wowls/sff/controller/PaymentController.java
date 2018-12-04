package com.wowls.sff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowls.sff.service.PaymentService;

@RestController
@RequestMapping("/payment/*")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
}
