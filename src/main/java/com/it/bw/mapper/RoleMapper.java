package com.it.bw.mapper;

import java.util.List;
import java.util.Map;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;

public interface RoleMapper extends BaseMapper<Role, RoleQueryVo> {
	
	public List<String> getMenuIdByRole(Long id);
	
	public void addMenuRole(Map map);
	
	public void deleteMenuRole(Long id);
	
	public void deleteUserRole(Long id);
	
}