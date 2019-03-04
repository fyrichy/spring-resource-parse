package com.richy.spring.test;

import com.richy.spring.componentscan.PackageComponentScan;

public class PackageComponentScanTest {

	public static void main(String[] args) throws Exception {
		PackageComponentScan scan = new PackageComponentScan();
		scan.scanPackages("com.richy.spring.handler");
	}
}
