package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.Util.JSONBean;
import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;

public class AdminLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminDao adminDao=new AdminDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String adminname=req.getParameter("adminname");
		String pwd=req.getParameter("password");
		
		try {
			Admin admin=adminDao.getall(adminname, pwd);
			
			if(admin!=null) {

				JSONBean jb=new JSONBean("0", "", null, admin);
				String jsonStr=JSON.toJSONString(jb);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
