package Kanrisya.Lock;

public interface ApplicationController{
	//�e���\�b�h���I�[�o�[���C�h����B
	RequestContext getRequest(Object request);
	ResponseContext handleRequest(RequestContext req);
	void handleResponse(RequestContext req,ResponseContext res);
}
