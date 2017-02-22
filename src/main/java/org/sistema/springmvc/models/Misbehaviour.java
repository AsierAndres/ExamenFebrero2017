package org.sistema.springmvc.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents a misbehaviour.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Entity
public class Misbehaviour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, max = 100, message = "Login must be between 1 and 100 characters long")
	@Pattern(regexp = "[A-Za-z0-9]+", message = "Must contain only chars and numbers")
	private String title;


	@Past (message="Only the past is valid")
	private Date date = new Date();
	
	@Size(min = 1, max = 255, message = "Login must be between 1 and 100 characters long")
	private String description;

    @ManyToOne
    @JoinColumn(name="userId")
	private User user = new User();

	public Misbehaviour() {
	}

	/**
	 * @param id
	 * @param title
	 * @param date
	 * @param description
	 * @param user
	 */
	public Misbehaviour(Long id, String title, Date date, String description, User user) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.description = description;
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Misbehaviour [id=" + id + ", title=" + title + ", date=" + date + ", description=" + description + ", user="
				+ user + "]";
	}



	
}
