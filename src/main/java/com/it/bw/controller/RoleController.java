package com.it.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.bw.pojo.Role;
import com.it.bw.pojo.RoleQueryVo;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleQueryVo> {}