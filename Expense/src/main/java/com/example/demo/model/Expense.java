package com.example.demo.model;


import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="expense")
public class Expense {

	@Id
	private int id;
	
	private Instant expensedate;
	
	private String description;
	
	private String location;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Instant getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	


	


	@Override
	public String toString() {
		return "Expense [id=" + id + ", expensedate=" + expensedate + ", description=" + description + ", location="
				+ location + ", category=" + category + "]";
	}

	public Expense() {
		super();
	}



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	

}