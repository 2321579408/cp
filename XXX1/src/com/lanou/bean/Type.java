package com.lanou.bean;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
	
	private Integer id;
	
	private String title;
	
	private Integer parentid;
	
	private List<Type> children;

	public Type() {
		super();
	}

	public Type(Integer id, String title, Integer parentid, List<Type> children) {
		super();
		this.id = id;
		this.title = title;
		this.parentid = parentid;
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getparentid() {
		return parentid;
	}

	public void setparentid(Integer parentid) {
		this.parentid = parentid;
	}

	public List<Type> getChildren() {
		return children;
	}

	public void setChildren(List<Type> children) {
		this.children = children;
	}

	
}
