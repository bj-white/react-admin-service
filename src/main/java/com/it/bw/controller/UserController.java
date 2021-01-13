package com.it.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, BaseQueryVo> {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ReturnData login(User user) {
		return new ReturnData(2, "用户名或密码错误");
	}
	
}