package Kanrisya;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
	private Map parameters;
	private HttpServletRequest req;
	public WebRequestContext(){}
	
	public String getCommandPath(){
		String servletPath = req.getServletPath();
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
