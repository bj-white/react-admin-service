package com.it.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController<Menu, BaseQueryVo> {}