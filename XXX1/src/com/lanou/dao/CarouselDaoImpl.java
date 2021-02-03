package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.Util.Util;
import com.lanou.bean.Admin;
import com.lanou.bean.Carousel;

public class CarouselDaoImpl implements ICarouselDao{

	public List<Carousel> getByPage(int pagenum, int pagecount) throws Exception {
		List<Carousel> Carousellist = new ArrayList<>();
		String sql = "select * from t_Carousel limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = Util.queryutil(sql, null);
		while(rs.next()){
			int id = rs.getInt("id");
			String timg = rs.getString("timg");
			Carousel admin = new Carousel(id, timg);
			Carousellist.add(admin);
		}
		return Carousellist;
	}
	
	public int getcount() throws Exception {
		
		String sql="select count(id) count from t_Carousel";
		ResultSet rs = Util.queryutil(sql, null);
		if(rs.next()){
			return rs.getInt("count");
		}
		return 0;
	}
	
	@Override
	public void add(String name) throws Exception {
		String sql="insert into t_Carousel (timg)values('"+name+"')";
		Util.zsgutil(sql);
	}

	@Override
	public List<Carousel> all() throws Exception {
		
		 List<Carousel> carlist=new ArrayList<>();
		String sql="select * from t_Carousel";
		ResultSet rs=Util.queryutil(sql, null);
		while(rs.next()) {
			int id=rs.getInt("id");
			String timg=rs.getString("timg");
			Carousel carousel = new Carousel(id,timg);
			carlist.add(carousel);
		}
		return carlist;
	}

	@Override
	public void del(int id) throws Exception {
		String sql="delete from t_Carousel where id="+id+"";
		Util.zsgutil(sql);
	}

	
	
}
