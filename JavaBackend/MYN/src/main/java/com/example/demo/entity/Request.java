package com.example.demo.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int rid;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "description")
	private String pid;

	@Column(name = "request_date")
	Date rdate;
	@Column(name = "budget")
	double budget;
	@Column
	int status;
	
	@Column
	Date deadline;
	
	@Column
	String title;
	
	@OneToMany(mappedBy = "reqid")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties("reqid")
    Set<Response> responses;
	
	@ManyToOne()
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties("requests")
    private Client client;
	
	public Client getClient() {
		return client;
	}
	
	public Request(int rid) {
		super();
		this.rid = rid;
	}



	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Response> getResponses() {
		return responses;
	}
	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int rid, Category ctid, String pid, Date rdate, double budget, int status, Set<Response> responses,
			Client client) {
		super();
		this.rid = rid;
		category = ctid;
		this.pid = pid;
		this.rdate = rdate;
		this.budget = budget;
		this.status = status;
		this.responses = responses;
		this.client = client;
	}
	
	
	
	public Request(int rid, Category category, String pid, Date rdate, double budget, int status, Date deadline,
			String title, Set<Response> responses, Client client) {
		super();
		this.rid = rid;
		this.category = category;
		this.pid = pid;
		this.rdate = rdate;
		this.budget = budget;
		this.status = status;
		this.deadline = deadline;
		this.title = title;
		this.responses = responses;
		this.client = client;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category ctid) {
		category = ctid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Request [rid=" + rid + ", category=" + category + ", pid=" + pid + ", rdate=" + rdate + ", budget="
				+ budget + ", status=" + status + ", deadline=" + deadline + ", title=" + title + ", responses="
				+ responses + ", client=" + client + "]";
	}
	
	
	
	

	
	
	
}
