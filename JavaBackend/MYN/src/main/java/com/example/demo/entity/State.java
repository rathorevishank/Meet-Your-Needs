package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "state")
public class State {

    public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(Integer stateId) {
		super();
		this.stateId = stateId;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer stateId;
    
    @Column(name = "state_name")
    private String stateName;
    
    @OneToMany(mappedBy = "state")
    @Cascade(CascadeType.ALL)
    @JsonIgnoreProperties("state")
    Set<City> cities;
    
    public Integer getStateId() {
        return stateId;
    }
    
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}

