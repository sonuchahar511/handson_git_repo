package com.chahar.jpa.launcher;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.chahar.jpa.entity.Student101EntityBean;

public class Student101EntityBeanTestApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		querySelect(entityManager);
		
		
//		retrieveTest(entityManager);
//		UpdateTest(entityManager);
//		removeTest(entityManager);
		
//		Student101EntityBean studentEntityBean1=new Student101EntityBean("Pawan Maurya");
//		Student101EntityBean studentEntityBean2=new Student101EntityBean("Vikas");
//		System.out.println("Persisting entities... " + studentEntityBean1+" "+studentEntityBean2);
//		entityManager.persist(studentEntityBean1);
//		entityManager.persist(studentEntityBean2);
//		System.out.println("Successfully persistd..." + studentEntityBean1+" "+studentEntityBean2);
		
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void retrieveTest(EntityManager entityManager) {
		System.out.println("Fetching record having");
		Student101EntityBean studentEntityBean=entityManager.find(Student101EntityBean.class, new Long(6));
		System.out.println(studentEntityBean);
		
//		studentEntityBean=new Student101EntityBean("aniket2111111111");
//		studentEntityBean.setId(17);
		studentEntityBean.setName("noidaindia");
		entityManager.persist(studentEntityBean);
		System.out.println(studentEntityBean);
	}
	
	public static void UpdateTest(EntityManager entityManager) {
		Student101EntityBean studentEntityBean=entityManager.find(Student101EntityBean.class, new Long(7));
		studentEntityBean.setName("pappuBatchelor");
		entityManager.persist(studentEntityBean);
		System.out.println("Record updated successfully");
	}
	
	public static void removeTest(EntityManager entityManager) {
		Student101EntityBean studentEntityBean=entityManager.find(Student101EntityBean.class, new Long(4));
		entityManager.remove(studentEntityBean);
		System.out.println("Record deleted successfully");
	}
	
	public static void RetrieveQueryUpdate(EntityManager entityManager) {
		Query query=entityManager.createQuery("UPDATE Student101EntityBean e SET e.firstname='India1' WHERE e.id=4231");
		query.executeUpdate();
	}
	
	public static void queryUpdate(EntityManager entityManager) {
		Query query=entityManager.createQuery("DELETE FROM Student101EntityBean e WHERE e.id=44");
		query.executeUpdate();
	}
	public static void querySelect(EntityManager entityManager) {
		Query query=entityManager.createQuery("SELECT e FROM Student101EntityBean e");
//		Query query1=entityManager.createQuery("SELECT e FROM Student101EntityBean e WHERE e.id=44");
		List<Student101EntityBean> list=(List<Student101EntityBean>)query.getResultList();
		Iterator<Student101EntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			Student101EntityBean student101EntityBean=iterator.next();
			System.out.println(student101EntityBean.getId()+" "+student101EntityBean.getName());
		}
	}
	
	
}
