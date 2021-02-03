package com.lanou.bean;

import java.io.Serializable;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int userid;
	
	private String  uname;
	
	private int productid;
	
	private String pname;
	
	private String phone;
	
	private String price;
	
	private int count;

	public Cart() {
		super();
	}
	
	

	public Cart(int id, int userid, String uname, int productid, String pname, String phone, String price) {
		super();
		this.id = id;
		this.userid = userid;
		this.uname = uname;
		this.productid = productid;
		this.pname = pname;
		this.phone = phone;
		this.price = price;
	}



	public Cart(int id, int userid, String uname, int productid, String pname, String phone, String price,int count) {
		super();
		this.id = id;
		this.userid = userid;
		this.uname = uname;
		this.productid = productid;
		this.pname = pname;
		this.phone = phone;
		this.price = price;
		this.count = count;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUsername(String uname) {
		this.uname = uname;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Cart(int userid, String uname, int productid, String pname, String phone, String price) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.productid = productid;
		this.pname = pname;
		this.phone = phone;
		this.price = price;
	}

	
}
