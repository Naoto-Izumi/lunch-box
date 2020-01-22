package Kanrisya.Menu.CommandFiles;

import java.util.Map;
import Kanrisya.Menu.ResponseContext;

public class InputLockUserCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/product");	//jspを転送
		
		return resc;
	}
}

