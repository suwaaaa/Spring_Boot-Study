package net.springboot.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSub {

	
	@JmsListener(destination="pub.topic", containerFactory="jmsListenerContainerTopic")
	public void receive1(String text){
		System.out.println("pub.topic 消费者:receive1="+text);
	}
	
	
	@JmsListener(destination="pub.topic", containerFactory="jmsListenerContainerTopic")
	public void receive2(String text){
		System.out.println("pub.topic 消费者:receive2="+text);
	}
	
	
	@JmsListener(destination="pub.topic", containerFactory="jmsListenerContainerTopic")
	public void receive3(String text){
		System.out.println("pub.topic 消费者:receive3="+text);
	}
	
	
}