package net.springboot.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.domain.MyExecption;
import net.springboot.demo.domain.User;

@RestController
public class ExcptionController {
	
	/**功能描述：TODO
	 *
	 *全局异常实战
	 * <p> 创建时间：2020年12月31日 下午4:48:02 </p> 
	 * <p> </p>
	 */
	@RequestMapping(value = "/test/exception")
	public Object index() {
		return new User("aaaa",11,"afda","54154",new Date());
	}
	
	
	/**功能描述：TODO
	 *
	 *自定义异常和错误页面跳转实战
	 * <p> 创建时间：2020年12月31日 下午4:48:02 </p> 
	 * <p> </p>
	 */
	@RequestMapping(value = "test/myexception")
	public Object myObject() {
		throw new MyExecption("500", "It is about testing MyExecption");
	}
	
}
