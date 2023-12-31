package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;
    
	@OneToOne
    @JoinColumn(name = "response_id")
    private Response responseId;
    
    @Column(name = "tracking_id")
    private Integer trackingId;
    
    @Column(name = "start_time")
    private Date startTime;
    
    @Column(name = "end_time")
    private Date endTime;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Integer projectId, Response responseId, Integer trackingId, Date startTime,
			Date endTime) {
		super();
		this.projectId = projectId;
		this.responseId = responseId;
		this.trackingId = trackingId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	

	public Project(Integer projectId) {
		super();
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Response getResponseId() {
		return responseId;
	}

	public void setResponseId(Response responseId) {
		this.responseId = responseId;
	}

	public Integer getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", responseId=" + responseId + ", trackingId=" + trackingId
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
    
    
    
    
}
