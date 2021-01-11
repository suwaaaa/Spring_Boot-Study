package net.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springboot.demo.domain.ServerSetting;

@Controller
@RequestMapping(value = "/free")
public class FreeMarkerController {
	
	@Autowired 
	private ServerSetting serverSetting;
	
	@GetMapping(value = "/getPage")
	public String  DoFreeMarker(ModelMap modelMap) { 
		
		modelMap.addAttribute("setting:",serverSetting);
		//modelMap.addAttribute("name", "suwaaaa");
		
		return "freemarker/freemarker";
		
		
	}
	
	
	
	
}
