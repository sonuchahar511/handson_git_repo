package com.chahar.jpa.poc7.inheritance.joined;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="staff2")
@Inheritance(strategy=InheritanceType.JOINED)
public class StaffEntity2 implements Serializable{
	
	private static final long serialVersionUID = 5607015851541130836L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	public StaffEntity2() {}
	
	public StaffEntity2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "StaffEntity [id=" + id + ", name=" + name + "]";
	}
}
