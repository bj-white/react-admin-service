package com.it.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleQueryVo> {
	
	@RequestMapping("/getByPage")
	@ResponseBody
	public ReturnData getByPage(RoleQueryVo q1) {
		System.out.println(q1.getName());
		return super.getByPage(q1);
	}
	
}