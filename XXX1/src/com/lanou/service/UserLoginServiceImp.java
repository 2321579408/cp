package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;
import com.lanou.dao.IUserLoginDao;
import com.lanou.dao.UserLoginDaoImpl;

public class UserLoginServiceImp implements IUserLoginService{
	private IUserLoginDao UserDao = new UserLoginDaoImpl();
	@Override
	public User login(String name, String pwd) throws Exception {
		return UserDao.login(name, pwd);
	}
	
	public void add(String name, String pwd, String phone, String mail, String address) throws Exception{
		UserDao.add(name, pwd, phone, mail, address);
	}

}
