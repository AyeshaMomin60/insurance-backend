package com.cg.policy.Insurance.Policy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

/**
 * @author Aymomin This class includes declaration of parameters of 
 *         Login class, default constructor, parameterized constructors, getter
 *         and setter methods of parameters and toString method to display.
 */
@Table(name = "Login_Table")
public class Login {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "type")
	private char type;

	public Login() {
		super();
	}

	public Login(int id, String mobile, String password, char type) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.password = password;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", mobile=" + mobile + ", password=" + password + ", type=" + type + "]";
	}

}
