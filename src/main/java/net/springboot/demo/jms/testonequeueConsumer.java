package net.springboot.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component

public class testonequeueConsumer {

	@JmsListener(destination="test_one queue")
	public void receiveQueue(String text){
		System.out.println("test_one queue  收到的报文为:"+text);
	}
}
