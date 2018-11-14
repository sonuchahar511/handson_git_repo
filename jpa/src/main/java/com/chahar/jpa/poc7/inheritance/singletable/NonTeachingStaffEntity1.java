package com.chahar.jpa.poc7.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="NTS")
public class NonTeachingStaffEntity1 extends StaffEntity1{
	
	private static final long serialVersionUID = 7755646528316024737L;
	
	private String areaexpertise;

	public NonTeachingStaffEntity1() {}

	public NonTeachingStaffEntity1(int id, String name,String areaexpertise) {
		super(id, name);
		this.areaexpertise=areaexpertise;
	}

	public String getAreaexpertise() {
		return areaexpertise;
	}
	public void setAreaexpertise(String areaexpertise) {
		this.areaexpertise = areaexpertise;
	}
	
	@Override
	public String toString() {
		return "NonTeachingStaffEntity [areaexpertise=" + areaexpertise + "]";
	}
	
}
