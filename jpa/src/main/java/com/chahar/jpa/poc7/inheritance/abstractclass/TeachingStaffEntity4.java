package com.chahar.jpa.poc7.inheritance.abstractclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="teachingstaff4")
public class TeachingStaffEntity4 extends StaffEntity4{
	
	private static final long serialVersionUID = 4360651491557938832L;
	
	private String qualification;
	private String subjectexpertise;
	
	public TeachingStaffEntity4() {}
	
	public TeachingStaffEntity4(int id, String name,String qualification,String subjectexpertise) {
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
