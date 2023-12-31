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
@Table()
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientId;
    
	@OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "company_location")
    private String companyLocation;
    
    @OneToMany(mappedBy = "rid")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties("rid")
    Set<Request> requests;

    public int getClientId() {
        return clientId;
    }

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int clientId, User userId, String companyName, String companyLocation, Set<Request> requests) {
		super();
		this.clientId = clientId;
		this.userId = userId;
		this.companyName = companyName;
		this.companyLocation = companyLocation;
		this.requests = requests;
	}

	public Client(int clientId) {
		super();
		this.clientId = clientId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", userId=" + userId + ", companyName=" + companyName
				+ ", companyLocation=" + companyLocation + ", requests=" + requests + "]";
	}
    
    
    
    
    
    
}
