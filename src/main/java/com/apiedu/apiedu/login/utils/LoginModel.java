package com.apiedu.apiedu.login.utils;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginModel implements Serializable {
	private static final long serialVersionUID = -8276580439429949233L;
	
	@Id
	private Integer id;
	
	public LoginModel() {
	}

	public LoginModel(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoginModel [id=" + id + "]";
	}
	
	
}
