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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
	int vendorid;
	
	@OneToOne
	@JoinColumn(name="user_id")
	User userid;
	
	@OneToOne
	@JsonIgnoreProperties("v_id")
	@JoinColumn(name = "portfolio")
	VendorPortfolio port;
	
	@OneToMany(mappedBy = "vendor")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties("vendor")
    Set<VendorFeedback> feedback;
	

	public VendorPortfolio getPort() {
		return port;
	}

	public void setPort(VendorPortfolio port) {
		this.port = port;
	}

	public Vendor() {
		super();
		
	}

	public Vendor(int vendorid, User userid) {
		super();
		this.vendorid = vendorid;
		this.userid = userid;
	}

	public Vendor(int vendorid) {
		super();
		this.vendorid = vendorid;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", userid=" + userid + "]";
	}
	
    
}
