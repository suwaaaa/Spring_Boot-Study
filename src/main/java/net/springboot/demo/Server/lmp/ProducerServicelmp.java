package net.springboot.demo.Server.lmp;



import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import net.springboot.demo.Server.ProducerService;

@Service
public class ProducerServicelmp implements ProducerService{

	@Autowired 				//		用来发送消息到broker的对象
	private JmsMessagingTemplate jms;  
	
	@Autowired    //   在 启动类里面 的@bean   
	private Queue queue;
	
	
	/**
	 * 发送消息，队列：destination  ，message是待发送消息
	 */
	@Override
	public void sendMessage(Destination destination, String message) {
		jms.convertAndSend(destination,message);
		
	}

	@Override
	public void sendMessage(String message) {
		jms.convertAndSend(this.queue, message);
	}
	
	
	
	
	
	
	
	/*
	 * 发布订阅
	 */
	
	@Autowired
	private Topic topic;
	
	public void publish(String msg) {
		this.jms.convertAndSend(this.topic,msg);
		
	}
	
	
	

}
