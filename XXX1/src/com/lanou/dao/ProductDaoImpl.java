package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.bean.User;
import com.lanou.service.ITypeDaoService;
import com.lanou.service.TypeDaoServiceImpl;

public class ProductDaoImpl implements IProductDao{
	
private ITypeDao typDao=new TypeDaoImpl();
	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		List<Product> Productlist=new ArrayList<Product>();
		String sql = "select * from t_product limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String pname=rs.getString("pname");
			String pimg=rs.getString("pimg");
			String price=rs.getString("price");
			String ptitle=rs.getString("ptitle");
			int pv=rs.getInt("pv");
			String typeid=rs.getString("typeid");
			
			Type type1=	typDao.get(Integer.parseInt(typeid));
			
			Type type2=typDao.get(type1.getparentid());
		
			Type type3=typDao.get(type2.getparentid());
			String sss=type3.getTitle()+"-->"+type2.getTitle()+"-->"+type1.getTitle();
			
			Product product=new Product(id, pname, pimg, price, ptitle, pv, sss,typeid);
					Productlist.add(product);
			
		}
		return Productlist;
	}
	
	
	
	
	public int count() throws Exception{
		String sql = "select count(id) count from t_product";
		ResultSet rs=Util.queryutil(sql, null);
		if(rs.next()) {
			return rs.getInt("count");
		}
		return 0;
		
	}

	@Override
	public void del(String id) throws Exception {
		String sql="delete from t_product where id="+id+"";
		Util.zsgutil(sql);
	}

	@Override
	public void edit(String id, String pname, String price,String name, String pv, String typeid, String ptitle) throws Exception {
		String sql="update t_product set pname='"+pname+"' , price='"+price+"' , pv='"+pv+"' , ptitle='"+ptitle+"' , typeid='"+typeid+"',pimg='"+name+"' where id="+id+"";
		Util.zsgutil(sql);
	}

	@Override
	public void add(String pname, String name, String price,String ptitle, String pv, String typeid)
			throws Exception {
		String sql="insert into t_product (pname,pimg,price,ptitle,pv,typeid) values('"+pname+"','"+name+"','"+price+"','"+ptitle+"','"+pv+"','"+typeid+"')";
		Util.zsgutil(sql);
	}




	@Override
	public List<Product> getByTypeid(String typeid) throws Exception {
		
		List<Product> productlist=new ArrayList<Product>();
		String sql="select * from t_product where typeid="+typeid;
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String pname=rs.getString("pname");
			String pimg=rs.getString("pimg");
			String price=rs.getString("price");
			int pv=rs.getInt("pv");
			String ptitle=rs.getString("ptitle");
			Product product=new Product(id, pname, pimg, price, ptitle, pv,typeid);
			productlist.add(product);
		}
		return productlist;
	}




	@Override
	public List<Product> getByPname(String name) throws Exception {
		
		List<Product> prolist=new ArrayList<>();
		String sql="select * from t_product where pname like '%"+name+"%'";
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String price=rs.getString("price");
			String pimg=rs.getString("pimg");
			String ptitle=rs.getString("ptitle");
			String pname=rs.getString("pname");
			int pv=rs.getInt("pv");
			String typeid=rs.getString("typeid");
			Product product=new Product(id, pname, pimg, price, ptitle, pv, typeid);
			prolist.add(product);
		}
		return prolist;
	
	}




}
