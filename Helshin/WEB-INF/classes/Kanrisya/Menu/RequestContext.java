package Kanrisya.Menu;

public interface RequestContext{
	//各メソッドをオーバーライドする。
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
}
