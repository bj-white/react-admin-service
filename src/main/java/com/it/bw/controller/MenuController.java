package com.it.bw.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;
import com.it.bw.pojo.User;
import com.it.bw.service.MenuService;
import com.it.bw.util.JsonUtil;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu, BaseQueryVo> {
	
	@Autowired
	private MenuService menuServiceImpl;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/getMenuTree")
	@ResponseBody
	public ReturnData getMenuTree (BaseQueryVo baseQueryVo) {
		Map<String, Object> map = menuServiceImpl.getByPage(baseQueryVo);
		List<Menu> menus = (List<Menu>) map.get("list");
		return new ReturnData(getTree(menus, 0l));
	}
	
	@RequestMapping("/getMenuTreeByUser")
	@ResponseBody
	public ReturnData getMenuTreeByUser () {
		String token = request.getHeader("X-Token");
		String userStr = (String)redisTemplate.boundValueOps(token).get();
		User user = JsonUtil.jsonToPojo(userStr, User.class);
		System.out.println(user);
		List<Menu> list = menuServiceImpl.getMenuTreeByUser(user.getId());
		return new ReturnData(getTree(list, 0l));
	}

	private List<Menu> getTree(List<Menu> menus, long pid) {
		List<Menu> resultList = new ArrayList<Menu>();
		for (Menu menu : menus) {
			if (menu.getParent_id() == pid) {
				menu.setChildren(getTree(menus, menu.getId()));
				resultList.add(menu);
			}
		}
		
		return resultList.size() != 0 ? resultList : null;
	}
	
}