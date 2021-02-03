package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Type;

public class TypeDaoImpl implements ITypeDao{
	
	
	public List<Type> getallById(int parentid) throws Exception{
		
		List<Type> typelist =new ArrayList<Type>();
		String sql="select * from pro_type where parentid=?";
		Object[] os = {parentid};
		ResultSet rs=Util.queryutil(sql, os);
		while(rs.next()) {
			int id=rs.getInt("id");
			String typename=rs.getString("typename");
			Type type =new Type(id, typename, parentid,null);
			typelist.add(type);
		}
		return typelist;
	}
	
	
	public Type get(int type) throws Exception {
		Type types=null;
		String sql="select * from pro_type where id="+type;
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String title=rs.getString("typename");
			int parentid = rs.getInt("parentid");
			
			types = new Type(id, title, parentid,null);
		}
		return types;
	}

	@Override
	public void update(String id, String title) throws Exception {
		
		String sql="update pro_type set typename='"+title+"' where id='"+id+"'";
		Util.zsgutil(sql);
	}

	@Override
	public void add(String parentid, String title) throws Exception {
		String sql="insert into pro_type (typename,parentid) values('"+title+"','"+parentid+"')";
		Util.zsgutil(sql);
	}

	@Override
	public void del(String id) throws Exception {
		String sql="delete from pro_type where id='"+id+"'";
		Util.zsgutil(sql);
	}


}
