package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;

public interface IProductService {

	public  List<Product> getByPage(int pagenum, int pagecount) throws Exception;
	
	public List<Product> getByTypeid(String typeid) throws Exception;
	
	public int count() throws Exception;
	
	public List<Product> getByPname(String name) throws Exception;
	
	public void del(String id) throws Exception;
	
	public void edit(String id, String name, String price,String pimg, String pv, String typeid, String ptitle) throws Exception;
	
	public void add(String pname,String name,String price,String ptitle,String pv,String typeid) throws Exception;
	
}
