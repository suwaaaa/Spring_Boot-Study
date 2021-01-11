package net.springboot.demo.domain;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExcepyionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomExcepyionHandler.class);

	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	Object handException(Exception e,HttpServletRequest request) {
		
		
		
		
		
		Map<String, Object> map = new HashMap<>();
		
		LOGGER.error("url:{}, mes:{} ", request.getRequestURI(), e.getMessage());
		
		map.put("code", 100);
		map.put("mes", e.getMessage());
		map.put("url", request.getRequestURI());
		
		return map;
		
	}
	
	
	@ExceptionHandler(value=MyExecption.class)
	Object HandleMyException(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error.html");
		modelAndView.addObject("msg", e.getMessage());
		
		return modelAndView;
	}
	
 
	
}
