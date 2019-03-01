package com.richy.spring.example;

import java.util.HashSet;
import java.util.Set;

public class TestCollectionForSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		boolean b1 = set.add("12");
		boolean b2 = set.add("12");
		System.out.println(b1+"---"+b2);
	}
}
