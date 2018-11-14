package com.chahar.jpa.poc7.inheritance.tableperclass;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="nonteachingstaff3")
@PrimaryKeyJoinColumn(referencedColumnName="s3_id_1")
public class NonTeachingStaffEntity3 extends StaffEntity3{
	
	private static final long serialVersionUID = 7755646528316024737L;
	
	private String areaexpertise;

	public NonTeachingStaffEntity3() {}

	public NonTeachingStaffEntity3(int id, String name,String areaexpertise) {
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
