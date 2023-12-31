package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "responses")
public class Response 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int rid;
	
	@ManyToOne()
	@JoinColumn(name="request_id")
	private Request reqid;
	
	@ManyToOne()
	@JoinColumn(name="vendor_id")
	private Vendor vid;
	
	@Column
	Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column
	String description;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(int rid, Request reqid, Vendor vid, String description) {
		super();
		this.rid = rid;
		this.reqid = reqid;
		this.vid = vid;
		this.description = description;
	}
	
	
	
	
	public Response(int rid) {
		super();
		this.rid = rid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Request getReqid() {
		return reqid;
	}
	public void setReqid(Request reqid) {
		this.reqid = reqid;
	}
	public Vendor getVid() {
		return vid;
	}
	public void setVid(Vendor vid) {
		this.vid = vid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
