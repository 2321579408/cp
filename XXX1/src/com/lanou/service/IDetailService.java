package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;

public interface IDetailService {

	
	public List<Cart> all(String uid) throws Exception;
}
