package Kanrisya;

public interface ResponseContext{
	//各メソッドをオーバーライドする。
	public Object getResult();
	public String getTarget();
	public void setTargetCommand(String transferInfo);
	public void setResult(Object bean);
	public void setTarget(String transferInfo);
	public void setResponse(Object obj);
	public Object getResponse();
	public String getResultName();
	public void setResultName(String name);
}



