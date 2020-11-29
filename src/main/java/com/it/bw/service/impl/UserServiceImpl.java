package com.it.bw.service.impl;

import org.springframework.stereotype.Service;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseQueryVo> implements UserService {}