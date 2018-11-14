package com.chahar.jpa.entity.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist70")
public class ArtistEntity {

	@Id
	@Column(name="artist_id")
	private int id;
	
	@Column(name="artist_name")
	private String name;
	
	@ManyToMany(mappedBy="artists")
	private List<GenreEntity> genres;
	

	public ArtistEntity() {}
	
	public ArtistEntity(int id, String name) {
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
	/*public List<GenreEntity> getGenres() {
		return genres;
	}
	public void setGenres(List<GenreEntity> genres) {
		this.genres = genres;
	}*/

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		if(genres != null) {
			for(GenreEntity genre : genres) {
				sb.append(genre.getId()+",");
			}
		}
		return "Artist [id=" + id + ", name=" + name + ", genres=" + sb.toString() + "]";
	}
}
