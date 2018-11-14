package com.chahar.jpa.launcher;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.chahar.jpa.relationship.entity.DepartmentEntityBean;
import com.chahar.jpa.relationship.entity.DepartmentEntityBean2;
import com.chahar.jpa.relationship.entity.StudentEntityBean;
import com.chahar.jpa.relationship.entity.StudentEntityBean2;

public class StudentDepartmentBeanApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
//		persistRecordUnidirectional(entityManager);
		//StudentEntityBean studentEntityBean=new StudentEntityBean("Yashpal Chahar",null); 
		//entityManager.persist(studentEntityBean);
		
//		retrievetRecordBidrectional(entityManager);	
		persistRecordBidirectional(entityManager);
		
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void persistRecordUnidirectional(EntityManager entityManager) {
		
		System.out.println("========================================================================================================================");
		System.out.println("persistRecordUnidirectional() starts");
		
		DepartmentEntityBean departmentEntityBean=new DepartmentEntityBean("Testing");
		StudentEntityBean studentEntityBean=new StudentEntityBean("Adiba",departmentEntityBean); 
		departmentEntityBean.setStudent(studentEntityBean);
		studentEntityBean.setDepartment(departmentEntityBean);
		
//		entityManager.persist(studentEntityBean);
		entityManager.persist(departmentEntityBean);
		
		System.out.println("persistRecordUnidirectional() ends");
	}
	
	public static void retrievetRecordUnidrectional(EntityManager entityManager) {
		
		System.out.println("========================================================================================================================");
		System.out.println("retrievetRecordUnidrectional() starts");
		
		Query query=entityManager.createQuery("SELECT st FROM StudentEntityBean st ");
		List<StudentEntityBean> list=query.getResultList();
		Iterator<StudentEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			StudentEntityBean studentEntityBean=iterator.next();
			System.out.println(studentEntityBean);
		}
		
		System.out.println("retrievetRecordUnidrectional() ends");
	}
	
	public static void persistRecordBidirectional(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("persistRecordBidirectional() starts");
		
		/*DepartmentEntityBean2 departmentEntityBean=new DepartmentEntityBean2(52,"Java",new StudentEntityBean2()); 
		StudentEntityBean2 studentEntityBean2=new StudentEntityBean2(61,"Chahar",departmentEntityBean); */
		
		DepartmentEntityBean departmentEntityBean=new DepartmentEntityBean("Testing1");
		StudentEntityBean studentEntityBean=new StudentEntityBean("Adiba1",departmentEntityBean); 
		departmentEntityBean.setStudent(studentEntityBean);
		studentEntityBean.setDepartment(departmentEntityBean);
		
		entityManager.persist(departmentEntityBean);
		System.out.println("persistRecordBidirectional() ends");
	}
	
	public static void retrievetRecordBidrectional(EntityManager entityManager) {
		
		System.out.println("========================================================================================================================");
		System.out.println("retrievetRecordBidrectional() starts");
		
		Query query=entityManager.createQuery("SELECT st FROM DepartmentEntityBean st ");
		List<DepartmentEntityBean> list=query.getResultList();
		Iterator<DepartmentEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			DepartmentEntityBean studentEntityBean=iterator.next();
			System.out.println(studentEntityBean);
		}
		
		System.out.println("retrievetRecordBidrectional() ends");
	}
}
