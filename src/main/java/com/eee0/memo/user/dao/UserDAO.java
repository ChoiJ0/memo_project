package com.eee0.memo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.eee0.memo.user.model.User;

@Repository
public interface UserDAO {

	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("userName") String userName
			, @Param("email") String email);
	
	public User selectUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	
}
