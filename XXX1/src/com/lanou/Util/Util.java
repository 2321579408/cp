package com.lanou.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


 public class Util{
		private static Connection con=null;
		private static Statement st=null;
		private static ResultSet rs=null;
		private static PreparedStatement ps=null;
		
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://10.10.12.29:3306/ss?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="123456";
			con=DriverManager.getConnection(url, user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2.获取数据库连接
		
	}
	
	//增删改
	public static void zsgutil(String sql) throws Exception {
	      
		st=con.createStatement();	
		st.execute(sql);
	
	}
	
	
	
	//查询
		public static ResultSet queryutil (String sql,Object[] is) throws Exception {
		
		ps=con.prepareStatement(sql);
		if(is!=null&&is.length>0) {
			for(int i=0;i<is.length;i++) {
				ps.setObject(i+1, is[i]);
			}
		}
		rs=ps.executeQuery();
		return rs;
		
				
	}

	
	public static void close() throws Exception {
		if(ps!=null) {
			ps.close();
		}
		if(rs!=null) {
			rs.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	
}
