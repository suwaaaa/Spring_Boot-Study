package net.springboot.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.Server.UserServer;
import net.springboot.demo.domain.JsonData;
import net.springboot.demo.domain.User;

@RestController
public class UserController {

	@Autowired
	private UserServer userServer;

	@GetMapping(value = "/user")
	public Object addUser(User user) {
		user.setCreate_time(new Date());

		return userServer.insert(user);
	}

	@GetMapping("find_all")
	public Object findAll() {
		return JsonData.buildSuccess(userServer.getAll());
	}

	@GetMapping("find_by_Id")
	public Object findById(long id) {
		return JsonData.buildSuccess(userServer.findById(id));
	}

	@GetMapping("del_by_id")
	public Object delById(long id) {userServer.delete(id);
		return JsonData.buildSuccess();
	}

	@GetMapping("update")
	public Object update(String name, int id) {
		User user = new User();
		user.setName(name);
		user.setId(id);
		userServer.update(user);
		return JsonData.buildSuccess();
	}

	/**功能描述：TODO
	 *
	 *SpringBoot整合mybatis之事务处理实战
	 * <p> 创建时间：2021年1月5日 下午4:39:47 </p> 
	 * 
	 */
	@GetMapping("succession")
	public int addAccount() {
		return userServer.addAccount();
	}
	
}
