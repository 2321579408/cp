package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImpl;



public class TypeDaoServiceImpl implements ITypeDaoService{

	private ITypeDao typeDao=new TypeDaoImpl();
	@Override
	public List<Type> getallById() throws Exception {
		
		List<Type> list1=typeDao.getallById(0);
		
		for(Type t : list1) {
			List<Type> list2=typeDao.getallById(t.getId());
			t.setChildren(list2);
			
			for(Type y : list2) {
				List<Type> list3=typeDao.getallById(y.getId());
				y.setChildren(list3);
			}
		}
		return list1;
	
	}
	
	@Override
	public void update(String id, String title) throws Exception {
		typeDao.update(id, title);
	}

	@Override
	public void add(String parentid, String title) throws Exception {
		typeDao.add(parentid, title);
	}

	@Override
	public void del(String id) throws Exception {
		typeDao.del(id);
	}


}
