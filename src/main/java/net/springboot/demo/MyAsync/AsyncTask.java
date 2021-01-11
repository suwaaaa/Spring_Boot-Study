package net.springboot.demo.MyAsync;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
@Async
public class AsyncTask {

	
	public void task1() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("task 1 : " + (end-begin) );
		
	}
	
	
	public Future<String> task2() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(2000L);
		long end = System.currentTimeMillis();
		System.out.println("task 2 : " + (end-begin) );
		return new AsyncResult<String>("----task2----");
	}
	
	
	public Future<String> task3() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(3000L);
		long end = System.currentTimeMillis();
		System.out.println("task 3 : " + (end-begin) );
		return new AsyncResult<String>("----task3----");
	}
}
