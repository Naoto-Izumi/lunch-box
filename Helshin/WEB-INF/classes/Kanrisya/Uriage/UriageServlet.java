package Kanrisya.Uriage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import java.util.List;
import java.util.ArrayList;

public class UriageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		
		String year = req.getParameter("nen");
		String month = req.getParameter("tuki");
		System.out.println(year);
		System.out.println(month);
		
		UriageBox u = new UriageBox();
		
		u.setYear(year);
		u.setMonth(month);
		
		//UserDataにある戻り値を受け取る
		List<UriageBox>ppp = UriageData.OracleUriageData(u);
		
		req.setAttribute("result",ppp);
		RequestDispatcher r = req.getRequestDispatcher("/helshin2");
		r.forward(req,res);

	}
}
