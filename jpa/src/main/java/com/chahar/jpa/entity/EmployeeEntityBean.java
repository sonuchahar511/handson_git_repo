package com.chahar.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee501")
@javax.persistence.NamedQuery(name=NamedQueriesType.Employee.ALL_RECORDS_QUERY,query="select emp from EmployeeEntityBean emp")
@NamedQueries({
	@NamedQuery(name=NamedQueriesType.Employee.GET_RECORDS_QUERY, query="select emp from EmployeeEntityBean emp"),
	@NamedQuery(name=NamedQueriesType.Employee.DELETE_RECORDS_QUERY,query="delete from EmployeeEntityBean emp where emp.id=?1 ")
})
public class EmployeeEntityBean {
	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private int id;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_salary")
	private String empSalary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmployeeEntityBean [id=" + id + ", empName=" + empName + ", empSalary=" + empSalary + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
