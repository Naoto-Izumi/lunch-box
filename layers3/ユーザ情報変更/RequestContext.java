package Basic;

public interface RequestContext{
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
	public String getId();
}
