package com.it.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.service.BaseService;
import com.it.bw.util.ReturnData;

public class BaseController<T, Q> {
	
	@Autowired
	private BaseService<T, Q> baseServiceImpl;
	
	@RequestMapping("/getByPage")
	@ResponseBody
	public ReturnData getByPage(Q q1) {
		return new ReturnData(baseServiceImpl.getByPage(q1));
	}
	
	@RequestMapping("/getById")
	@ResponseBody
	public ReturnData getById(Long id) {
		return new ReturnData(baseServiceImpl.getById(id));
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ReturnData add(T t) {
		baseServiceImpl.add(t);
		return new ReturnData();
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ReturnData update(T t) {
		baseServiceImpl.update(t);
		return new ReturnData();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ReturnData delete(Long id) {
		baseServiceImpl.delete(id);
		return new ReturnData();
	}

}
