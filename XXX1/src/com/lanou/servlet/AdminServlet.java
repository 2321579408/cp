package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.Util.JSONBean;
import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;

public class AdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAdminDao adminDao=new AdminDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("op");
		if(op==null || op.equals("")){
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				List<Admin> adminlist = adminDao.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, adminDao.getCount(), adminlist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("del")) {
			String id=req.getParameter("id");
			try {
				adminDao.admindel(id);
				JSONBean jb=new JSONBean("200","",null,null);
				PrintWriter pw=resp.getWriter();
				String jbStr=JSON.toJSONString(jb);
				pw.write(jbStr);
				pw.flush();
				pw.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String op=req.getParameter("op");
		String adminname=req.getParameter("adminname");
		String pwd=req.getParameter("pwd");
		
		if(op.equals("add")){
			try {
				adminDao.adminadd(adminname, pwd);
				JSONBean jb=new JSONBean("200","",null,null);
				PrintWriter pw=resp.getWriter();
				String jbStr=JSON.toJSONString(jb);
				pw.write(jbStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("edit")){
			try {
				String id=req.getParameter("id");
				adminDao.adminedit(id, adminname, pwd);
				JSONBean jb=new JSONBean("200","",null,null);
				PrintWriter pw=resp.getWriter();
				String jbStr=JSON.toJSONString(jb);
				pw.write(jbStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
