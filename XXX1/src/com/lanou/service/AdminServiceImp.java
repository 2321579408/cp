package com.lanou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lanou.Util.SqlsessionUtil;
import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;

public class AdminServiceImp implements IAdminService{
	
	private IAdminDao adminDao=new AdminDaoImpl();
	
	private IAdminDao aDao=(IAdminDao) SqlsessionUtil.get(adminDao.getClass());

	@Override
	public Admin getall(String adminname, String pwd) throws Exception {
		return aDao.getall(adminname, pwd);
	}

	@Override
	public List<Admin> getadmin() throws Exception {
		return adminDao.getadmin();
	}

	@Override
	public int getCount() throws Exception {
		return adminDao.getCount();
	}

	@Override
	public void adminadd(String adminname, String pwd) throws Exception {
		adminDao.adminadd(adminname, pwd);
	}

	@Override
	public void admindel(String id) throws Exception {
		
		adminDao.admindel(id);
	}

	
	

}
