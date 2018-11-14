package com.chahar.jpa.poc7.inheritance.abstractclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientApp4 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		persistRecord(entityManager);
		
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void persistRecord(EntityManager entityManager) {
		
		System.out.println("========================================================================================================================");
		System.out.println("persistRecordstarts");
		
		
		TeachingStaffEntity4 teachingStaff1=new TeachingStaffEntity4(1,"lalu4","10th","Maths");
		TeachingStaffEntity4 teachingStaff2=new TeachingStaffEntity4(2,"rabri4","5th","English");
		
		NonTeachingStaffEntity4 nonTeachingStaff1=new NonTeachingStaffEntity4(3,"meesa4","Accounts");
		NonTeachingStaffEntity4 nonTeachingStaff2=new NonTeachingStaffEntity4(4,"lalubeta4","Office");
		
		entityManager.persist(teachingStaff1);
		entityManager.persist(teachingStaff2);
		entityManager.persist(nonTeachingStaff1);
		entityManager.persist(nonTeachingStaff2);
		
		System.out.println("persistRecord ends");
	}
}
