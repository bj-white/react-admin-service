package com.it.bw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bw.mapper.MenuMapper;
import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;
import com.it.bw.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, BaseQueryVo> implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenuTreeByUser(Long id) {
		return menuMapper.getMenuTreeByUser(id);
	}}
