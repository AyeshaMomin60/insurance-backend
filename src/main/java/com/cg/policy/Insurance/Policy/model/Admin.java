package com.cg.policy.Insurance.Policy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aymomin This class includes declaration of parameters of 
 *         Admin class, default constructor, parameterized constructors, getter
 *         and setter methods of parameters and toString method to display.
 */
@Entity
@Table(name = "Admin_Table")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "adminId")
	private int adminId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Mobile")
	private String mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "Role")
	private String role;

	@Column(name = "Status")
	private String status;

	public Admin() {
		super();
	}

	public Admin(int adminId, String name, String email, String mobile, String password, String role, String status) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}

}
