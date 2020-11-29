package com.it.bw.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.it.bw.mapper.BaseMapper;
import com.it.bw.pojo.BasePojo;
import com.it.bw.service.BaseService;

public class BaseServiceImpl<T extends BasePojo, Q> implements BaseService<T, Q> {
	
	@Autowired
	private BaseMapper<T, Q> baseMapper;

	@Override
	public Map<String, Object> getByPage(Q q1) {
		List<T> list = baseMapper.getByPage(q1);
		Long count = baseMapper.getCount(q1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		return map;
	}

	@Override
	public T getById(Long id) {
		return baseMapper.getById(id);
	}

	@Override
	public void add(T t) {
		t.setCreatetime(new Date());
		t.setUpdatetime(t.getCreatetime());
		baseMapper.add(t);
	}

	@Override
	public void update(T t) {
		t.setUpdatetime(new Date());
		baseMapper.update(t);
	}

	@Override
	public void delete(Long id) {
		baseMapper.delete(id);
	}

}
