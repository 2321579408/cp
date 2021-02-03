package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.dao.CartDaoImpl;
import com.lanou.dao.ICartDao;

public class CartServiceImpl implements ICartService {
	private ICartDao cartDao=new CartDaoImpl();
	@Override
	public List<Cart> all(int pagenum, int pagecount) throws Exception {
		return cartDao.all(pagenum, pagecount);
	}
	@Override
	public int count() throws Exception {
		return cartDao.count();
	}
	@Override
	public void add(String userid, String productid) throws Exception {
		cartDao.add(userid, productid);
	}
	@Override
	public Cart queryById(String pid) throws Exception {
		return cartDao.queryById(pid);
		
		
	}
	@Override
	public void del(int id1) throws Exception {
		cartDao.del(id1);
		
	}

}
