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

import java.util.List;

public class FrontServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");

		Map data = req.getParameterMap();
		String[] aaaaa = (String[]) data.get("lastname");
		System.out.println(aaaaa[0]);
			
		Connection cn = null;	//UserDataと分離
		Statement smt = null;	//UserDataと分離
			
		cn = new OracleConnector("helshin","helshinbox").getCn();	//UserDataと分離
			
		KanrisyaTableReferer tr = new KanrisyaTableReferer(cn,aaaaa[0]);
					
		ResultSet rs = tr.getTableContentsA();	//UserDataと分離
			
		String a = req.getParameter("lastname");
		List<Product> ppp= new ArrayList<Product>();	//UserDataと分離
			
		/*この辺はUserDataと分離*/
		try{
			while(rs.next()){
				Product pr = new Product();
				pr.setLname(rs.getString(2));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				pr.setTelphone(rs.getString(4));	
				pr.setMail(rs.getString(3));		
				pr.setId(rs.getString(1));		
					
				ppp.add(pr);
			}
			req.setAttribute("result",ppp);
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
		req.getRequestDispatcher("/WEB-INF/jsp/kanrisya/kanrisya.jsp").forward(req,res);	//この文は普通のサーブレットに変更
	}
}
