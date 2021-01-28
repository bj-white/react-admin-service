package com.it.bw.service;

import java.util.List;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;

public interface MenuService extends BaseService<Menu, BaseQueryVo> {
	
	List<Menu> getMenuTreeByUser(Long id);
	
}