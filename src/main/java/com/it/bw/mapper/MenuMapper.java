package com.it.bw.mapper;

import java.util.List;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;

public interface MenuMapper extends BaseMapper<Menu, BaseQueryVo> {

	List<Menu> getMenuTreeByUser(Long id);
	
}
