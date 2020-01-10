package Kanrisya.Lock.Main;

public interface ResponseContext{
	//各メソッドをオーバーライドする。
	public Object getResult();
	public String getTarget();
	public void setResult(Object bean);
	public void setTarget(String transferInfo);
	public void setResponse(Object obj);
	public Object getResponse();
}



