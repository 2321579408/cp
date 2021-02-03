package com.lanou.service;

import java.util.List;

import com.lanou.bean.Carousel;
import com.lanou.dao.CarouselDaoImpl;
import com.lanou.dao.ICarouselDao;

public class CarouselServiceImpl implements ICarouselService {

	private ICarouselDao carDao=new CarouselDaoImpl();
	
	

	@Override
	public void add(String name) throws Exception {
		carDao.add(name);
	}

	@Override
	public List<Carousel> all() throws Exception {
		return carDao.all();
	}

	@Override
	public List<Carousel> getByPage(int pagenum, int pagecount) throws Exception {
		return carDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getcount() throws Exception {
		return carDao.getcount();
	}

	@Override
	public void del(int id) throws Exception {
		carDao.del(id);
	}
	


}
