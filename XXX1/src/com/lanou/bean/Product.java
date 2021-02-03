package com.lanou.bean;

import java.io.Serializable;

public class Product implements Serializable{
	
	private int id;
	
	private String pname;
	
	private String pimg;
	
	private String price;
	
	private String ptitle;
	
	private Integer pv;
	
	private String biaoqian;
	
	private String typeid;

	public Product(int id, String pname, String pimg, String price, String ptitle, Integer pv,String biaoqian, String typeid) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.biaoqian = biaoqian;
		this.typeid = typeid;
	}
	
	

	public Product(int id, String pname, String pimg, String price, String ptitle, Integer pv, String typeid) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeid = typeid;
	}



	public Product(String pname, String pimg, String price, String ptitle, Integer pv,String biaoqian, String typeid) {
		super();
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.biaoqian = biaoqian;
		this.typeid = typeid;
	}

	public String getBiaoqian() {
		return biaoqian;
	}

	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
	

}
