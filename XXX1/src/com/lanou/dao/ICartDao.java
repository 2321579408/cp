package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Cart;

public interface ICartDao {
	
	public List<Cart> all(int pagenum, int pagecount) throws Exception;
	
	public int count() throws Exception;
	
	public void add(String userid,String productid) throws Exception;
	
	public 	Cart queryById(String pid) throws Exception;
	
	public 	void del(int id1) throws Exception;
}
