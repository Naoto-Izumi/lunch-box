package Kanrisya;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FrontServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
			doPost(req,res);
			
			String table = req.getParameter("table");
			System.out.println(table);
			
			Connection cn = null;
			Statement smt = null;
			ArrayList oal = new ArrayList();
			
			cn = new OracleConnector("helshin","helshinbox").getCn();
			
			KanrisyaTableReferer tr = new KanrisyaTableReferer(cn,table);
			oal.add(tr.getColumnName());
			
			ResultSet rs = tr.getTableContentsA();
			
			try{
				ResultSetMetaData rsmeta = rs.getMetaData();
				int columnCount = rsmeta.getColumnCount();
				
				while(rs.next()){
					ArrayList ial = new ArrayList();
					for(int i = 1;i<=columnCount; i++){
						ial.add(rs.getString(i));
					}
					oal.add(ial);
				}
				req.setAttribute("list",oal);
			}catch(SQLException e){
				throw new ServletException(e);
			}finally{
				if(smt != null){
					try{
						smt.close();
					}catch(SQLException e){}
				}if(cn != null){
					try{
						cn.close();
					}catch(SQLException e){}
				}
			}
			req.getRequestDispatcher("/kanrisya.jsp").forward(req,res);
		}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("UTF-8");
		
		Map data = req.getParameterMap();
		String[] aaaaa = (String[]) data.get("lastname");
		
			System.out.println(aaaaa[0]);
		
		String path = req.getServletPath();
		AbstractCommand command = CommandFactory.getCommand(path);
		command.init(data);
		
		String url = command.execute();
		
		Object result = command.getResult();
		//req.setAttribute("result",result);
		
		Product pp = new Product();
		
		String a = req.getParameter("lastname");
		//String b = req.getParameter("phone");
		//String c = req.getParameter("mail");
		//String d = req.getParameter("id");
		
		pp.setLname(a);
		pp.setTelphone("b");
		pp.setMail("c");
		pp.setId("d");
		
		Product[] ppp= {pp};
		req.setAttribute("result",ppp);
		//req.setAttribute("product",pp);
		
		//KanrisyaData.OracleKanrisyaData(pp);
		
		RequestDispatcher dis = req.getRequestDispatcher(url);
		dis.forward(req,res);
	}
}
