package com.it.bw.mapper;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;

public interface UserMapper extends BaseMapper<User, BaseQueryVo> {
	
	public void deleteUserRoleByUser(Long id);
	
	public void addUserRole(Long user_id, Long role_id);
	
	public User login(User user);
	
}