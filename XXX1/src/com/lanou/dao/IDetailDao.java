package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Cart;

public interface IDetailDao {
	
	public List<Cart> all(String uid) throws Exception;

}
