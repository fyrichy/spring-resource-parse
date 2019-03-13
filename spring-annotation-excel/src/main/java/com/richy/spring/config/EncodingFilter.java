package com.richy.spring.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @descrp：字符集编码过滤器
 * @author：FyRichy
 * @time：2019年3月13日下午12:52:53
 */
//@WebFilter(filterName="encodingFilter",urlPatterns="/*")
public class EncodingFilter /*implements Filter*/{

	/*public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
	}*/

}
