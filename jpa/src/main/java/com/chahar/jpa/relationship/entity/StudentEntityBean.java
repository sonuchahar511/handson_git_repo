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
@Table(name="student102")
public class StudentEntityBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="st_id")
	private long id;
	
	@Column(name="st_name")
	private String studentName;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="student")
	@JoinColumn(name="department_id")
	private DepartmentEntityBean department;

	public StudentEntityBean() {}
	
	public StudentEntityBean(String studentName, DepartmentEntityBean department) {
		super();
		this.studentName = studentName;
		this.department = department;
	}
	public long getId() {
		return id;
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

	@Override
	public String toString() {
		return "StudentEntityBean [id=" + id + ", studentName=" + studentName + ", department=" + department.getDepartmentName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
