package com.it.bw.service.impl;

import org.springframework.stereotype.Service;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;
import com.it.bw.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQueryVo> implements RoleService {}
