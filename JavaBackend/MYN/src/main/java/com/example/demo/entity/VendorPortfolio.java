package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.DocFlavor.BYTE_ARRAY;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vendor_portfolio")
public class VendorPortfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portfolio_id")
	int portfolioid;

	@OneToOne
	@JsonIgnoreProperties("port")
	@JoinColumn(name = "vendor_id")
	Vendor v_id;

	@OneToOne
	@JoinColumn(name = "category_id")
	Category category_id;

	@OneToMany(mappedBy = "skill_id")
	@Cascade(CascadeType.ALL)
	Set<Skill> skill_id;
	@Column
	String about;
	
	@Column(name = "price_per_hour")
	double price;
	
	@Column(name = "portfolio_file")
	BYTE_ARRAY file;
	
	@Column(name ="experience")
	int experience;

	public VendorPortfolio() {

	}

	public VendorPortfolio(int portfolioid, Vendor v_id, Category category_id, Set<Skill> skill_id, String about,
			double price, BYTE_ARRAY file) {

		this.portfolioid = portfolioid;
		this.v_id = v_id;
		this.category_id = category_id;
		this.skill_id = skill_id;
		this.about = about;
		this.price = price;
		this.file = file;
	}

	
	
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public VendorPortfolio(int portfolioid) {

		this.portfolioid = portfolioid;
	}

	public VendorPortfolio(Vendor v_id) {

		this.v_id = v_id;
	}

	public VendorPortfolio(Category category_id) {

		this.category_id = category_id;
	}

	public VendorPortfolio(Set<Skill> skill_id) {

		this.skill_id = skill_id;
	}

	public VendorPortfolio(String about) {

		this.about = about;
	}

	public VendorPortfolio(double price) {

		this.price = price;
	}

	public VendorPortfolio(BYTE_ARRAY file) {

		this.file = file;
	}

	public int getPortfolioid() {
		return portfolioid;
	}

	public void setPortfolioid(int portfolioid) {
		this.portfolioid = portfolioid;
	}

	public Vendor getV_id() {
		return v_id;
	}

	public void setV_id(Vendor v_id) {
		this.v_id = v_id;
	}

	public Category getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}

	public Set<Skill> getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Set<Skill> skill_id) {
		this.skill_id = skill_id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BYTE_ARRAY getFile() {
		return file;
	}

	public void setFile(BYTE_ARRAY file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "VendorPortfolio [portfolioid=" + portfolioid + ", v_id=" + v_id + ", category_id=" + category_id
				+ ", skill_id=" + skill_id + ", about=" + about + ", price=" + price + ", file=" + file + "]";
	}

}
