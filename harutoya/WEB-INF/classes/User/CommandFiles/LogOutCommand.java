package User.CommandFiles;

import Main.ResponseContext;
import Main.RequestContext;
import Main.AbstractCommand;

import javax.servlet.http.HttpSession;
import java.util.*;

public class LogOutCommand extends AbstractCommand{


	public ResponseContext execute(ResponseContext resc){
		
		RequestContext reqc = getRequestContext();
		
		reqc.setSessionObject("menutoken",null);
		
		resc.setTarget("menu/menuorderlogout");
		
		return resc;

	}
}