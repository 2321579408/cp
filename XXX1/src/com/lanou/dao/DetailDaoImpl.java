package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Cart;

public class DetailDaoImpl implements IDetailDao {

	
	public List<Cart> all(String uid) throws Exception {
		List<Cart> cartlist=new ArrayList<Cart>();
		String sql = "select "
				  +" count(tp.id) count,tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price "
				  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
				        +" left join t_product tp on tc.productid=tp.id where userid="+uid+" GROUP BY productid" ;
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			int count=rs.getInt("count");
			int userid=rs.getInt("userid");
			int productid=rs.getInt("productid");
			String uname=rs.getString("uname");
			String pname=rs.getString("pname");
			String phone=rs.getString("phone");
			String price=rs.getString("price");
			
			
			Cart cart=new Cart(id, userid, uname, productid, pname, phone, price,count);
					
			cartlist.add(cart);
		}
		return cartlist;
	
	}
}
