package com.it.bw.service.impl;

import org.springframework.stereotype.Service;

import com.it.bw.pojo.BaseQueryVo;
import com.it.bw.pojo.Menu;
import com.it.bw.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, BaseQueryVo> implements MenuService {}
