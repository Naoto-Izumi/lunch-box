package Kanrisya.Menu;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Kanrisya.Menu.CommandFiles.AbstractCommand;
import Kanrisya.Menu.CommandFiles.CommandFactory;

public class WebApplicationController implements ApplicationController{
	public RequestContext getRequest(Object request){
		
		//インスタンス化
		RequestContext reqc = new WebRequestContext();
		reqc.setRequest(request);
		return reqc;
	}
	public ResponseContext handleRequest(RequestContext req){
		
		/*AbstractCommandの変数commandでCommandFactoryクラスに
		あるgetCommand()メソッドを呼び出す。*/
		AbstractCommand command = CommandFactory.getCommand(req);
		command.init(req);
		
		/*ResponseContextクラスの変数rescで
		AbstractCommandクラスのexecute()メソッドを呼び出す。*/
		ResponseContext resc = command.execute(new WebResponseContext());
		
		return resc;
	}
	public void handleResponse(RequestContext reqc,ResponseContext resc){
		
		//インスタンス化してキャストする。
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpServletResponse res = (HttpServletResponse) resc.getResponse();
		
		//HttpServletRequestクラスの変数でsetAttributeする。
		req.setAttribute("result",resc.getResult());
		
		RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());
		
		try{
			rd.forward(req,res);
		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
