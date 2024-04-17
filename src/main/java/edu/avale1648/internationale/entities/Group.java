package edu.avale1648.internationale.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Timestamp cakeday;
	private boolean mature;
	
	private Integer rating;
	private String pfp;
	private String banner;
	private String description;
	
	public Group() {
		cakeday = Timestamp.valueOf(LocalDateTime.now());
		rating = 0;
	}
	
	public Group(String name, boolean mature) {
		this();
		
		this.name = name;
		this.mature = mature;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public Timestamp getCakeday() {
		return cakeday;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(Integer value) {
		rating += value;
	}
	
	public String getPfp() {
		return pfp;
	}

	public void setPfp(String value) {
		pfp = value;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String value) {
		banner = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		description = value;
	}
	
	public boolean getMature() {
		return mature;
	}
}
