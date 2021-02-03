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
import com.lanou.bean.User;
import com.lanou.service.IUserService;
import com.lanou.service.UserServiceImpl;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		
		if(op==null||op.equals("")) {
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			try {
				List<User> userlist=userService.getByPage(Integer.parseInt(pagenum),Integer.parseInt(pagecount));
				
				resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, userService.getcount(), userlist);
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
				userService.del(id);
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
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String phone=req.getParameter("phone");
		String mail=req.getParameter("mail");
		String address=req.getParameter("address");
		
		if(op.equals("add")) {
			try {
				userService.add(name, pwd, phone, mail, address);
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
				userService.update(id,name, pwd, phone, mail, address);
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
