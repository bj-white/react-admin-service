package com.it.bw.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Role;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseQueryVo> implements UserService {
	
	@Override
	public void add(User t) {
		t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
		List<Role> roles = t.getRoles();
		for (Role role : roles) {
			System.out.println(role);
		}
		super.add(t);
	}
	
	@Override
	public void update(User t) {
		if (t.getPassword() != null && t.getPassword() != "") {
			t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
		}
		super.update(t);
	}
}