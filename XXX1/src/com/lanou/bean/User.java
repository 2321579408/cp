package com.lanou.bean;

import java.io.Serializable;

public class User implements Serializable{
	
	private Integer id;
	
	private String name;
	
	private String pwd;
	
	private String phone;
	
	private String mail;
	
	private String address;
	
	private String backup1;
	
	private String backup2;
	
	private String backup3;
	
	public User() {
		super();
	}
	
	

	public User(Integer id, String name, String pwd, String phone, String mail, String address) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.mail = mail;
		this.address = address;
	}
	
	

	public User(Integer id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}



	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
