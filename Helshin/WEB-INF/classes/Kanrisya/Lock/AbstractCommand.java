package Kanrisya.Lock;

public abstract class AbstractCommand{
	//RequestContext���i�[����C���X�^���X�ϐ�
	private RequestContext reqContext;
	
	//���Ƃ��Ƃ̓Z�b�^�[�ł��B
	public void init(RequestContext reqc){
		reqContext = reqc;
	}
	public RequestContext getRequestContext(){
		return reqContext;
	}
	
	//��ۃN���X��ResponseContext�^��execute()���\�b�h���I�[�o�[���C�h����B
	public abstract ResponseContext execute(ResponseContext resc);
}
