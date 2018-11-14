package com.chahar.jpa.poc7.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="nonteachingstaff2")
@PrimaryKeyJoinColumn(referencedColumnName="s2_id_1")
public class NonTeachingStaffEntity2 extends StaffEntity2{
	
	private static final long serialVersionUID = 7755646528316024737L;
	
	private String areaexpertise;

	public NonTeachingStaffEntity2() {}

	public NonTeachingStaffEntity2(int id, String name,String areaexpertise) {
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
