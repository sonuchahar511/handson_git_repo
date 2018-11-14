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
@Table(name="student201")
public class StudentEntityBean2 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="st_id")
	private long id;
	
	@Column(name="st_name")
	private String studentName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dp_id")
	private DepartmentEntityBean department;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dp2_id")
	private DepartmentEntityBean2 department2;
	
	public StudentEntityBean2() {}
	public StudentEntityBean2(long id, String studentName, DepartmentEntityBean2 department2) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.department2 = department2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public DepartmentEntityBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntityBean department) {
		this.department = department;
	}
	public DepartmentEntityBean2 getDepartment2() {
		return department2;
	}
	public void setDepartment2(DepartmentEntityBean2 department2) {
		this.department2 = department2;
	}
	
	@Override
	public String toString() {
		return "StudentEntityBean [id=" + id + ", studentName=" + studentName + ", department=" + department
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
