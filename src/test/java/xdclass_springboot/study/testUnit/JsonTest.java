package xdclass_springboot.study.testUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import net.springboot.demo.SpringBootTestApplication;
import net.springboot.demo.domain.User;
import net.springboot.demo.utils.JsonUtils;
import net.springboot.demo.utils.RedisClient;


@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={SpringBootTestApplication.class})//启动整个springboot工程
public class JsonTest {
	
	
	@Autowired
	private StringRedisTemplate strTpl;
	
	@Autowired
	private RedisClient redis;
	
	@Test
	public void testOne(){
		User u = new User();
		u.setAge(1);
		u.setPhone("22222");
		u.setPwd("0000");	
		
		String str = JsonUtils.obj2String(u);
		
//		strTpl.opsForValue().set("str", str);
		
		redis.set("str", str);
		
		System.out.println(str);
		
	}

}
