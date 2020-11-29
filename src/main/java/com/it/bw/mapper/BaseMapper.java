package com.it.bw.mapper;

import java.util.List;

public interface BaseMapper<T, Q> {
	
	public List<T> getByPage(Q q1);
	
	public Long getCount(Q q1);
	
	public T getById(Long id);
	
	public void add(T t);
	
	public void update(T t);
	
	public void delete(Long id);

}
