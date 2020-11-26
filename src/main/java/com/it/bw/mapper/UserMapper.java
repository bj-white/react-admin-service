package com.it.bw.mapper;

import java.util.List;

import com.it.bw.pojo.User;

public interface UserMapper {
	public List<User> selectByPage();
}
