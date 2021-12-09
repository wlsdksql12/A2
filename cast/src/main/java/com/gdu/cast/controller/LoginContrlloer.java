package com.gdu.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginContrlloer {

	@GetMapping("/loginSelect")
	public String loginSelect() {
		return "loginSelect";
	}
}
