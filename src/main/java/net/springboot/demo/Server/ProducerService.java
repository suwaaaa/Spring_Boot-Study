package net.springboot.demo.Server;

import javax.jms.Destination;

import org.springframework.stereotype.Repository;

@Repository
public interface ProducerService{
	
	/**
	 * 功能描述：指定消息队列和消息
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination,final String message);
	
	
	/**
	 * 功能描述：使用默认消息队列，发送消息
	 * @param message
	 */
	public void sendMessage( final String message);
	
	/*
	 * 发布订阅模式，生产者
	 */
	public void publish(String msg);
}
 