package com.it.bw.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.it.bw.exception.CommonException;
import com.it.bw.mapper.UserMapper;
import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Role;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;
import com.it.bw.util.JsonUtil;
import com.it.bw.util.TokenUtil;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseQueryVo> implements UserService {
	
	@Value("${TokenTime}")
	private Long TokenTime;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
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
	public String login(User user) {
		User login = userMapper.login(user);
		if (login == null) {
			throw new CommonException("用户名不存在");
		}
		if (!DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).equals(login.getPassword())) {
			throw new CommonException("用户名或密码错误");
		}
		
		String token = TokenUtil.getToken();
		String loginJson = JsonUtil.objectToJson(login);
		System.out.println(loginJson);
		redisTemplate.boundValueOps(token).set(loginJson, TokenTime, TimeUnit.SECONDS);
		
		return token;
	}
}