package com.chahar.jpa.launcher;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.chahar.jpa.entity.EmployeeEntityBean;
import com.chahar.jpa.entity.NamedQueriesType;

public class EmployeeEntityBeanTestApp {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
/*//		working
		listNamedQuery(entityManager, NamedQueriesType.Employee.GET_RECORDS_QUERY);
		
//		working
		listNamedQuery(entityManager,NamedQueriesType.Employee.ALL_RECORDS_QUERY);
		
//		working
//		deleteNamedQuery(entityManager);
		
//		working
		avgCreateQuery(entityManager);
		
//		working
		concatCreateQuery(entityManager);
		
//		working
		countCreateQuery(entityManager);
		
//		working
		parameterizedCreateQuery(entityManager);
		
//		working
		gourpByCreateQuery(entityManager);

//		working
		orderByCreateQuery(entityManager, "asc");
		
//		working
		orderByCreateQuery(entityManager, "desc");
		
//		working
		lengthCreateQuery(entityManager);
		
//		working
		upperlowerCreateQuery(entityManager,"UPPER");
		
//		working
		upperlowerCreateQuery(entityManager,"lower");
		
//		working
		maxminCreateQuery(entityManager,"max");
		
//		working
		maxminCreateQuery(entityManager,"min");
		
//		working
		modCreateQuery(entityManager);
		
//		working
		parameterizedCreateQuery2(entityManager);

//		working
		parameterizedCreateQuery3(entityManager);
		
//		working
		resultListCreateQuery(entityManager);
		
//		working
		listCreateNativeQuery(entityManager,"emp_name");
		
//		working
		listCreateNativeQuery(entityManager,"emp_salary");*/
		
		orderByNativeCreateQuery(entityManager,"asc");
		
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
//	checked
	public static void listNamedQuery(EntityManager entityManager,String namedQuery) {
		System.out.println("========================================================================================================================");
		System.out.println("listNamedQuery starts");
		
		Query query=entityManager.createNamedQuery(namedQuery);
		
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("listNamedQuery ends");
	}
	
	public static void deleteNamedQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("deleteNamedQuery starts");
		
		Query query2=entityManager.createNamedQuery(NamedQueriesType.Employee.DELETE_RECORDS_QUERY);
		query2.setParameter(1, 8);
		System.out.println(query2.executeUpdate()+" record is deleted");
		
		System.out.println("deleteNamedQuery ends");
	}
	
	public static void avgCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("avgCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT AVG (emp.empSalary) FROM EmployeeEntityBean emp");
		Number average=(Number) query.getSingleResult();
		System.out.println("Salary average: "+average);
		
		System.out.println("avgCreateQuery ends");
	}
	
	public static void listNestedCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("listNestedCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE emp.empSalary>(SELECT AVG (emp.empSalary) FROM EmployeeEntityBean emp)");
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("listNestedCreateQuery ends");
	}
	
	public static void concatCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("concatCreateQuery starts");
		
		Query query=entityManager.createQuery("UPDATE EmployeeEntityBean emp SET emp.empName= CONCAT(emp.empName,'-i') ");
		System.out.println(query.executeUpdate()+" records are affected");
		
		System.out.println("concatCreateQuery ends");
	}
	
	public static void countCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("countCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT COUNT (emp.empName) FROM EmployeeEntityBean emp ");
		Number count=(Number) query.getSingleResult();
		System.out.println("COUNT : "+count);
		
		System.out.println("countCreateQuery ends");
	}
	
	public static void parameterizedCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("parameterizedCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE emp.id=:id ");
		query.setParameter("id", 7);
		EmployeeEntityBean emp=(EmployeeEntityBean)query.getSingleResult();
		System.out.println(emp);
		
		System.out.println("parameterizedCreateQuery ends");
	}
	
	public static void gourpByCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("gourpByCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp GROUP BY emp.id ");
		//query.setParameter("id", 7);
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("gourpByCreateQuery ends");
	}
	
	public static void orderByCreateQuery(EntityManager entityManager,String order) {
		System.out.println("========================================================================================================================");
		System.out.println("orderByCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp ORDER BY emp.empSalary "+order);
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("orderByCreateQuery ends");
	}
	
	public static void lengthCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("lengthCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE LENGTH(emp.empName)>4 ");
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("lengthCreateQuery ends");
	}
	
	public static void upperlowerCreateQuery(EntityManager entityManager,String order) {
		System.out.println("========================================================================================================================");
		System.out.println("upperlowerCreateQuery starts");
		
		Query query=entityManager.createQuery("UPDATE EmployeeEntityBean emp SET emp.empName="+order+"(emp.empName)");
		System.out.println(query.executeUpdate()+" records are updated");
		
		System.out.println("upperlowerCreateQuery ends");
	}
	

	public static void maxminCreateQuery(EntityManager entityManager,String type) {
		System.out.println("========================================================================================================================");
		System.out.println("maxminCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT "+type+"(emp.empSalary) FROM EmployeeEntityBean emp");
		Number number= Long.parseLong((String) query.getSingleResult());
		System.out.println(type+" : "+number);
		
		System.out.println("maxminCreateQuery ends");
	}
	
	public static void modCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("modCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE MOD(emp.empSalary,11)=0 ");
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("modCreateQuery ends");
	}
	
	public static void parameterizedCreateQuery2(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("parameterizedCreateQuery2 starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE emp.empSalary=?1 OR emp.empName=?2");
		query.setParameter(1, "250000");
		query.setParameter(2, "Bhatiyaji");
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("parameterizedCreateQuery2 ends");
	}
	
	public static void parameterizedCreateQuery3(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("parameterizedCreateQuery3 starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp WHERE emp.empSalary>:sal ");
		query.setParameter("sal", "250000");
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("parameterizedCreateQuery3 ends");
	}
	
	public static void resultListCreateQuery(EntityManager entityManager) {
		System.out.println("========================================================================================================================");
		System.out.println("resultListCreateQuery starts");
		
		Query query=entityManager.createQuery("SELECT emp FROM EmployeeEntityBean emp ");
		query.setFirstResult(2);
		List<EmployeeEntityBean> list=query.getResultList();
		Iterator<EmployeeEntityBean> iterator=list.iterator();
		while(iterator.hasNext()) {
			EmployeeEntityBean employeeEntityBean=iterator.next();
			System.out.println(employeeEntityBean);
		}
		
		System.out.println("resultListCreateQuery ends");
	}
	
	public static void listCreateNativeQuery(EntityManager entityManager,String byAttributeType) {
		System.out.println("========================================================================================================================");
		System.out.println("listCreateNativeQuery starts");
		
		Query query=entityManager.createNativeQuery("SELECT "+byAttributeType+" FROM Employee501 ORDER BY "+byAttributeType+" desc");
		List<String> list=query.getResultList();
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			String str=iterator.next();
			System.out.print(str+" ");
		}
		
		System.out.println("\nlistCreateNativeQuery ends");
	}
	
	public static void orderByNativeCreateQuery(EntityManager entityManager,String order) {
		System.out.println("========================================================================================================================");
		System.out.println("orderByNativeCreateQuery starts");
		
		Query query=entityManager.createNativeQuery("SELECT emp_salary FROM Employee501 emp ORDER BY emp_salary "+order);
		List list=query.getResultList();
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			BigDecimal bigDecimal=new BigDecimal(iterator.next());
			System.out.print(bigDecimal+"  ");
		}
		
		System.out.println("orderByNativeCreateQuery ends");
	}
	
	
	
}