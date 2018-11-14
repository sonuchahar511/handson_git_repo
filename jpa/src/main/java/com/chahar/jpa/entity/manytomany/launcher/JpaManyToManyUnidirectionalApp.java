package com.chahar.jpa.entity.manytomany.launcher;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.chahar.jpa.entity.manytomany.ArtistEntity;
import com.chahar.jpa.entity.manytomany.GenreEntity;

public class JpaManyToManyUnidirectionalApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DucatJPA1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		/*
		GenreEntity genre1=new GenreEntity(301,"Rock");
		GenreEntity genre2=new GenreEntity(302,"Indie");
		GenreEntity genre3=new GenreEntity(303,"English");
		
		ArtistEntity artist1=new ArtistEntity(100,"Sonu Nigam");
		ArtistEntity artist2=new ArtistEntity(101,"Kumar Sanu");
//		entityManager.persist(artist1);
//		entityManager.persist(artist2);
		
		List<ArtistEntity> list1=new ArrayList<ArtistEntity>();
		list1.add(artist1);
		list1.add(artist2);
		genre1.setArtists(list1);
		
		List<ArtistEntity> list2=new ArrayList<ArtistEntity>();
		list2.add(artist1);
		genre2.setArtists(list2);
		
		List<ArtistEntity> list3=new ArrayList<ArtistEntity>();
		list3.add(artist2);
		genre3.setArtists(list3);
		
		entityManager.persist(genre1);
		entityManager.persist(genre2);
		entityManager.persist(genre3);
		
		entityTransaction.commit();*/
		
		
		//entityTransaction.begin();
		
		GenreEntity genre=entityManager.find(GenreEntity.class, new Integer(301));
		System.out.println("---Finding Genres---");
		System.out.println(genre);
		
		
		//entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
