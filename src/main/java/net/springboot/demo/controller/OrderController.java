package net.springboot.demo.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.Server.lmp.ProducerServicelmp;
import net.springboot.demo.domain.JsonData;


/**
 * 功能描述：模拟微信支付回调
 *
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private ProducerServicelmp producerService;
	/**
	 * 功能描述：微信支付回调接口			DOM  处理？？？？
	 * @param msg 支付信息
	 * @return
	 */
	@GetMapping("test_one")
	public Object order(String msg){
		
		//  生成消息队列地址
		Destination destination = new ActiveMQQueue("test_one queue");
		
		producerService.sendMessage(destination, msg);
	
       return net.springboot.demo.domain.JsonData.buildSuccess();
	}
	
	
	
	@GetMapping("common")
	public Object common(String msg){
		producerService.sendMessage(msg);	
       return JsonData.buildSuccess();
	}
	
	
	
	/*
	 * 生产者，发布订阅
	 */
	
	@GetMapping("topic")
	public Object topic(String msg){
		producerService.sendMessage(msg);	
       return JsonData.buildSuccess();
	}
	
	
	
	
	
	
//	
//	/**
//	 * 功能描述：微信支付回调接口
//	 * @param msg 支付信息
//	 * @return
//	 */
//	@GetMapping("comment")
//	public Object comment(String msg) throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException{
//	  
//		/**
//        * 创建一个消息实例，包含 topic、tag 和 消息体           
//       */
//       Message message = new Message("commentTopic","add", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
//       
//       //同步的方式，会有返回结果,发送的是普通消息
//       SendResult result = msgProducer.getProducer().send(message);
//       
//       System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
//     
//       return JsonData.buildSuccess();
//	}
//	
//	
//	
	
	
	
}
