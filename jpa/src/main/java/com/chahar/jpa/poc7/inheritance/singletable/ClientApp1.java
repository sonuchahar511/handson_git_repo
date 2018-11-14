package com.chahar.jpa.poc7.inheritance.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientApp1 {
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
		
		StaffEntity1 staff= new StaffEntity1(101,"pappu1");
		
		TeachingStaffEntity1 teachingStaff1=new TeachingStaffEntity1(1,"lalu1","10th","Maths");
		TeachingStaffEntity1 teachingStaff2=new TeachingStaffEntity1(2,"rabri1","5th","English");
		
		NonTeachingStaffEntity1 nonTeachingStaff1=new NonTeachingStaffEntity1(3,"meesa1","Accounts");
		NonTeachingStaffEntity1 nonTeachingStaff2=new NonTeachingStaffEntity1(4,"lalubeta1","Office");
		
		entityManager.persist(staff);
		entityManager.persist(teachingStaff1);
		entityManager.persist(teachingStaff2);
		entityManager.persist(nonTeachingStaff1);
		entityManager.persist(nonTeachingStaff2);
		
		System.out.println("persistRecord ends");
	}
}
