package com.it.bw.service;

import java.util.Map;

public interface BaseService<T, Q> {
	
	public Map<String, Object> getByPage(Q q1);

	public T getById(Long id);
	
	public void add(T t);
	
	public void update(T t);
	
	public void delete(Long id);

}
