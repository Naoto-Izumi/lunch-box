package Kanrisya.Lock;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class WebRequestContext implements RequestContext{
	
	/*�t�B�[���h*/
	private Map parameters;				//Map�I�u�W�F�N�g�̃p�����[�^�[
	
	//�C���^�[�t�F�C�X�̎����N���X�̃C���X�^���X���i�[
	private HttpServletRequest req;
	
	//�R���X�g���N�^
	public WebRequestContext(){}
	
	/*�Z�b�^�[�E�Q�b�^�[*/
	public String getCommandPath(){
		
		//�T�[�u���b�g�p�X���擾
		String servletPath = req.getServletPath();
		
		//2�����ڈȍ~�̃T�[�u���b�g�p�X���擾
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
