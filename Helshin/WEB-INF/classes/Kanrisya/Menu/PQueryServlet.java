package Kanrisya.Menu;

//商品の表示

import Kanrisya.Menu.JDBCFiles.ProductQuery;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class PQueryServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		List ps = ProductQuery.getAllProducts();
		req.setAttribute("product",ps);
		String url = "productdelete.jsp";

		RequestDispatcher dis=req.getRequestDispatcher(url);
		dis.forward(req,res);
		}
}
