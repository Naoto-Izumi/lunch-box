package Kanrisya.Uriage;

public class PrintWriter{
	private String requestUri;	//年
	private String requestUrl;	//月
	private String pathInfo;	//カウント数
	private String queryString;	//商品名
	private String pathTranslated;	//年
	private String schema;	//月
	private String serverName;	//カウント数
	private String servletPath;	//商品名
	private String contextPath;	//商品名
	
	/*ゲッター*/
	public String getRequestUri(){
		return requestUri;
	}
	public String getRequestUrl(){
		return requestUrl;
	}
	public String getPathInto(){
		return pathInfo;
	}
	public String getQueryString(){
		return queryString;
	}
	public String getPathTranslated(){
		return pathTranslated;
	}
	public String getSchema(){
		return schema;
	}
	public String getServerName(){
		return serverName;
	}
	public String getServletPath(){
		return servletPath;
	}
	public String getContextPath(){
		return contextPath;
	}
	
	/*セッター*/
	public void setRequestUri(String requestUri){
		this.requestUri = requestUri;
	}
	public void setRequestUrl(String requestUrl){
		this.requestUrl = requestUrl;
	}
	public void setPathInto(String pathInfo){
		this.pathInfo = pathInfo;
	}
	public void setQueryString(String queryString){
		this.queryString = queryString;
	}
	public void setPathTranslated(String name){
		this.pathTranslated = pathTranslated;
	}
	public void setSchema(String schema){
		this.schema = schema;
	}
	public void setServerName(String year){
		this.serverName = serverName;
	}
	public void setServletPath(String count){
		this.servletPath = servletPath;
	}
	public void setContextPath(String month){
		this.contextPath = contextPath;
	}
}
