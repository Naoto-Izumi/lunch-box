package Kanrisya.Lock;

public interface RequestContext{
	//�e���\�b�h���I�[�o�[���C�h����B
	public String getCommandPath();
	public String[] getParameter(String key);
	public Object getRequest();
	public void setRequest(Object request);
}
