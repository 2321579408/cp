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
import com.lanou.bean.Product;
import com.lanou.service.IProductService;
import com.lanou.service.ITypeDaoService;
import com.lanou.service.ProductServiceImpl;
import com.lanou.service.TypeDaoServiceImpl;

public class UserTypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IProductService proService= new ProductServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String typeid=req.getParameter("tid");
	
		try {
			List<Product> prolist=	proService.getByTypeid(typeid);
			resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
			PrintWriter pw = resp.getWriter();
			
			JSONBean jb = new JSONBean("0", "",null, prolist);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
