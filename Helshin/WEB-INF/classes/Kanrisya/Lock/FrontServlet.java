package Kanrisya.Lock;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class FrontServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
			
			doPost(req,res);//doPostメソッドを呼び出す。
		}
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");	//文字コード指定

		//ApplicationControllerの変数appを
		//WebApplicationControllerにインスタンス化する。
		ApplicationController app = new WebApplicationController();
		
		//RequestContextの変数reqcをApplicationControllerにある変数で
		//getRequest()メソッドを呼び出す。
		RequestContext reqc = app.getRequest(req);
		
		//ReqsponseContextの変数rescをApplicationControllerにある変数で
		//handleRequest()メソッドを呼び出す。
		ResponseContext resc = app.handleRequest(reqc);
		
		resc.setResponse(res);//ResponseContextの変数で値をセットする。
		
		//ApplicationControllerでhandleResponse()メソッドを呼び出す。
		app.handleResponse(reqc,resc);
	}
}
