package net.springboot.demo.Dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.springboot.demo.domain.User;

public interface UserMapper {

	@Insert("INSERT INTO USER ( name, phone, create_time, age) VALUES (#{name},#{phone},\r\n"
			+ "#{create_time},#{age});")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // keyProperty是java对象的属性，keyColumn是数据库字段
	int insert(User user);

	@Select("SELECT * FROM user")
	@Results({ @Result(column = "create_time", property = "create_time") // javaType = java.util.Date.class
	})
	List<User> getAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({ @Result(column = "create_time", property = "create_time") })
	User findById(Long id);

	@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{userId}")
	void delete(Long userId);
}
