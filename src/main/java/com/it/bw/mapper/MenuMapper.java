package com.it.bw.mapper;

import java.util.List;

import com.it.bw.pojo.Menu;

public interface MenuMapper {

	public List<Menu> selectByPage();
	
	public Long getCount();
	
}
