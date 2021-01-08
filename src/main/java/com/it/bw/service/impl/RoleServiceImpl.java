package com.it.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bw.mapper.RoleMapper;
import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;
import com.it.bw.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleQueryVo> implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<String> getMenuIdByRole(Long id) {
		return roleMapper.getMenuIdByRole(id);
	}}
