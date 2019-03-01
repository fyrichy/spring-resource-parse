package com.richy.spring.cycle02;

public class Cycle1 {

	private Cycle2 cycle2;
	
	public Cycle1(Cycle2 cycle2) {
		this.cycle2 = cycle2;
	}

	public Cycle2 getCycle2() {
		return cycle2;
	}

	public void setCycle2(Cycle2 cycle2) {
		this.cycle2 = cycle2;
	}
	
	
}
