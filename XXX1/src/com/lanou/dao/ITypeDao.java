package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeDao {
	public Type get(int type) throws Exception;
	
	
	public List<Type> getallById(int parentid) throws Exception;
	
	public void update(String id,String title) throws Exception;

	public void add(String parentid,String title) throws Exception;
	
	public void del(String id) throws Exception;
}
