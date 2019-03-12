package com.richy.spring.utils;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.richy.spring.annotation.ExcelField;

/**
 * @descrp：基于注解、泛型导出Excel的方法
 * @author：FyRichy
 * @time：2019年3月12日下午3:31:48
 */
public class ExportExcelUtil<T> {

	
	/**
	 * @descrp：导出Excel
	 * 	思路：通过反射获取标题，和排序【直接导出到本地】
	 * @author：FyRichy
	 * @time：2019年3月12日下午3:36:31
	 * @param title
	 * @param exportData
	 * @param response
	 * @throws Exception
	 */
	public void exportExcel(String excelTitle,List<T> exportData,OutputStream out) throws Exception{
		if(null == exportData || exportData.size() <= 0) {
			return;
		}
		//获取泛型的真实对象，然后通过反射操作
		T obj = exportData.get(0);
		
		List<Object[]> annotationList = new ArrayList<Object[]>();
		//获取字段列表
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field:fields) {
			ExcelField excelField = field.getAnnotation(ExcelField.class);
			if(null != excelField) {
				annotationList.add(new Object[] {excelField,field});
			}
		}
		//进行排序
		Collections.sort(annotationList, new Comparator<Object[]>() {
			public int compare(Object[] o1, Object[] o2) {
				ExcelField e1 = (ExcelField)o1[0];
				ExcelField e2 = (ExcelField)o2[0];
				if(e1.sort() < e2.sort()) {
					return -1;
				}else if(e1.sort() > e2.sort()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(excelTitle);
		
		//------------------------------------设置大标题开始--------------------------------
		HSSFRow headRow = sheet.createRow(0);
		headRow.setHeightInPoints((float) 40.0);
		//合并的单元格样式
		HSSFCellStyle headStyle = workBook.createCellStyle();
		//垂直居中
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//创建一个居中格式
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		//字体
		HSSFFont headFont = workBook.createFont();
		headFont.setBold(true);
		headFont.setFontHeightInPoints((short) 15);
		headStyle.setFont(headFont);
		//合并单元格CellRangeAddress(4个参数，分别为起始行，结束行，起始列，结束列))
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, annotationList.size()-1));
		HSSFCell head = headRow.createCell(0);
		head.setCellValue(excelTitle);
		head.setCellStyle(headStyle);
		//------------------------------------设置大标题结束--------------------------------
		
		//------------------------------------设置行标题开始--------------------------------
		//填充标题
		HSSFRow titleRow = sheet.createRow(1);
		//合并的单元格样式
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		//垂直居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//创建一个居中格式
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		
		titleRow.setHeightInPoints((float) 25.0);
		for (int i = 0; i < annotationList.size(); i++) {
			//设置宽度
			sheet.setColumnWidth(i, 10000);
			HSSFCell _title = titleRow.createCell(i);
			ExcelField value = (ExcelField)annotationList.get(i)[0];
			_title.setCellValue(String.valueOf(value.title()));
			_title.setCellStyle(titleStyle);
		}
		//------------------------------------设置行标题结束--------------------------------
		
		//------------------------------------填充值结束--------------------------------
		for(int j=0;j<exportData.size();j++) {
			HSSFRow bodyRow = sheet.createRow(j + 2);
			bodyRow.setHeightInPoints((float) 25.0);
			Object data = exportData.get(j);
			for(int k=0;k<annotationList.size();k++) {
				HSSFCell _body = bodyRow.createCell(k);
				_body.setCellStyle(titleStyle);
				Field field = (Field) annotationList.get(k)[1];
				if(null != field) {
					String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
					Class tCls = data.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					if(null != getMethod) {
						Object value = getMethod.invoke(data, new Object[] {});
						if(null == value) {
							_body.setCellValue("");
						}else if(value instanceof Date){
							_body.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format((Date)value));
						}else {
							_body.setCellValue(String.valueOf(value));
						}
					}
				}
			}
		}
		//------------------------------------填充值结束--------------------------------
		
		workBook.write(out);
	}
	
	/**
	 * @descrp：通过下载的方式导出
	 * @author：FyRichy
	 * @time：2019年3月12日下午5:46:24
	 * @param excelTitle
	 * @param exportData
	 * @param out
	 * @throws Exception
	 */
	public void exportExcel(String excelTitle,List<T> exportData,HttpServletResponse response) throws Exception{
		if(null == exportData || exportData.size() <= 0) {
			return;
		}
		//获取泛型的真实对象，然后通过反射操作
		T obj = exportData.get(0);
		
		List<Object[]> annotationList = new ArrayList<Object[]>();
		//获取字段列表
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field:fields) {
			ExcelField excelField = field.getAnnotation(ExcelField.class);
			if(null != excelField) {
				annotationList.add(new Object[] {excelField,field});
			}
		}
		//进行排序
		Collections.sort(annotationList, new Comparator<Object[]>() {
			public int compare(Object[] o1, Object[] o2) {
				ExcelField e1 = (ExcelField)o1[0];
				ExcelField e2 = (ExcelField)o2[0];
				if(e1.sort() < e2.sort()) {
					return -1;
				}else if(e1.sort() > e2.sort()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(excelTitle);
		
		//------------------------------------设置大标题开始--------------------------------
		HSSFRow headRow = sheet.createRow(0);
		headRow.setHeightInPoints((float) 40.0);
		//合并的单元格样式
		HSSFCellStyle headStyle = workBook.createCellStyle();
		//垂直居中
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//创建一个居中格式
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		//字体
		HSSFFont headFont = workBook.createFont();
		headFont.setBold(true);
		headFont.setFontHeightInPoints((short) 15);
		headStyle.setFont(headFont);
		//合并单元格CellRangeAddress(4个参数，分别为起始行，结束行，起始列，结束列))
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, annotationList.size()-1));
		HSSFCell head = headRow.createCell(0);
		head.setCellValue(excelTitle);
		head.setCellStyle(headStyle);
		//------------------------------------设置大标题结束--------------------------------
		
		//------------------------------------设置行标题开始--------------------------------
		//填充标题
		HSSFRow titleRow = sheet.createRow(1);
		//合并的单元格样式
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		//垂直居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//创建一个居中格式
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		
		titleRow.setHeightInPoints((float) 25.0);
		for (int i = 0; i < annotationList.size(); i++) {
			//设置宽度
			sheet.setColumnWidth(i, 10000);
			HSSFCell _title = titleRow.createCell(i);
			ExcelField value = (ExcelField)annotationList.get(i)[0];
			_title.setCellValue(String.valueOf(value.title()));
			_title.setCellStyle(titleStyle);
		}
		//------------------------------------设置行标题结束--------------------------------
		
		//------------------------------------填充值结束--------------------------------
		for(int j=0;j<exportData.size();j++) {
			HSSFRow bodyRow = sheet.createRow(j + 2);
			bodyRow.setHeightInPoints((float) 25.0);
			Object data = exportData.get(j);
			for(int k=0;k<annotationList.size();k++) {
				HSSFCell _body = bodyRow.createCell(k);
				_body.setCellStyle(titleStyle);
				Field field = (Field) annotationList.get(k)[1];
				if(null != field) {
					String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
					Class tCls = data.getClass();
					Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
					if(null != getMethod) {
						Object value = getMethod.invoke(data, new Object[] {});
						if(null == value) {
							_body.setCellValue("");
						}else if(value instanceof Date){
							_body.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format((Date)value));
						}else {
							_body.setCellValue(String.valueOf(value));
						}
					}
				}
			}
		}
		//------------------------------------填充值结束--------------------------------
		
		//进行导出
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String((excelTitle + ".xls").getBytes("gb2312"), "ISO8859-1"));
		workBook.write(response.getOutputStream());
	}
}
