package org.git.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 4660939413105093769L;
	
	private int id;
	@NotNull
	@NotEmpty(message="Name can't be empty")
	private String name;
	@NotNull
	@NotEmpty(message="Country can't be empty")
	private String country;
	
	public Person(){
		super();
	}
	
	@Id
	@GeneratedValue
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
