package com.richy.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @descr：实现FactoryBean
 * @author： Richy
 * @time：下午8:49:39
 */
	public class CarFactoryBean implements FactoryBean<Car>{
		
	private String carInfo;

	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.valueOf(infos[1]));
		car.setPrice(Double.valueOf(infos[2]));
		return car;
	}

	public Class<?> getObjectType() {
		return Car.class;
	}
	
	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public boolean isSingleton() {
		return false;
	}

}
