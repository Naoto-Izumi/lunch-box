package Kanrisya.Lock;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebApplicationController implements ApplicationController{
	public RequestContext getRequest(Object request){
		
		//�C���X�^���X��
		RequestContext reqc = new WebRequestContext();
		reqc.setRequest(request);
		return reqc;
	}
	public ResponseContext handleRequest(RequestContext req){
		
		/*AbstractCommand�̕ϐ�command��CommandFactory�N���X��
		����getCommand()���\�b�h���Ăяo���B*/
		AbstractCommand command = CommandFactory.getCommand(req);
		command.init(req);
		
		/*ResponseContext�N���X�̕ϐ�resc��
		AbstractCommand�N���X��execute()���\�b�h���Ăяo���B*/
		ResponseContext resc = command.execute(new WebResponseContext());
		
		return resc;
	}
	public void handleResponse(RequestContext reqc,ResponseContext resc){
		
		//�C���X�^���X�����ăL���X�g����B
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		HttpServletResponse res = (HttpServletResponse) resc.getResponse();
		
		//HttpServletRequest�N���X�̕ϐ���setAttribute����B
		req.setAttribute("result",resc.getResult());
		
		RequestDispatcher rd = req.getRequestDispatcher(resc.getTarget());
		
		try{
			rd.forward(req,res);
		}catch(ServletException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
