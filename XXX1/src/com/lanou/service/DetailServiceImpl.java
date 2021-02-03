package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.dao.DetailDaoImpl;
import com.lanou.dao.IDetailDao;

public class DetailServiceImpl implements IDetailService{
	private IDetailDao detailDao=new DetailDaoImpl();
	@Override
	public List<Cart> all(String uid) throws Exception {
		return detailDao.all(uid);
	}

}
