package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.User;

public class UserLoginDaoImpl implements IUserLoginDao{

	@Override
	public User login(String name, String pwd) throws Exception {
		
		String sql="select * from t_user where name=? and pwd=?";
		Object[] is= {name,pwd};
		ResultSet rs=Util.queryutil(sql, is);
		User user=null;
		while(rs.next()) {
			int id=rs.getInt("id");
			String names=rs.getString("name");
			String pwds=rs.getString("pwd");
			user=new User(id,names, pwds);
			
		}
		return user;
		
	}

	@Override
	public void add(String name, String pwd, String phone, String mail, String address) throws Exception {
		String sql="insert into t_user (name,pwd,phone,mail,address) values('"+name+"','"+pwd+"','"+phone+"','"+mail+"','"+address+"')";
		Util.zsgutil(sql);
	}
	
	

}
