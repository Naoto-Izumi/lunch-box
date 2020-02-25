package User.CommandFiles;

import Main.AbstractCommand;
import Main.RequestContext;
import Main.ResponseContext;

public class MyPageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext reqc = getRequestContext();
	
		resc.setTarget("user/mypage");
	
		return resc;
	}
}
