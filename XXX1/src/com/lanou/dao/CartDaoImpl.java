package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Cart;

public class CartDaoImpl implements ICartDao{

	@Override
	public List<Cart> all(int pagenum, int pagecount) throws Exception {
			List<Cart> cartlist=new ArrayList<Cart>();
			String sql = "select "
					  +" count(tp.id) count,tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price "
					  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
					        +" left join t_product tp on tc.productid=tp.id GROUP BY productid limit "+(pagenum-1)*pagecount+","+pagecount;
			ResultSet rs=Util.queryutil(sql, null);
			while(rs.next()) {
				int id=rs.getInt("id");
				int userid=rs.getInt("userid");
				int productid=rs.getInt("productid");
				String uname=rs.getString("uname");
				String pname=rs.getString("pname");
				String phone=rs.getString("phone");
				String price=rs.getString("price");
				int count=rs.getInt("count");
				
				
				Cart cart=new Cart(id, userid, uname, productid, pname, phone, price,count);
						
				cartlist.add(cart);
			}
			return cartlist;
		
		}
	

	public int count() throws Exception{
		String sql = "select count(id) count from t_cart";
		ResultSet rs=Util.queryutil(sql, null);
		if(rs.next()) {
			return rs.getInt("count");
		}
		return 0;
	 }


	@Override
	public void add(String userid, String productid) throws Exception {
		String sql="insert into t_cart (userid,productid) values('"+userid+"','"+productid+"')";
		Util.zsgutil(sql);
	 }


	@Override
	public Cart queryById(String pid) throws Exception {
		String sql = "select "
				  +" tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price "
				  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
				        +" left join t_product tp on tc.productid=tp.id where tp.id="+pid;
		ResultSet rs=Util.queryutil(sql, null);
		Cart cart=null;
		if(rs.next()) {
			int id=rs.getInt("id");
			int userid=rs.getInt("userid");
			int productid=rs.getInt("productid");
			String uname=rs.getString("uname");
			String pname=rs.getString("pname");
			String phone=rs.getString("phone");
			String price=rs.getString("price");
			
			cart = new Cart(id,userid, uname, productid, pname, phone, price);
		}
		return cart;
	  }


	@Override
	public void del(int id1) throws Exception {
		String sql="delete from t_cart where id="+id1+"";
		Util.zsgutil(sql);
	}	
	}
