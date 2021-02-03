package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;

public interface IUserService {
	
	public List<User> getByPage(int pagenum, int pagecount) throws Exception;
	
	public int getcount() throws Exception;
	
	public void add(String name, String pwd, String phone, String mail, String address) throws Exception;

	public void del(String id) throws Exception;

	public void update(String id,String name, String pwd, String phone, String mail, String address) throws Exception;
}
