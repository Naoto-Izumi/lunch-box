package Main;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import Kanrisya.JDBCFiles.ProductQuery;
import java.util.Enumeration;

public class WebRequestContext implements RequestContext{
	
	/*フィールド*/
	private Map parameters;				//Mapオブジェクトのパラメーター
	
	//インターフェイスの実装クラスのインスタンスを格納
	private HttpServletRequest req;
	
	//コンストラクタ
	public WebRequestContext(){}
	
	/*セッター・ゲッター*/
	public String getCommandPath(){
		
		//サーブレットパスを取得
		String servletPath = req.getServletPath();
		
		//2文字目以降のサーブレットパスを取得
		String commandPath = servletPath.substring(1);
		
		return commandPath;
	}
	public String[] getParameter(String key){
		return (String[])parameters.get(key);
	}
	public Object getRequest(){
		return req;
	}
	public void setRequest(Object request){
		req = (HttpServletRequest) request;
		
		parameters = req.getParameterMap();
	}
	public Map getParameterMap(){
		return parameters;
	}
	
	public String getId(){
		HttpSession session=((HttpServletRequest)req).getSession();
		return (String)session.getAttribute("token");
	}
	public Object getSessionObject(String key){
		HttpSession h=req.getSession();
		
		return h.getAttribute(key);
	}
	/*inport sessionのsessionCommand専用のメソッド*/
	public void setSessionObject(String key,Object obj){
		HttpSession h=req.getSession();
		h.setAttribute(key,obj);
	}
	public void setResult(String key,Object bean){
		req.setAttribute(key,bean);
	}
	public Enumeration getParameterNames(){
		return req.getParameterNames();
	}
	/*sessionを消すメソッド*/
	public void DeleteSession(){
		HttpSession session = req.getSession();
		session.invalidate();
	}
}
