package com.chahar.jpa.entity.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres70")
public class GenreEntity {
	
	@Id
	@Column(name="genre_id")
	private int id;
	
	@Column(name="genre_name")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="genres70_artist70", 
		joinColumns=@JoinColumn(name="genre_id1"),
		inverseJoinColumns=@JoinColumn(name="artist_id2"))
	private List<ArtistEntity> artists;

	public GenreEntity() {}

	public GenreEntity(int id, String name) {
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
	public List<ArtistEntity> getArtists() {
		return artists;
	}
	public void setArtists(List<ArtistEntity> artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		/*StringBuilder sb = new StringBuilder("");
		if(artists != null) {
			for(ArtistEntity artist : artists) {
				sb.append(artist);
			}
		}
		*/
		return "Genre [id=" + id + ", name=" + name + ", artists=" + artists + "]";
	}
	
}
