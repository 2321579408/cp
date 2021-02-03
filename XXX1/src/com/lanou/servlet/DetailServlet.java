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
import com.lanou.bean.Cart;
import com.lanou.service.DetailServiceImpl;
import com.lanou.service.IDetailService;

public class DetailServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDetailService detailService = new DetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		try {
			List<Cart> cartlist=detailService.all(uid);
		
			resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
			PrintWriter pw=resp.getWriter();
			String jbStr=JSON.toJSONString(cartlist);
			pw.write(jbStr);
			pw.flush();
			pw.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
