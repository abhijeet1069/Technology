package com.satyam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
}
