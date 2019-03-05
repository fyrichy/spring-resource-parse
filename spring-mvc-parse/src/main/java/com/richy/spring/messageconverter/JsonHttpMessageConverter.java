package com.richy.spring.messageconverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @descrp：自定义HttpMessageConverter，json对象和java对象相互转换
 * @author：FyRichy
 * @time：2019年3月5日下午4:29:27
 */
public class JsonHttpMessageConverter implements HttpMessageConverter<Object>{

	private ObjectMapper objectMapper = new ObjectMapper();
	
	//该转换器的支持的转换类型为application/json
	private List<MediaType> supportedMediaTypes = Collections.emptyList();
	
	/**
	 * @descrp：是否能讲Http报文转换成java对象
	 * @author：FyRichy
	 * @time：2019年3月5日下午4:32:59
	 * @param clazz
	 * @param mediaType
	 * @return
	 */
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		if(null == mediaType) {
			return true;
		}
		for(MediaType supportMediaType:getSupportedMediaTypes()) {
			if(supportMediaType.includes(mediaType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @descrp：是否能将java对象转换成为http报文
	 * @author：FyRichy
	 * @time：2019年3月5日下午4:33:16
	 * @param clazz
	 * @param mediaType
	 * @return
	 */
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (mediaType == null || MediaType.ALL.equals(mediaType)) {
		      return true;
		}
	    for (MediaType supportedMediaType : getSupportedMediaTypes()) {
	      if (supportedMediaType.includes(mediaType)) {
	        return true;
	      }
	    }
	    return false;
	}

	/**
	 * @descrp：
	 * @author：FyRichy
	 * @time：2019年3月5日下午4:33:33
	 * @return
	 */
	public List<MediaType> getSupportedMediaTypes() {
		return supportedMediaTypes;
	}
	
	public void setSupportedMediaTypes(List<MediaType> supportedMediaTypes) {
		this.supportedMediaTypes = supportedMediaTypes;
	}

	/**
	 * @descrp：将http报文转换成为java对象
	 * @author：FyRichy
	 * @time：2019年3月5日下午4:33:42
	 * @param clazz
	 * @param inputMessage
	 * @return
	 * @throws IOException
	 * @throws HttpMessageNotReadableException
	 */
	public Object read(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		
		return objectMapper.readValue(inputMessage.getBody(),clazz);
	}

	/**
	 * @descrp：将java对象转换成为http报文
	 * @author：FyRichy
	 * @time：2019年3月5日下午4:33:59
	 * @param t
	 * @param contentType
	 * @param outputMessage
	 * @throws IOException
	 * @throws HttpMessageNotWritableException
	 */
	public void write(Object t, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		objectMapper.writeValue(outputMessage.getBody(),t);
	}

}
