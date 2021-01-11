package net.springboot.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.domain.JsonData;


@RestController
@RequestMapping("/api/v1/redis")
public class RdisTestController {

	//注入模板
	@Autowired
	private StringRedisTemplate redisTpl; //jdbcTemplate

	
	/*
	 * 类型String，List,Hash,Set,ZSet
	 * 对应的方法分别是opsForValue()、opsForList()、opsForHash()、opsForSet()、opsForZSet()
	 */
	
	
	@GetMapping(value="add")
	public Object add(){
		
		//opsForValue : Returns the operations performed on simple values (or Strings in Redis terminology).
 
		redisTpl.opsForValue().set("name", "suwaaaa  zizi");
		
		return JsonData.buildSuccess();
		
	}
	
	@GetMapping(value="get")
	public Object get(){
		
		String value = redisTpl.opsForValue().get("name");		
		return JsonData.buildSuccess(value);
		
	}
	
	
	
	
	
	
}
