package com.richy.spring.example;

public class TestBean {

	private String testStr = "这是一个字符串";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	
	public void test() {
		System.out.println("TestBean.test()");
	}
}
