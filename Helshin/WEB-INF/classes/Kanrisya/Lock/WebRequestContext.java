package Kanrisya.Lock;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

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
}
