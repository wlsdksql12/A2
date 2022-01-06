package com.gdu.cast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.cast.mapper.CeoMapper;

public class CeoChartController {
	@Autowired CeoMapper ceoMapper;
	

	@GetMapping("/getCeoExperienceChart")
	public String getCeoExperienceChart() {
		return "/ExperienceChart";
	}
}
