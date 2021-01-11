package net.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.demo.domain.ServerSetting;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {

	@Autowired
	private ServerSetting setting;
	
	@GetMapping(value = "/tl")
	
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("thymeleaf", setting);
		
		return "ty";
	}
}
