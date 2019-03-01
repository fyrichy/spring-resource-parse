package com.richy.spring.cycle02;

public class Cycle2 {

	private Cycle1 cycle1;
	
	public Cycle2(Cycle1 cycle1) {
		this.cycle1 = cycle1;
	}

	public Cycle1 getCycle1() {
		return cycle1;
	}

	public void setCycle1(Cycle1 cycle1) {
		this.cycle1 = cycle1;
	}
	
	
}
