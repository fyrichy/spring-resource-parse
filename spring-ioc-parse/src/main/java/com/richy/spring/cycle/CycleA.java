package com.richy.spring.cycle;

public class CycleA {

	private CycleB cycleB;
	
	public void printInfo() {
		System.out.println("在CycleA中调用B："+cycleB);
	}

	public CycleB getCycleB() {
		return cycleB;
	}

	public void setCycleB(CycleB cycleB) {
		this.cycleB = cycleB;
	}
	
	
}
