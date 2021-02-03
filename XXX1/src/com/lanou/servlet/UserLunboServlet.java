package com.lanou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.lanou.bean.Carousel;
import com.lanou.service.CarouselServiceImpl;
import com.lanou.service.ICarouselService;

public class UserLunboServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICarouselService carService=new CarouselServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Carousel> lunbolist=carService.all();
			
			resp.setContentType("text/html;charset=utf-8");//½â¾öÂÒÂë
			PrintWriter pw = resp.getWriter();
			String jsonStr = JSON.toJSONString(lunbolist);
			
			
			
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
