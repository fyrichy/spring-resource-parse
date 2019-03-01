package com.richy.spring.cycle;

public class CycleB {

	private CycleA cycleA;
	
	public void printInfo() {
		System.out.println("在CycleB中调用A："+cycleA);
	}

	public CycleA getCycleA() {
		return cycleA;
	}

	public void setCycleA(CycleA cycleA) {
		this.cycleA = cycleA;
	}
	
	
}
