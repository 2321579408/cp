package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeDaoService {

	public List<Type> getallById() throws Exception;

	public void update(String id, String title) throws Exception;
	
	public void add(String parentid,String title) throws Exception;
	
	public void del(String id) throws Exception;
}
