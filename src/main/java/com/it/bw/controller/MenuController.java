package com.it.bw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.bw.service.MenuService;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuServiceImpl;
	
	@RequestMapping("/getMenuTree")
	public ReturnData getMenuTree () {
		Map<String, Object> menuTree = menuServiceImpl.getMenuTree();
		return new ReturnData(menuTree);
	}

}
