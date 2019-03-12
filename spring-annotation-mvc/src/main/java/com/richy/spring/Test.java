package com.richy.spring;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.BeanUtils;

import com.richy.spring.dto.UserExcelDto;
import com.richy.spring.model.User;
import com.richy.spring.utils.ExportExcelUtil;

public class Test {

	public static void main(String[] args) throws Exception {
		List<UserExcelDto> exportData = new ArrayList<UserExcelDto>();
		for(int i=1;i<=10;i++) {
			User user = new User(String.valueOf((10+i)), "user"+i, "这是一个user"+i,new Date());
			UserExcelDto excelDto = new UserExcelDto();
			BeanUtils.copyProperties(user, excelDto);
			exportData.add(excelDto);
		}
		
		ExportExcelUtil<UserExcelDto> excelUtil = new ExportExcelUtil<UserExcelDto>();
		excelUtil.exportExcel("测试一下", exportData, new FileOutputStream("d:\\annotation-export.xls"));
		
	}
}
