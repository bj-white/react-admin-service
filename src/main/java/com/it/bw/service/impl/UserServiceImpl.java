package com.it.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.it.bw.mapper.UserMapper;
import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Role;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseQueryVo> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void add(User t) {
		t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
		
		super.add(t);
		
		List<Role> roles = t.getRoles();
		for (Role role : roles) {
			userMapper.addUserRole(t.getId(), role.getId());
		}
	}
	
	@Override
	public void update(User t) {
		if (t.getPassword() != null && t.getPassword() != "") {
			t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
		}
		
		super.update(t);
		
		userMapper.deleteUserRoleByUser(t.getId());
		List<Role> roles = t.getRoles();
		for (Role role : roles) {
			userMapper.addUserRole(t.getId(), role.getId());
		}
	}
	
	@Override
	public void delete(Long id) {
		userMapper.deleteUserRoleByUser(id);
		super.delete(id);
	}

	@Override
	public User login(User user) {
		User login = userMapper.login(user);
		if (login == null) {
			
		}
		return null;
	}
}