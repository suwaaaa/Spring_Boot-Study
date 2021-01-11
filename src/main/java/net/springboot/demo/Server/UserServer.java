package net.springboot.demo.Server;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.springboot.demo.domain.User;

@Repository
public interface UserServer {

	public int insert(User user); 
	
	public List<User> getAll();
	
	public User findById(Long id);
	
	public void update(User user);
	
	public void delete(Long userId);
	
	/**功能描述：TODO
	 *
	 *SpringBoot整合mybatis之事务处理实战
	 * <p> 创建时间：2021年1月5日 下午4:39:47 </p> 
	 * 
	 */
	public int addAccount();
	
}
