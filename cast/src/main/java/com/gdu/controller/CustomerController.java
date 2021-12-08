package com.gdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
@GetMapping("/index")
public String index() {
	return "index.jsp";
}
}
