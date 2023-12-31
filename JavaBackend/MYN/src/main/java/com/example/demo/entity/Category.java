package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_id;
	@Column
	String category_name;
	@Column
	String description;
	public Category() {
		
	}
	public Category(int category_id, String category_name, String description) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.description = description;
	}
	public Category(int category_id) {
		
		this.category_id = category_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + ", description="
				+ description + "]";
	}
	
    
	

}
