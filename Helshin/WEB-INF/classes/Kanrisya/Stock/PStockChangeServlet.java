package Kanrisya.Stock;

//	在庫変更

import Kanrisya.Stock.JDBCFiles.ChangeJdbc;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class PStockChangeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		String url = ChangeJdbc.ChangeProduct(req.getParameterMap());
		

		RequestDispatcher dis=req.getRequestDispatcher(url);
		dis.forward(req,res);
		}
}
