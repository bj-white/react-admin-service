package com.it.bw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;
import com.it.bw.service.MenuService;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuServiceImpl;
	
	@RequestMapping("/getMenuTree")
	@ResponseBody
	public ReturnData getMenuTree (BaseQueryVo baseQueryVo) {
		Map<String, Object> map = menuServiceImpl.getMenuTree(baseQueryVo);
		List<Menu> menus = (List<Menu>) map.get("list");
		return new ReturnData(getTree(menus, 0l));
	}

	private List<Menu> getTree(List<Menu> menus, long pid) {
		List<Menu> resultList = new ArrayList<Menu>();
		for (Menu menu : menus) {
			if (menu.getParent_id() == pid) {
				menu.setChildren(getTree(menus, menu.getId()));
				resultList.add(menu);
			}
		}
		return resultList;
	}

}
