package Kanrisya.Lock;
import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext{
	
	/*�t�B�[���h*/
	private Object result;	//����
	private String target;	//jsp�̏ꏊ
	
	//�C���^�[�t�F�C�X�̎����N���X�̃C���X�^���X���i�[
	private HttpServletResponse response;
	
	//�R���X�g���N�^
	public WebResponseContext(){}		
	/*�Z�b�^�[�E�Q�b�^�[*/
	public void setTarget(String transferInfo){
		
		//jsp�����肷��B
		target="WEB-INF/jsp/"+transferInfo+".jsp";	//�T�[�u���b�g�p�X���擾
	}
	public String getTarget(){
		return target;
	}
	public void setResult(Object bean){
		result = bean;
	}
	public Object getResult(){
		return result;
	}
	public Object getResponse(){
		return response;
	}
	public void setResponse(Object obj){
		response = (HttpServletResponse)obj;
	}
}
