package com.lanou.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.lanou.Util.JSONBean;
import com.lanou.bean.Admin;
import com.lanou.bean.Carousel;
import com.lanou.service.CarouselServiceImpl;
import com.lanou.service.ICarouselService;

public class LunboServlet extends HttpServlet{
	
	private ICarouselService carService=new CarouselServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Part part=req.getPart("file");
			
			String name=part.getSubmittedFileName();
			String path=req.getServletContext().getRealPath("");
			path=path.substring(0, path.length()-1);
			path=path.substring(0, path.lastIndexOf("\\"));
			path=path+File.separator+"img"+File.separator;
			part.write(path+name);
			System.out.println(path);
			carService.add(name);
			
			PrintWriter pw = resp.getWriter();
			String msg = "";
			JSONBean jb = new JSONBean("0", msg, null, null);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null || op.equals("")){//���ǵķ�ҳ��ѯ
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				List<Carousel> carlist = carService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			
				resp.setContentType("text/html;charset=utf-8");//�������
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, carService.getcount(), carlist);
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
				carService.del(Integer.parseInt(id));
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
