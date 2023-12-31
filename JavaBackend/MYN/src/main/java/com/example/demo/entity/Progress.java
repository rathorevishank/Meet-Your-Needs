package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="progress")
public class Progress 
{
 @Id
 @GeneratedValue()
 @Column(name="progress_id")
 int progressid;
 
 @Column (name="progress_name")
 String progressname;

public Progress() {

}

public Progress(int progressid, String progressname) {

	this.progressid = progressid;
	this.progressname = progressname;
}

public int getProgressid() {
	return progressid;
}

public void setProgressid(int progressid) {
	this.progressid = progressid;
}

public String getProgressname() {
	return progressname;
}

public void setProgressname(String progressname) {
	this.progressname = progressname;
}

@Override
public String toString() {
	return "Progress [progressid=" + progressid + ", progressname=" + progressname + "]";
}
 
 
}
