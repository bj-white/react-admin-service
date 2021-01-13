package com.it.bw.service;

import java.util.List;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;

public interface RoleService extends BaseService<Role, RoleQueryVo> {
	
	public List<String> getMenuIdByRole(Long id);
	
	public void addMenuRole(Long id, Long[] menus);
	
}