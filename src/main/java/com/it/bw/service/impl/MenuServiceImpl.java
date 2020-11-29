package com.it.bw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bw.mapper.MenuMapper;
import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;
import com.it.bw.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public Map<String, Object> getMenuTree(BaseQueryVo baseQueryVo) {
		List<Menu> list = menuMapper.getByPage(baseQueryVo);
		Long count = menuMapper.getCount(baseQueryVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		return map;
	}

}
