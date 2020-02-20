package Main;

import java.util.Map;
import java.util.Enumeration;

public interface RequestContext{
	//各メソッドをオーバーライドする。
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
	public Map getParameterMap();
	public String getId();
	public Object getSessionObject(String key);
	public void setSessionObject(String key,Object obj);
	public void setResult(String key,Object bean);
	public Enumeration getParameterNames();
	public void DeleteSession();
}
