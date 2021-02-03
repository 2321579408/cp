package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;

public interface IUserLoginService {
	
	public User login(String name,String pwd) throws Exception;
	
	public void add(String name, String pwd, String phone, String mail, String address) throws Exception;

}
