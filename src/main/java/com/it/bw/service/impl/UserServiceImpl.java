package com.it.bw.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseQueryVo> implements UserService {
	@Override
	public void add(User t) {
		t.setPassword(DigestUtils.md5DigestAsHex(t.getPassword().getBytes()));
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