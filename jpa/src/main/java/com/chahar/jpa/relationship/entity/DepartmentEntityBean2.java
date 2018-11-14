package com.chahar.jpa.relationship.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department201")
public class DepartmentEntityBean2 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="dp2_id")
	private long id;
	
	@Column(name="dp_name")
	private String departmentName;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="department2")
	@JoinColumn(name="st_id")
	private StudentEntityBean2 studentEntityBean2;

	
	
	public DepartmentEntityBean2() {}
	public DepartmentEntityBean2(long id, String departmentName,StudentEntityBean2 studentEntityBean2) {
		this.id = id;
		this.departmentName = departmentName;
		this.studentEntityBean2=studentEntityBean2;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}	
	public StudentEntityBean2 getStudentEntityBean2() {
		return studentEntityBean2;
	}
	public void setStudentEntityBean2(StudentEntityBean2 studentEntityBean2) {
		this.studentEntityBean2 = studentEntityBean2;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
