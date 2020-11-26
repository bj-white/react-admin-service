package com.it.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.pojo.User;
import com.it.bw.service.UserService;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/user1")
	@ResponseBody
	public ReturnData test1 () {
		List<User> list = userServiceImpl.selectByPage();
		ReturnData returnData = new ReturnData(1, "ok", list);
		return returnData;
	}
}
