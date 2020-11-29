package com.it.bw.mapper;

import java.util.List;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;

public interface MenuMapper {

	public List<Menu> getByPage(BaseQueryVo baseQueryVo);
	
	public Long getCount(BaseQueryVo baseQueryVo);
	
}
