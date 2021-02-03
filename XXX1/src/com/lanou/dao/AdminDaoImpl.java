package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Admin;

public class AdminDaoImpl implements IAdminDao {
	
	public Admin getall(String adminname,String pwd) throws Exception {
		
		String sql="select * from t_admin where adminname=? and adminpwd=?";
		Object[] is= {adminname,pwd};
		ResultSet rs=Util.queryutil(sql, is);
		while(rs.next()) {
			int id=rs.getInt("id");
			Admin admin=new Admin(id,adminname,pwd);
			return admin;
		}
		return null;
	}
	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
		List<Admin> adminlist = new ArrayList<>();
		String sql = "select * from t_admin limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = Util.queryutil(sql, null);
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("adminname");
			String pwd = rs.getString("adminpwd");
			Admin admin = new Admin(id, name,pwd);
			adminlist.add(admin);
		}
		rs.close();
		return adminlist;
	}

	@Override
	public List<Admin> getadmin() throws Exception {
		
		List<Admin> adminlist=new ArrayList<Admin>();
		String sql="select * from t_admin";
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String adminname=rs.getString("adminname");
			String pwd=rs.getString("adminpwd");
			Admin admin=new Admin(id,adminname,pwd);
			adminlist.add(admin);
			return adminlist;
		}
		return null;
		
	}
	
	public int getCount() throws Exception{
		String sql = "select count(id) count from t_admin";
		ResultSet rs = Util.queryutil(sql, null);
		if(rs.next()){
			return rs.getInt("count");
		}
		return 0;
	}
	
	public void adminadd(String adminname,String pwd) throws Exception {
		
		String sql="insert into t_admin (adminname,adminpwd) values('"+adminname+"','"+pwd+"')";
		Util.zsgutil(sql);
	}

	@Override
	public void admindel(String id) throws Exception {
		String sql="delete from t_admin where id="+id+"";
		Util.zsgutil(sql);
	}
	@Override
	public void adminedit( String id,String adminname, String pwd) throws Exception {
		String sql="update t_admin set adminname='"+adminname+"' , adminpwd='"+pwd+"' where id='"+id+"'";
		Util.zsgutil(sql);
	}

}
