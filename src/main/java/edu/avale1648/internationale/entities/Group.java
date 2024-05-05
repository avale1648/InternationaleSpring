package edu.avale1648.internationale.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {
	// id, name, cakeday, mature, rating, pfp, banner, description
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

	public Group(Group that) {
		this.name = that.name;
		this.cakeday = that.cakeday;
		this.mature = that.mature;
		this.rating = that.rating;
		this.pfp = that.pfp;
		this.banner = that.banner;
		this.description = that.description;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer value) {
		id = value;
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

	// id, name, cakeday, mature, rating, pfp, banner, description
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}
		Group g = (Group) o;
		return Objects.equals(id, g.id) && Objects.equals(name, g.name) && Objects.equals(cakeday, g.cakeday)
				&& Objects.equals(mature, g.mature) && Objects.equals(rating, g.rating) && Objects.equals(pfp, g.pfp)
				&& Objects.equals(banner, g.banner) && Objects.equals(description, g.description);
	}

	// id, name, cakeday, mature, rating, pfp, banner, description
	@Override
	public int hashCode() {
		return Objects.hash(id, name, cakeday, mature, rating, pfp, banner, description);
	}

	@Override
	public String toString() {
		return String.format("id: %d, name:%s, cakeday:%s, mature:%b, rating:%d, pfp:%s, banner:%s, description%s", id,
				name, cakeday, mature, rating, pfp, banner, description);
	}
}
