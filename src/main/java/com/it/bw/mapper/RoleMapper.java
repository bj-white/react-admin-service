package com.it.bw.mapper;

import java.util.List;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;

public interface RoleMapper extends BaseMapper<Role, RoleQueryVo> {
	
	public List<String> getMenuIdByRole(Long id);
	
}