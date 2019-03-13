package com.richy.spring.utils;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
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

import com.richy.spring.annotations.ExcelField;

/**
 * @descrp：Excel操作工具类
 * @author：FyRichy
 * @time：2019年3月12日下午3:31:48
 */
public class ExcelUtil{

	/**
	 * @descrp：导出Excel
	 * 	思路：通过反射获取标题，和排序【直接导出到本地】,支持没有数据也可以将头信息导出
	 * @author：FyRichy
	 * @time：2019年3月12日下午3:36:31
	 * @param title
	 * @param exportData
	 * @param response
	 * @param pattern
	 * @throws Exception
	 */
	public <T> void exportExcel(String excelTitle,List<T> exportData,T obj,OutputStream out,String pattern) throws Exception{
		//获取传入对象的注解信息和标注的Field
		List<Object[]> annotationList = getAnnotationList(obj);
		if(null == annotationList || annotationList.size() <= 0) {
			throw new Exception("请在要导出的类上标注@ExcelField,设置详细信息");
		}
		//创建worBook对象
		HSSFWorkbook workBook = new HSSFWorkbook();
		//创建一个工作表
		HSSFSheet sheet = workBook.createSheet(excelTitle);
		//------------------------------------设置大标题开始--------------------------------
		//创建头标题行
		HSSFRow headRow = sheet.createRow(0);
		//设置头标题行高
		headRow.setHeightInPoints((float) 40.0);
		//设置头标题单元格样式
		HSSFCellStyle headStyle = getHeadStyle(workBook,18);
		//创建一个单元格
		HSSFCell head = headRow.createCell(0);
		head.setCellValue(excelTitle);
		head.setCellStyle(headStyle);
		//合并单元格CellRangeAddress(4个参数，分别为起始行，结束行，起始列，结束列))
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, annotationList.size()-1));
		//------------------------------------设置大标题结束--------------------------------
		
		//------------------------------------设置行标题开始--------------------------------
		//填充标题
		HSSFRow titleRow = sheet.createRow(1);
		//设置标题行高
		titleRow.setHeightInPoints((float) 25.0);
		//设置标题单元格样式
		HSSFCellStyle titleStyle = getTitleStyle(workBook,14);
		//填充标题值
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
		HSSFCellStyle bodyStyle = getTitleStyle(workBook,10);
		setBodyValue(exportData,sheet,annotationList,bodyStyle,pattern);
		//------------------------------------填充值结束--------------------------------
		
		workBook.write(out);
		workBook.close();
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
	public <T> void exportExcel(String excelTitle,List<T> exportData,T obj,HttpServletResponse response,String pattern) throws Exception{
		//获取传入对象的注解信息和标注的Field
		List<Object[]> annotationList = getAnnotationList(obj);
		if(null == annotationList || annotationList.size() <= 0) {
			throw new Exception("请在要导出的类上标注@ExcelField,设置详细信息");
		}
		//创建worBook对象
		HSSFWorkbook workBook = new HSSFWorkbook();
		//创建一个工作表
		HSSFSheet sheet = workBook.createSheet(excelTitle);
		//------------------------------------设置大标题开始--------------------------------
		//创建头标题行
		HSSFRow headRow = sheet.createRow(0);
		//设置头标题行高
		headRow.setHeightInPoints((float) 40.0);
		//设置头标题单元格样式
		HSSFCellStyle headStyle = getHeadStyle(workBook,18);
		//创建一个单元格
		HSSFCell head = headRow.createCell(0);
		head.setCellValue(excelTitle);
		head.setCellStyle(headStyle);
		//合并单元格CellRangeAddress(4个参数，分别为起始行，结束行，起始列，结束列))
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, annotationList.size()-1));
		//------------------------------------设置大标题结束--------------------------------
		
		//------------------------------------设置行标题开始--------------------------------
		//填充标题
		HSSFRow titleRow = sheet.createRow(1);
		//设置标题行高
		titleRow.setHeightInPoints((float) 25.0);
		//设置标题单元格样式
		HSSFCellStyle titleStyle = getTitleStyle(workBook,14);
		//填充标题值
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
		HSSFCellStyle bodyStyle = getTitleStyle(workBook,10);
		setBodyValue(exportData,sheet,annotationList,bodyStyle,pattern);
		//------------------------------------填充值结束--------------------------------
		//进行导出
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String((excelTitle + ".xls").getBytes("GB2312"), "ISO8859-1"));
		workBook.write(response.getOutputStream());
		workBook.close();
	}
	
	/**
	 * @descrp：填充值
	 * @author：FyRichy
	 * @time：2019年3月13日上午11:27:10
	 * @param exportData：导出的数据
	 * @param sheet:工作表
	 * @param annotationList：包含有属性的名称(对应标题)、导出成excel的排序值
	 * @param cellStyle：单元格样式
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> void setBodyValue(List<T> exportData,HSSFSheet sheet,List<Object[]> annotationList,HSSFCellStyle cellStyle,String pattern) throws Exception {
		if(null != exportData && exportData.size() > 0) {
			for(int j=0;j<exportData.size();j++) {
				HSSFRow bodyRow = sheet.createRow(j + 2);
				bodyRow.setHeightInPoints((float) 25.0);
				Object data = exportData.get(j);
				for(int k=0;k<annotationList.size();k++) {
					HSSFCell _body = bodyRow.createCell(k);
					_body.setCellStyle(cellStyle);
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
								_body.setCellValue(new SimpleDateFormat(pattern).format((Date)value));
							}else {
								_body.setCellValue(String.valueOf(value));
							}
						}
					}
				}
			}
		}
	}

	/**
	 * @descrp：
	 * @author：FyRichy
	 * @time：2019年3月13日上午11:28:32
	 * @param workBook:excel对象
	 * @param fontHeightInPoints：字体行高
	 * @return
	 */
	private HSSFCellStyle getTitleStyle(HSSFWorkbook workBook,int fontHeightInPoints) {
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		//垂直居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//水平居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//字体
		HSSFFont font = workBook.createFont();
		//字体行高
		font.setFontHeightInPoints((short)fontHeightInPoints);
		//设置字体
		titleStyle.setFont(font);
		return titleStyle;
	}

	/**
	 * @descrp：设置头标题单元格格式
	 * @author：FyRichy
	 * @time：2019年3月13日上午11:29:04
	 * @param workBook：excel对象
	 * @param fontHeightInPoints：字体行高
	 * @return
	 */
	private HSSFCellStyle getHeadStyle(HSSFWorkbook workBook,int fontHeightInPoints) {
		HSSFCellStyle headStyle = workBook.createCellStyle();
		//垂直居中
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//水平居中
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		//字体
		HSSFFont headFont = workBook.createFont();
		//粗体
		headFont.setBold(true);
		//字体行高
		headFont.setFontHeightInPoints((short)fontHeightInPoints);
		//设置字体
		headStyle.setFont(headFont);
		return headStyle;
	}

	/**
	 * @descrp：根据对象获取标注在类的属性上的的注解信息和对应的Field对象
	 * @author：FyRichy
	 * @time：2019年3月13日上午10:50:46
	 * @param obj：需要导出的类的对象
	 * @return
	 */
	private <T> List<Object[]> getAnnotationList(T obj) {
		List<Object[]> annotationList = new ArrayList<Object[]>();
		//获取字段列表
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field:fields) {
			ExcelField excelField = field.getAnnotation(ExcelField.class);
			if(null != excelField) {
				annotationList.add(new Object[] {excelField,field});
			}
		}
		if(null != annotationList && annotationList.size() > 0) {
			//按照注解上的sort值进行排序
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
		}
		return annotationList;
	}
}
