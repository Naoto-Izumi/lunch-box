package Kanrisya.Kanrisya;

import Kanrisya.JDBCFiles.UriageData;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.util.List;
//import java.util.ArrayList;

//import Kanrisya.Beans.PrintWriter;
import Kanrisya.Beans.UriageBox;

public class UriageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		//List us = UriageData.OracleUriageData();
		
		String url = "WEB-INF/jsp/kanrisya/kanrisya.jsp";
		
		String year = req.getParameter("nen");		//年
		String month = req.getParameter("tuki");	//月
		System.out.println(year);					//年を表示
		System.out.println(month);					//月を表示
		
		UriageBox u = new UriageBox();				//Beanファイルをインスタンス化
		
		u.setYear(year);							//年をセット。
		u.setMonth(month);							//月をセット。
		
		//UserDataにある戻り値を受け取る
		List<UriageBox>ppp = UriageData.OracleUriageData(u);
		req.setAttribute("kanrisya",ppp);
		
		//req.setAttribute("uriage",ppp);	//jspにあるitemsからセット
		//System.out.println(ppp);
		RequestDispatcher r = req.getRequestDispatcher(url);	//url-patternにあるサーブレットパス
		r.forward(req,res);

	}
}
