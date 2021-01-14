package com.it.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;
import com.it.bw.service.RoleService;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleQueryVo> {
	
	@Autowired
	private RoleService roleServiceImpl;
	
	@RequestMapping("/getMenuIdByRole")
	@ResponseBody
	public ReturnData getMenuIdByRole(Long id) {
		return new ReturnData(roleServiceImpl.getMenuIdByRole(id));
	}
	
	@RequestMapping(value="/addMenuRole", method=RequestMethod.POST)
	@ResponseBody
	public ReturnData addMenuRole(Long id, Long[] menus) {
		System.out.println(id);
		roleServiceImpl.addMenuRole(id, menus);
		return new ReturnData();
	}
	
}