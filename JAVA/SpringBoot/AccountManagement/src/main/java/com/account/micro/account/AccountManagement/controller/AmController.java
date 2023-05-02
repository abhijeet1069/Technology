package com.account.micro.account.AccountManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AmController {
	@GetMapping("/check")
	public String check() {
		return "Hey Good Morning!!";
	}
}
