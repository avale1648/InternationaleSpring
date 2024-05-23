package edu.avale1648.internationale.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Timestamp postdate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Group group;
	private String text;
	private Integer rating;
	private List<String> files;

	public Post() {
		postdate = Timestamp.valueOf(LocalDateTime.now());
		rating = 0;
		files = new ArrayList<>();
	}

	public Post(User user, Group group, String text) {
		this();
		this.user = user;
		this.group = group;
		this.text = text;
	}

	public Post(Post that) {
		this.postdate = that.postdate;
		this.user = new User(that.user);
		this.group = new Group(that.group);
		this.text = that.text;
		this.rating = that.rating;
		for (String file : that.files) {
			this.files.add(file);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		id = value;
	}

	public Timestamp getPostdate() {
		return postdate;
	}

	public User getUser() {
		return user;
	}

	public Group getGroup() {
		return group;
	}

	public String getText() {
		return text;
	}

	public void setText(String value) {
		text = value;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer value) {
		rating += value;
	}

	public void addFile(String file) {
		files.add(file);
	}

	public void removeFile(String file) {
		files.remove(file);
	}
}
