package net.springboot.demo.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskTest {

	
	@Scheduled(fixedRate = 10000)    				 //    每两秒打印一次
//	 @Scheduled(cron="*/1 * * * * *")                //	cron 定时任务表达式,表示每秒
	 											 	 //    crontab 工具  https://tool.lu/crontab/
	 
		/*
		 * fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；） fixedDelay: 上一次执行结束时间点后xx秒再次执行
		 * fixedDelayString: 字符串形式，可以通过配置文件指定
		 */
	public void printTask() {
		
		System.out.println("Time is :" + new Date());
	}
}
