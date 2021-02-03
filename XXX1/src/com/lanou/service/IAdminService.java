package com.lanou.service;

import java.util.List;

import com.lanou.bean.Admin;

public interface IAdminService {
	
	public Admin getall(String adminname,String pwd) throws Exception;
	
	public  List<Admin> getadmin() throws Exception;
	
	public int getCount() throws Exception;
	
	public void adminadd(String adminname,String pwd) throws Exception;

	public void admindel(String id) throws Exception;

}
