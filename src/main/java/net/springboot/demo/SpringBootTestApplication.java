package net.springboot.demo;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;
import org.mybatis.spring.annotation.MapperScan;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication // 一个注解顶下面3个
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"net.xdclass.demo.controller","net.xdclass.demo.Myrepository","net.xdclass.demo.*"})

@ServletComponentScan // filter和 servlet 需要添加的注解
@EnableScheduling // 启动类里面 @EnableScheduling开启定时任务，自动扫描
@EnableAsync // 异步任务,启动类里面使用@EnableAsync注解开启功能，自动扫描

/*
 * 查看集群状态：localhost:9200/_cat/health?v 查看索引列表：localhost:9200/_cat/indices?v
 */
/*
 * war 包启动需要修改启动类 public class XdclassApplication extends
 * SpringBootServletInitializer {
 * 
 * @Override protected SpringApplicationBuilder
 * configure(SpringApplicationBuilder application) { return
 * application.sources(XdclassApplication.class); }
 * 
 * public static void main(String[] args) throws Exception {
 * SpringApplication.run(XdclassApplication.class, args); }
 */
@Configuration
@MapperScan(value="net.springboot.demo.Dao")

@EnableJms // 开启支持jms
public class SpringBootTestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(SpringBootTestApplication.class, args);
	}

	@Bean // 交给spring进行管理，方便后续注入 activeMq
	public ActiveMQQueue queue() {
		return new ActiveMQQueue("common.queue");
	}

	@Bean // 发布订阅模式，activeMQ
	public Topic activemqTopic() {
		return new ActiveMQTopic("pub.topic");
	}

	// 需要给topic定义独立的JmsListenerContainer 以下为支持两种方式，点对点和
	// 在配置文件里面，注释掉 #spring.jms.pub-sub-domain=true
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

//	@Bean  
//    public MultipartConfigElement multipartConfigElement() {  
//        MultipartConfigFactory factory = new MultipartConfigFactory();  
//        //单个文件最大  
//        factory.setMaxFileSize("10240KB"); //KB,MB  
//        /// 设置总上传数据总大小  
//        factory.setMaxRequestSize("1024000KB");  
//        return factory.createMultipartConfig();  
//    }  
}
