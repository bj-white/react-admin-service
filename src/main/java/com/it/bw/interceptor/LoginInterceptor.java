package com.it.bw.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.it.bw.util.JsonUtil;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getServletPath();
		System.out.println(url);
		if (url.equals("/user/login.do")) {
			return true;
		}
		
		String token = request.getHeader("X-Token");
		System.out.println(token);
		
		if (token == null || "".equals(token)) {
			writer(response, 2, "用户没有登录");
			return false;
		}
		
		return true;
	}

	private void writer(HttpServletResponse response, int status, String msg) throws IOException {

		response.setContentType("application/json;charset=utf-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("msg", msg);
		
		PrintWriter writer = response.getWriter();
		writer.write(JsonUtil.objectToJson(map));
		writer.flush();
		writer.close();
		
	}

}
