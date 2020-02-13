package Kanrisya.CommandFiles;

import java.util.Map;
import Kanrisya.ResponseContext;
import Kanrisya.AbstractCommand;

public class InputLockUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/user");	//jspを転送
		
		return resc;
	}
}
