package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomerController {
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/shop")
	public String shop() {
		return "shop";
	}
	@GetMapping("/contract")
	public String contract() {
		return "contract";
	}
	@GetMapping("/shopsingle")
	public String shopsingle() {
		return "shop-single";
	}
}
