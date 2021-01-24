package com.it.bw.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.it.bw.util.JsonUtil;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Value("${TokenTime}")
	private Long TokenTime;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getServletPath();
		if (url.equals("/user/login.do")) {
			return true;
		}
		
		String token = request.getHeader("X-Token");
		
		if (token == null || "".equals(token)) {
			response.setStatus(502);
			return false;
		}
		
		String str = (String)redisTemplate.boundValueOps(token).get();
		if (str == null || "".equals(str)) {
			response.setStatus(502);
			return false;
		}
		
		redisTemplate.boundValueOps(token).set(str, TokenTime, TimeUnit.SECONDS);
		
		return true;
	}

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
