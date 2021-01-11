package net.springboot.demo.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.MyAsync.AsyncTask;
import net.springboot.demo.domain.JsonData;

@RestController
@RequestMapping("/v1/Async")
public class AsyncController {
	
	@Autowired
	private AsyncTask asyncTask;
	
	@GetMapping("testAsync")
	public JsonData asyncTest() throws InterruptedException {
		
		long begin = System.currentTimeMillis();
		asyncTask.task1();
		
		
//		asyncTask.task2();
//		asyncTask.task3();
		
		Future<String> task2 = asyncTask.task2();
		Future<String> task3 = asyncTask.task3();
		for (; ; ) {
			if (task2.isDone() && task3.isDone()) {
				break;
			}
		}
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("total time are cost :>>" + (end - begin ));
		return JsonData.buildSuccess((end - begin ));
		
	}
}
