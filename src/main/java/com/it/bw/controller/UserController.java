package com.it.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, BaseQueryVo> {}