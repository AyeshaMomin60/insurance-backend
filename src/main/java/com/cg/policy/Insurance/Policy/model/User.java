package com.cg.policy.Insurance.Policy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Aymomin This class includes declaration of parameters of 
 *         user class, default constructor, parameterized constructors, getter
 *         and setter methods of parameters and toString method to display.
 */
@Entity
@Table(name = "User_Table")

public class User {
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private int userId;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "Name")
	private String name;

	@Column(name = "Mobile")
	private String mobile;

	@Column(name = "Role")
	private String role;

	@Column(name = "Status")
	private String status;

	@OneToOne
	@JoinColumn(name = "planId")
	private Policy policy;

//    @OneToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "paymentId")
//    private Payment payments;

	public User() {
		super();

	}

public User(int userId, String password, String email, String name, String mobile, String role, String status,
		Policy policy) {
	super();
	this.userId = userId;
	this.password = password;
	this.email = email;
	this.name = name;
	this.mobile = mobile;
	this.role = role;
	this.status = status;
	this.policy = policy;
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Policy getPolicy() {
	return policy;
}

public void setPolicy(Policy policy) {
	this.policy = policy;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", name=" + name + ", mobile="
			+ mobile + ", role=" + role + ", status=" + status + ", policy=" + policy + "]";
}

	
}