package com.chahar.jpa.poc7.inheritance.abstractclass;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@MappedSuperclass
public abstract class StaffEntity4 implements Serializable{
	
	private static final long serialVersionUID = 5607015851541130836L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	public StaffEntity4() {}
	
	public StaffEntity4(int id, String name) {
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
