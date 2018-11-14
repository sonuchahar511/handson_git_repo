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
@Table(name="department102")
public class DepartmentEntityBean {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="dp_id")
	private long id;
	
	@Column(name="dp_name")
	private String departmentName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentEntityBean student;
	
	public DepartmentEntityBean() {}
	public DepartmentEntityBean( String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "DepartmentEntityBean [id=" + id + ", departmentName=" + departmentName + ", student=" + student.getStudentName() + "]";
	}
	public long getId() {
		return id;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public StudentEntityBean getStudent() {
		return student;
	}
	public void setStudent(StudentEntityBean student) {
		this.student = student;
	}
	
}
