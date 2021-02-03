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
import com.lanou.bean.Type;
import com.lanou.service.ITypeDaoService;
import com.lanou.service.TypeDaoServiceImpl;

public class UserThreeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ITypeDaoService typeService=new TypeDaoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Type> typelist=null;
		try {
			typelist = typeService.getallById();
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			String jsonStr = JSON.toJSONString(typelist);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
