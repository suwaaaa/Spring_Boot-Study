package net.springboot.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置z
@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix="test")
public class ServerSetting {

//	@Value("${test.name}")
	private String name;//名称
	
//	@Value("${test.damain}")   注入bean的方式，属性名称和配置文件里面的key一一对应，就用加@Value 这个注解如果不一样，就要加@value("${XXX}")
	private String damain;//域名地址

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDamain() {
		return damain;
	}

	public void setDamain(String damain) {
		this.damain = damain;
	}
	
	
	
}
