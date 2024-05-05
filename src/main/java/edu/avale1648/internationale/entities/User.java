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
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// id, name, email, password, birthday, cakeday, rating, pfp, banner,
	// description
	private Integer id;
	private String name;
	private String email;
	private String password;
	private Timestamp birthday;
	private Timestamp cakeday;

	private Integer rating;
	private String pfp;
	private String banner;
	private String description;

	public User() {
		cakeday = Timestamp.valueOf(LocalDateTime.now());
		rating = 0;
	}

	public User(String name, String email, String password, String birthday) {
		this();

		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = Timestamp.valueOf(birthday);
	}

	public User(User that) {
		this.name = that.name;
		this.email = that.email;
		this.password = that.password;
		this.birthday = that.birthday;
		this.cakeday = that.cakeday;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String value) {
		email = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp value) {
		birthday = value;
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

	// id, name, email, password, birthday, cakeday, rating, pfp, banner,
	// description
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}
		User u = (User) o;
		return Objects.equals(id, u.id) && Objects.equals(name, u.name) && Objects.equals(password, u.password)
				&& Objects.equals(birthday, u.birthday) && Objects.equals(cakeday, u.cakeday)
				&& Objects.equals(rating, u.rating) && Objects.equals(pfp, u.pfp) && Objects.equals(banner, u.banner)
				&& Objects.equals(description, u.description);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, email, password, birthday, cakeday, rating, pfp, banner, description);
	}
	
	@Override
	public String toString() {
		return String.format("id:%d, name:%s, email:%s, birthday:%s, cakeday:%s, rating:%d, description:%s", id, name, email, birthday, cakeday, rating, description);
	}
}
