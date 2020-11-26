package com.it.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bw.mapper.UserMapper;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectByPage() {
		return userMapper.selectByPage();
	}

}
