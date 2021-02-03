package com.lanou.service;

import com.lanou.dao.AdminDao;

public class AdminServiceImpl implements AdminService {
	
	
	private AdminDao dao;
	
	
	public void init() {
		System.out.println("我是init方法");
	}

	@Override
	public void ss() {
		dao.bb();
	}

	
	
	
	
	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	
	
}
