package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.Admin;

public interface IAdminDao {
	
	public Admin getall(String adminnname,String pwd) throws Exception;
	
	public List<Admin> getadmin() throws Exception;
	
	public int getCount() throws Exception;
	
	public void adminadd(String adminname,String pwd) throws Exception;
	
	public void admindel(String id) throws Exception;

	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception;
	
	public void adminedit(String id,String adminname,String pwd) throws Exception;
}
