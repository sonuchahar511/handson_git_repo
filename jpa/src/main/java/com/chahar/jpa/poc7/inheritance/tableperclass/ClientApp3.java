package com.chahar.jpa.poc7.inheritance.tableperclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientApp3 {
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
		
		StaffEntity3 staff= new StaffEntity3(101,"pappu3");
		
		TeachingStaffEntity3 teachingStaff1=new TeachingStaffEntity3(1,"lalu3","10th","Maths");
		TeachingStaffEntity3 teachingStaff2=new TeachingStaffEntity3(2,"rabri3","5th","English");
		
		NonTeachingStaffEntity3 nonTeachingStaff1=new NonTeachingStaffEntity3(3,"meesa3","Accounts");
		NonTeachingStaffEntity3 nonTeachingStaff2=new NonTeachingStaffEntity3(4,"lalubeta3","Office");
		
		entityManager.persist(staff);
		entityManager.persist(teachingStaff1);
		entityManager.persist(teachingStaff2);
		entityManager.persist(nonTeachingStaff1);
		entityManager.persist(nonTeachingStaff2);
		
		System.out.println("persistRecord ends");
	}
}
