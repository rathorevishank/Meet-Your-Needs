package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue()
	@Column(name = "payment_id")
	int paymentid;
	@Column(name = "payment_detail")
	String paymentdetail;
	@Column(name = "initial_payment")
	double initialpayment;
	@Column(name = "final_payment")
	double finalPayment;
	@Column
	Date date;
	@Column(name = "transaction_id")
	String tid;
	@Column(name = "mode_of_payment")
	String mode;
	
	@OneToOne
	@JoinColumn(name= "project_id")
	Project project;

	public Payment() {

	}

	public Payment(int paymentid, String paymentdetail, double initialpayment, double finalPayment, Date date,
			String tid, String mode) {

		this.paymentid = paymentid;
		this.paymentdetail = paymentdetail;
		this.initialpayment = initialpayment;
		this.finalPayment = finalPayment;
		this.date = date;
		this.tid = tid;
		this.mode = mode;
	}

	public Payment(int paymentid) {
		super();
		this.paymentid = paymentid;
	}

	public Payment(String paymentdetail) {
		super();
		this.paymentdetail = paymentdetail;
	}

	public Payment(double initialpayment) {
		super();
		this.initialpayment = initialpayment;
	}

	public Payment(Date date) {
		super();
		this.date = date;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentdetail() {
		return paymentdetail;
	}

	public void setPaymentdetail(String paymentdetail) {
		this.paymentdetail = paymentdetail;
	}

	public double getInitialpayment() {
		return initialpayment;
	}

	public void setInitialpayment(double initialpayment) {
		this.initialpayment = initialpayment;
	}

	public double getFinalPayment() {
		return finalPayment;
	}

	public void setFinalPayment(double finalPayment) {
		this.finalPayment = finalPayment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", paymentdetail=" + paymentdetail + ", initialpayment="
				+ initialpayment + ", finalPayment=" + finalPayment + ", date=" + date + ", tid=" + tid + ", mode="
				+ mode + "]";
	}

}
