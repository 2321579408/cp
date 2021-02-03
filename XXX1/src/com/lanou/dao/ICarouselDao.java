package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Carousel;

public interface ICarouselDao {
	
	public List<Carousel> getByPage(int pagenum, int pagecount) throws Exception;
	
	public int getcount() throws Exception;
	
	public List<Carousel> all() throws Exception;
	
	public void add(String name) throws Exception;
	
	public void del(int id) throws Exception;
}
