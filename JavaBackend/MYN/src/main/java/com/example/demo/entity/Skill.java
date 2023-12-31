package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="skill")
 public class Skill {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int skill_id;
  @Column
  String skill_name;
  @Column
  String description;
  @ManyToOne()
  @JoinColumn(name = "category_id ")
   Category category_id;
   public Skill() {
	
    }
public Skill(int skill_id, String skill_name, String description, Category category_id) {
	
	this.skill_id = skill_id;
	this.skill_name = skill_name;
	this.description = description;
	this.category_id = category_id;
}
public Skill(int skill_id) {
	
	this.skill_id = skill_id;
}
public Skill(String skill_name) {
	
	this.skill_name = skill_name;
}
public Skill(Category category_id) {
	
	this.category_id = category_id;
}
public int getSkill_id() {
	return skill_id;
}
public void setSkill_id(int skill_id) {
	this.skill_id = skill_id;
}
public String getSkill_name() {
	return skill_name;
}
public void setSkill_name(String skill_name) {
	this.skill_name = skill_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Category getCategory_id() {
	return category_id;
}
public void setCategory_id(Category category_id) {
	this.category_id = category_id;
}
@Override
public String toString() {
	return "Skill [skill_id=" + skill_id + ", skill_name=" + skill_name + ", description=" + description
			+ ", category_id=" + category_id + "]";
}
   
	
}
