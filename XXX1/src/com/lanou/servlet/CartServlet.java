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
import com.lanou.bean.Cart;
import com.lanou.bean.Product;
import com.lanou.service.CartServiceImpl;
import com.lanou.service.ICartService;

public class CartServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICartService cartService=new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null || op.equals("")){//我们的分页查询
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				List<Cart> carlist = cartService.all(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, cartService.count(), carlist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(op.equals("add")){//我们的分页查询
			String userid=req.getParameter("userid");
			String productid=req.getParameter("productid");
			
				try {
					cartService.add(userid, productid);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		String pid=req.getParameter("id");
	
		if(op.equals("del")) {
			try {
				Cart cart=cartService.queryById(pid);
				
				int id1=cart.getId();
		
				cartService.del(id1);
				PrintWriter pw = resp.getWriter();
				JSONBean jb = new JSONBean("200", "", null, null);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
