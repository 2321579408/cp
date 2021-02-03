package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;
import com.lanou.dao.IProductDao;
import com.lanou.dao.ProductDaoImpl;

public class ProductServiceImpl implements IProductService{
	
	private IProductDao proDao=new ProductDaoImpl(); 

	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		return proDao.getByPage(pagenum, pagecount) ;
	}

	@Override
	public int count() throws Exception {
		return proDao.count();
	}

	@Override
	public void del(String id) throws Exception {
		proDao.del(id);
	}


	@Override
	public void edit(String id, String pname, String price,String name, String pv, String typeid, String ptitle)
			throws Exception {
		proDao.edit(id, pname, price, name, pv, typeid, ptitle);
	}

	@Override
	public void add(String pname, String pimg, String price, String ptitle, String pv, String typeid) throws Exception {
		proDao.add(pname, pimg, price, ptitle, pv, typeid);
	}

	@Override
	public List<Product> getByTypeid(String typeid) throws Exception {
		return proDao.getByTypeid(typeid);
	}

	@Override
	public List<Product> getByPname(String name) throws Exception {
		return proDao.getByPname(name);
	}



}
