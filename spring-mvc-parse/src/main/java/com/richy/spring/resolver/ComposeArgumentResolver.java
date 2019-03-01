package com.richy.spring.resolver;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.richy.spring.annotation.Compose;
import com.richy.spring.model.Teacher;
import com.richy.spring.model.User;

public class ComposeArgumentResolver implements HandlerMethodArgumentResolver{

	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(Compose.class);
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		// content-type不是json的不处理
        if (!request.getContentType().contains("application/json")) {
            return null;
        }
		String jsonStr = getJsonByRequestBody(request);
		
        return parseArgument2(jsonStr,parameter);
	}

	/**
	 * @descrp：把reqeust的body读取到StringBuilder
	 * @author：FyRichy
	 * @time：2019年2月28日下午3:18:03
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String getJsonByRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        int rd;
        while((rd = reader.read(buf)) != -1){
            sb.append(buf, 0, rd);
        }
		return sb.toString();
	}

	/**
	 * @descrp：利用fastjson转换为对应的类型
	 * @author：FyRichy
	 * @time：2019年2月28日下午3:15:49
	 * @param str
	 * @param parameter
	 * @return
	 */
	private Object parseArgument2(String str, MethodParameter parameter) {
		if(!"".equals(str)) {
			if(com.richy.spring.model.Compose.class.isAssignableFrom(parameter.getParameterType())){
	        	String result = "{"+str+"}";
	        	return JSON.parseObject(result, com.richy.spring.model.Compose.class);
	        } else {
	            return JSON.parseObject(str, parameter.getParameterType());
	        }
		}else {
			return null;
		}
	}
	
	/**
	 * @descrp：利用fastjson转换为对应的类型详细解析
	 * @author：FyRichy
	 * @time：2019年2月28日下午3:16:07
	 * @param str
	 * @param parameter
	 * @return
	 */
	private Object parseArgument(String str, MethodParameter parameter) {
		if(com.richy.spring.model.Compose.class.isAssignableFrom(parameter.getParameterType())){
        	String result = "{"+str+"}";
        	JSONObject jsonObject = JSON.parseObject(result);
        	String user = jsonObject.getString("user");
        	User u = new User();
        	if(!"".equals(user)) {
        		u = JSON.parseObject(user, User.class);
        	}
        	Teacher t = new Teacher();
        	String teacher = jsonObject.getString("teacher");
        	if(!"".equals(teacher)) {
        		t = JSON.parseObject(teacher, Teacher.class);
        	}
        	return new com.richy.spring.model.Compose(u, t);
        } else {
            return JSON.parseObject(str, parameter.getParameterType());
        }
	}

}
