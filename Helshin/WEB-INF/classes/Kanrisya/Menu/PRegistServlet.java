package Kanrisya.Menu;

//商品の登録

import Kanrisya.Menu.JDBCFiles.RegistJdbc;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PRegistServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		
		String url =RegistJdbc.RegistProduct(req.getParameterMap());

		RequestDispatcher dis=req.getRequestDispatcher(url);
		dis.forward(req,res);
		}
}
