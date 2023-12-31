package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question questionId;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "answer")
    private String answer;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City cityId;

    @OneToOne
    @JoinColumn(name = "state_id")
    private State stateId;

    @Column(name = "adhar_no")
    private String adharNo;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    private int status;

    public User() {
        // default constructor
    }

	public User(int userId, String password, String email, Role roleId, Question questionId, Date birthdate,
			String phoneNo, String answer, City cityId, State stateId, String adharNo, String address,
			String nationality, String firstName, String lastName, int status) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.role = roleId;
		this.questionId = questionId;
		this.birthdate = birthdate;
		this.phoneNo = phoneNo;
		this.answer = answer;
		this.cityId = cityId;
		this.stateId = stateId;
		this.adharNo = adharNo;
		this.address = address;
		this.nationality = nationality;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}
	

	public User(int userId) {
		super();
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role roleId) {
		this.role = roleId;
	}

	public Question getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", roleId=" + role
				+ ", questionId=" + questionId + ", birthdate=" + birthdate + ", phoneNo=" + phoneNo + ", answer="
				+ answer + ", cityId=" + cityId + ", stateId=" + stateId + ", adharNo=" + adharNo + ", address="
				+ address + ", nationality=" + nationality + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", status=" + status + "]";
	}

    
    
}
