package com.richy.spring.business.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.richy.spring.dto.UserExcelDto;
import com.richy.spring.model.User;
import com.richy.spring.utils.ExportExcelUtil;

/**
 * @descrp：excel的controller
 * @author：FyRichy
 * @time：2019年3月12日下午3:39:37
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

	/**
	 * @descrp：导出excel
	 * @author：FyRichy
	 * @time：2019年3月12日下午5:48:14
	 * @throws Exception
	 */
	@RequestMapping("/export")
	public void export(HttpServletResponse response)throws Exception{
		List<UserExcelDto> exportData = new ArrayList<UserExcelDto>();
		for(int i=1;i<=10;i++) {
			User user = new User(String.valueOf((10+i)), "user"+i, "这是一个user"+i,new Date());
			UserExcelDto excelDto = new UserExcelDto();
			BeanUtils.copyProperties(user, excelDto);
			exportData.add(excelDto);
		}
		
		ExportExcelUtil<UserExcelDto> excelUtil = new ExportExcelUtil<UserExcelDto>();
		excelUtil.exportExcel("测试通过注解导出Excel", exportData,response);
	}
}
