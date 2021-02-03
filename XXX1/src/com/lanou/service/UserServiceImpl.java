package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;
import com.lanou.dao.IUserDao;
import com.lanou.dao.UserDaoImpl;

public class UserServiceImpl implements IUserService{
	private IUserDao userdao=new UserDaoImpl();

	@Override
	public List<User> getByPage(int pagenum, int pagecount) throws Exception {
		return userdao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getcount() throws Exception {
		return userdao.getcount();
	}

	@Override
	public void add(String name, String pwd, String phone, String mail, String address) throws Exception {
		userdao.add(name, pwd, phone, mail, address);
	}

	@Override
	public void del(String id) throws Exception {
		userdao.del(id);
	}

	@Override
	public void update(String id, String name, String pwd, String phone, String mail, String address) throws Exception {
		userdao.update(id, name, pwd, phone, mail, address);
	}

	
	

}
