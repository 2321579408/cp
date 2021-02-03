package com.lanou.bean;

import java.io.Serializable;

public class Detail implements Serializable{

	private Integer id;
	
	private Integer store;
	
	private String imgs;

	public Detail() {
		super();
	}

	public Detail(Integer id, Integer store, String imgs) {
		super();
		this.id = id;
		this.store = store;
		this.imgs = imgs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	
	
	
}
