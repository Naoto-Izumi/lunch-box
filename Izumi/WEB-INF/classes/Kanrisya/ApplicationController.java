package Kanrisya;

public interface ApplicationController{
	//各メソッドをオーバーライドする。
	RequestContext getRequest(Object request);
	ResponseContext handleRequest(RequestContext req);
	void handleResponse(RequestContext req,ResponseContext res);
}
