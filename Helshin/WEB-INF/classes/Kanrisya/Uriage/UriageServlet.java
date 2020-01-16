package Kanrisya.Uriage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import java.util.List;
import java.util.ArrayList;

import Kanrisya.Uriage.Beans.PrintWriter;
import Kanrisya.Uriage.Beans.UriageBox;

public class UriageServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		
		String year = req.getParameter("nen");		//年
		String month = req.getParameter("tuki");	//月
		System.out.println(year);					//年を表示
		System.out.println(month);					//月を表示
		
		UriageBox u = new UriageBox();				//Beanファイルをインスタンス化
		
		u.setYear(year);							//年をセット。
		u.setMonth(month);							//月をセット。
		
		//UserDataにある戻り値を受け取る
		List<UriageBox>ppp = UriageData.OracleUriageData(u);
		
		req.setAttribute("uriage",ppp);	//jspにあるitemsからセット
		System.out.println(ppp);
		RequestDispatcher r = req.getRequestDispatcher("/pss");	//url-patternにあるサーブレットパス
		r.forward(req,res);

	}
}
