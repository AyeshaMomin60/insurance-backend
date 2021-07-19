package com.cg.policy.Insurance.Policy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Aymomin This class includes declaration of parameters of 
 *         EnrollmentRequest class, default constructor, parameterized constructors, getter
 *         and setter methods of parameters and toString method to display.
 */
@Entity
@Table(name = "EnrollmentTable")
public class EnrollmentRequest {

	@Id
	@GeneratedValue
	@Column(name = "EnrollmentId")
	private int enrollmentId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne
	@JoinColumn(name = "planId")
	private Policy policy;

	public EnrollmentRequest() {
		super();

	}

	public EnrollmentRequest(int enrollmentId, User user, Policy policy) {
		super();
		this.enrollmentId = enrollmentId;
		this.user = user;
		this.policy = policy;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "EnrollmentRequest [enrollmentId=" + enrollmentId + ", user=" + user + ", policy=" + policy + "]";
	}

	
}
