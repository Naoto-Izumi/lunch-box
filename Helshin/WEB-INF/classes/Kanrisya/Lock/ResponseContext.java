package Kanrisya.Lock;

public interface ResponseContext{
	//�e���\�b�h���I�[�o�[���C�h����B
	public Object getResult();
	public String getTarget();
	public void setResult(Object bean);
	public void setTarget(String transferInfo);
	public void setResponse(Object obj);
	public Object getResponse();
}



