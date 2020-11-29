package com.it.bw.service;

import java.util.Map;

import com.it.bw.pojo.BaseQueryVo;

public interface MenuService {
	
	public Map<String, Object> getMenuTree(BaseQueryVo baseQueryVo);

}
