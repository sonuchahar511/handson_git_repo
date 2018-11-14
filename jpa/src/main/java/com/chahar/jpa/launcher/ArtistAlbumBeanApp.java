package com.chahar.jpa.launcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.chahar.jpa.entity.onetomany.AlbumEntityBean;
import com.chahar.jpa.entity.onetomany.ArtistEntityBean;
import com.chahar.jpa.relationship.entity.DepartmentEntityBean;
import com.chahar.jpa.relationship.entity.StudentEntityBean;

public class ArtistAlbumBeanApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		persistRecordOneToMany(entityManager);
		
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void persistRecordOneToMany(EntityManager entityManager) {
		
		System.out.println("========================================================================================================================");
		System.out.println("persistRecordOneToMany() starts");
		
		ArtistEntityBean artist=new ArtistEntityBean(2019,"Baadshah");
		AlbumEntityBean album1=new AlbumEntityBean(901,"Heart",2018);
		AlbumEntityBean album2=new AlbumEntityBean(902,"vtw",2018);
		AlbumEntityBean album3=new AlbumEntityBean(903,"Sultan",2018);
		
		List<AlbumEntityBean> list=new ArrayList<AlbumEntityBean>();
		list.add(album1);
		list.add(album2);
		list.add(album3);
		
		artist.setAlbums(list);
		System.out.println(artist);
		entityManager.persist(artist);
		
		System.out.println("persistRecordOneToMany() ends");
	}
	
}
