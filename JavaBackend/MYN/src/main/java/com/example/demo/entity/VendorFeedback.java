package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vendor_feedback")
public class VendorFeedback {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;
    
    @Column(name = "rating")
    private int rating;
    
    @Column(name = "comment")
    private String comment;
    
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project projectId;

	public int getFeedbackId() {
		return feedbackId;
	}
	
	@ManyToOne()
    @JoinColumn(name = "vendor_id")
    @JsonIgnoreProperties("feedback")
    private Vendor vendor;

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public VendorFeedback(int feedbackId, int rating, String comment, Project projectId) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comment = comment;
		this.projectId = projectId;
	}

	public VendorFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VendorFeedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comment=" + comment
				+ ", projectId=" + projectId + "]";
	}
    
    
}
