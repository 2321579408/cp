package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.User;


public class UserDaoImpl implements IUserDao{

	@Override
	public List<User> getByPage(int pagenum, int pagecount) throws Exception {

		List<User> userlist=new ArrayList<User>();
		String sql = "select * from t_user limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String pwd=rs.getString("pwd");
			String phone=rs.getString("phone");
			String mail=rs.getString("mail");
			String address=rs.getString("address");
			
			User user=new User(id, name, pwd, phone, mail, address);
			userlist.add(user);
			
		}
		return userlist;
	}

	@Override
	public int getcount() throws Exception {
		
		String sql="select count(id) count from t_user";
		ResultSet rs = Util.queryutil(sql, null);
		if(rs.next()){
			return rs.getInt("count");
		}
		return 0;
	}

	@Override
	public void add(String name,String pwd,String phone,String mail,String address) throws Exception {
			
			String sql="insert into t_user (name,pwd,phone,mail,address) values('"+name+"','"+pwd+"','"+phone+"','"+mail+"','"+address+"')";
			Util.zsgutil(sql);
		
	}

	@Override
	public void del(String id) throws Exception {
		String sql="delete from t_user where id="+id+"";
		Util.zsgutil(sql);
	}

	@Override
	public void update(String id,String name, String pwd, String phone, String mail, String address) throws Exception {
		
		String sql="update t_user set name='"+name+"' , pwd='"+pwd+"' , phone='"+phone+"' , mail='"+mail+"' , address='"+address+"' where id = '"+id+"'";
		Util.zsgutil(sql);
	}
	
	

}
