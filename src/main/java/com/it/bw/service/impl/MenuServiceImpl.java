package com.it.bw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bw.mapper.MenuMapper;
import com.it.bw.pojo.Menu;
import com.it.bw.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Map<String, Object> getMenuTree() {
		List<Menu> list = menuMapper.selectByPage();
		Long count = menuMapper.getCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		return map;
	}

}
