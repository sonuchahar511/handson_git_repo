package com.chahar.jpa.poc7.inheritance.abstractclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="nonteachingstaff4")
public class NonTeachingStaffEntity4 extends StaffEntity4{
	
	private static final long serialVersionUID = 7755646528316024737L;
	
	private String areaexpertise;

	public NonTeachingStaffEntity4() {}

	public NonTeachingStaffEntity4(int id, String name,String areaexpertise) {
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
