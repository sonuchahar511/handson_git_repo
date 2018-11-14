package com.chahar.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PawanVikas")
public class Student101EntityBean implements Serializable {

	private static final long serialVersionUID = 4528314237292354769L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//@Column(name="student_id")
	private long id;
	
	//@Column(name="name1")
	private String name;

	public Student101EntityBean() {}

	public Student101EntityBean(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student101EntityBean [id=" + id + ", name=" + name 
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
