package net.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class SSEController {
	
	
	@GetMapping(value = "/sse",produces = "text/event-stream;charset=UTF-8")
	public String testSSE() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "data: change at : " + Math.random() ; 
	}
}
