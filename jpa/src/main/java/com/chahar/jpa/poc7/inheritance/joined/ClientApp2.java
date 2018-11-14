package com.chahar.jpa.poc7.inheritance.joined;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientApp2 {
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
		
		StaffEntity2 staff= new StaffEntity2(101,"pappu2");
		
		TeachingStaffEntity2 teachingStaff1=new TeachingStaffEntity2(1,"lalu2","10th","Maths");
		TeachingStaffEntity2 teachingStaff2=new TeachingStaffEntity2(2,"rabri2","5th","English");
		
		NonTeachingStaffEntity2 nonTeachingStaff1=new NonTeachingStaffEntity2(3,"meesa2","Accounts");
		NonTeachingStaffEntity2 nonTeachingStaff2=new NonTeachingStaffEntity2(4,"lalubeta2","Office");
		
		entityManager.persist(staff);
		entityManager.persist(teachingStaff1);
		entityManager.persist(teachingStaff2);
		entityManager.persist(nonTeachingStaff1);
		entityManager.persist(nonTeachingStaff2);
		
		System.out.println("persistRecord ends");
	}
}
