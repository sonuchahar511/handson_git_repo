package com.chahar.jpa.poc7.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="TS")
public class TeachingStaffEntity1 extends StaffEntity1{
	
	private static final long serialVersionUID = 4360651491557938832L;
	
	private String qualification;
	private String subjectexpertise;
	
	public TeachingStaffEntity1() {}
	
	public TeachingStaffEntity1(int id, String name,String qualification,String subjectexpertise) {
		super(id, name);
		this.qualification=qualification;
		this.subjectexpertise=subjectexpertise;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSubjectexpertise() {
		return subjectexpertise;
	}
	public void setSubjectexpertise(String subjectexpertise) {
		this.subjectexpertise = subjectexpertise;
	}
	
	@Override
	public String toString() {
		return "TeachingStaffEntity [qualification=" + qualification + ", subjectexpertise=" + subjectexpertise + "]";
	}
	
}
