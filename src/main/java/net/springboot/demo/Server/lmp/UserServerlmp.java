package net.springboot.demo.Server.lmp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.springboot.demo.Dao.UserMapper;
import net.springboot.demo.Server.UserServer;
import net.springboot.demo.domain.User;

@Service
public class UserServerlmp implements UserServer{

	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		
		return userMapper.insert(user);
	}


	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}


	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}


	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	@Override
	
	@Transactional(propagation=Propagation.REQUIRED)

	
	public int addAccount() {
		// TODO Auto-generated method stub
			User user = new User();
			user.setAge(9);
			user.setCreate_time(new Date());
			user.setName("事务测试");
			user.setPhone("000121212");
			
			userMapper.insert(user);
//	        int a = 1/0;

			return 1;
		}
	
	
	
}


