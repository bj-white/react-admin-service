package com.it.bw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	}

	@Override
	public void addMenuRole(Long id, Long[] menus) {
		roleMapper.deleteMenuRole(id);
		if (menus != null) {
			for (int i = 0; i < menus.length; i++) {
				System.out.println(menus[i]);
				Map map = new HashMap();
				map.put("role_id", id);
				map.put("menu_id", menus[i]);
				roleMapper.addMenuRole(map);
			}
		}
	}
	
	@Override
	public void delete(Long id) {
		roleMapper.deleteMenuRole(id);
		roleMapper.deleteUserRole(id);
		super.delete(id);
	}
	
}