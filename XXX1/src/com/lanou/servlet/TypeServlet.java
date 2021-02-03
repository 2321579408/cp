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


public class TypeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITypeDaoService typeService=new TypeDaoServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		
		
		if(op==null||op.equals("")) {
			try {
				List<Type> typelist=typeService.getallById();
				
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				String msg = "";
				JSONBean jb = new JSONBean("0", msg, null, typelist);
				String jsonStr = JSON.toJSONString(jb);
				pw.write(jsonStr);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(op.equals("action")) {
			
			String id=req.getParameter("id");
			String title=req.getParameter("title");
			String parentid=req.getParameter("parentid");
			
			if(id==null||id.equals("")) {
				try {
					typeService.add(parentid, title);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					typeService.update(id, title);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			JSONBean jb = new JSONBean("200", "", null, null);
			String jsonStr = JSON.toJSONString(jb);
			pw.write(jsonStr);
			pw.flush();
			pw.close();
		}else if(op.equals("del")){//ɾ��
			String id=req.getParameter("id");
			try {
				typeService.del(id);
				
				resp.setContentType("text/html;charset=utf-8");//�������
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
