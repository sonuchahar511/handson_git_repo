package com.chahar.jpa.entity.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artists")
public class ArtistEntityBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="artist_id")
	private List<AlbumEntityBean> albums;
	
	public ArtistEntityBean() {}
	public ArtistEntityBean(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AlbumEntityBean> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumEntityBean> albums) {
		this.albums = albums;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ArtistEntityBean [id=" + id + ", name=" + name + ", albums=" + albums + "]";
	}

}
