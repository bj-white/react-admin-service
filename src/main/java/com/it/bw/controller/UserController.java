package com.it.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.bw.exception.CommonException;
import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;
import com.it.bw.service.UserService;
import com.it.bw.util.ReturnData;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, BaseQueryVo> {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ReturnData login(User user) {
		System.out.println("login...........");
		String token = null;
		try {
			token = userServiceImpl.login(user);
		} catch (CommonException e) {
			return new ReturnData(2, e.getMessage());
		}
		
		return new ReturnData(1, "µÇÂ¼³É¹¦", token);
	}
	
}