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
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImpl;
import com.lanou.service.IProductService;
import com.lanou.service.ProductServiceImpl;

public class ProductServlet extends HttpServlet {
	
	private IProductService proService= new ProductServiceImpl();
	private ITypeDao typeDao=new TypeDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if(op==null || op.equals("")){//我们的分页查询
			String pagenum = req.getParameter("page");
			String pagecount = req.getParameter("limit");
			
			try {
				List<Product> prolist = proService.getByPage(Integer.parseInt(pagenum), Integer.parseInt(pagecount));
			
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, proService.count(), prolist);
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
				proService.del(id);
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
		
		if(op==null||op.equals("")) {
			try {
				Part part=req.getPart("file");
				
				String names=part.getSubmittedFileName();//上传的文件名
				String path=req.getServletContext().getRealPath("");
				path=path.substring(0, path.length()-1);
				path=path.substring(0, path.lastIndexOf("\\"));//截取最后一个“\”之前的内容
				path=path+File.separator+"proimg"+File.separator;
				part.write(path+names);

				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, null, names);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(op.equals("add")) {
			String pname=req.getParameter("pname");
			String name=req.getParameter("nfile");
	
			String price=req.getParameter("price");
			String pv=req.getParameter("pv");
			String typeid=req.getParameter("typeid");
			String ptitle=req.getParameter("ptitle");
			try {
				proService.add(pname, name, price, ptitle, pv, typeid);
				
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
				String pname=req.getParameter("pname");
				String name=req.getParameter("nfile");
				String price=req.getParameter("price");
				String pv=req.getParameter("pv");
				String typeid=req.getParameter("typeid");
				String ptitle=req.getParameter("ptitle");
				proService.edit(id,pname,price,name,pv,typeid,ptitle);
				JSONBean jb=new JSONBean("200","",null,null);
				PrintWriter pw=resp.getWriter();
				String jbStr=JSON.toJSONString(jb);
				pw.write(jbStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("one")) {
			
			try {
				
				List<Type> typelist=typeDao.getallById(0);
				
				String strJson = JSON.toJSONString(typelist);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				pw.write(strJson);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("two")) {
			String id=req.getParameter("parentid");
			
			try {
				
				List<Type> typelist=typeDao.getallById(Integer.parseInt(id));
		
				String strJson = JSON.toJSONString(typelist);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				pw.write(strJson);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("three")) {
			String id=req.getParameter("parentid");
			
			try {
				
				List<Type> typelist=typeDao.getallById(Integer.parseInt(id));
				
				String strJson = JSON.toJSONString(typelist);
				resp.setContentType("text/html;charset=utf-8");//解决乱码
				PrintWriter pw = resp.getWriter();
				pw.write(strJson);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
