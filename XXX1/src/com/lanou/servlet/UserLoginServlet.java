package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.Util.JSONBean;
import com.lanou.bean.Product;
import com.lanou.bean.User;
import com.lanou.service.IProductService;
import com.lanou.service.IUserLoginService;
import com.lanou.service.ProductServiceImpl;
import com.lanou.service.UserLoginServiceImp;
import com.mysql.fabric.xmlrpc.base.Array;

public class UserLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IUserLoginService userService=new UserLoginServiceImp();
	private IProductService proService= new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		
		if(op==null||op.equals("")) {
			
			String name=req.getParameter("username");
			String pwd=req.getParameter("userpwd");
			User user=null;
			try {
				user = userService.login(name, pwd);
				
				if(user!=null) {
					
					
					Cookie c1=new Cookie("name",name);
					Cookie c2=new Cookie("id",user.getId()+"");
					c1.setMaxAge(11111111);
					c2.setMaxAge(11111111);
					resp.addCookie(c1);
					resp.addCookie(c2);
	
					JSONBean jb=new JSONBean("0", "", null, user);
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
		}else if(op.equals("sou")) {
			String name=req.getParameter("shu");
			
			try {
				List<Product> prolist=proService.getByPname(name);
			
				JSONBean jb=new JSONBean("0", "", null, prolist);
				String jsonStr=JSON.toJSONString(jb);
				
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw=resp.getWriter();
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("tuichu")) {
			
			Cookie c1=new Cookie("name","");
			Cookie c2=new Cookie("id","");
			c1.setMaxAge(0);
			c2.setMaxAge(0);
			resp.addCookie(c1);
			resp.addCookie(c2);
			JSONBean jb=new JSONBean("200", "", null, null);
			String jsonStr=JSON.toJSONString(jb);
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw=resp.getWriter();
			pw.write(jsonStr);
			pw.flush();
			pw.close();
	 }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		String pwd=req.getParameter("userpwd");
		String phone=req.getParameter("userphone");
		String mail=req.getParameter("usermail");
		String address=req.getParameter("useraddress");
		
		try {
			userService.add(name, pwd, phone, mail, address);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
