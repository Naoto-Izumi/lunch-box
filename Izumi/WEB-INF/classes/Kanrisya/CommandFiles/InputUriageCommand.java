package Kanrisya.CommandFiles;

import java.util.Map;
import Kanrisya.ResponseContext;
import Kanrisya.AbstractCommand;

public class InputUriageCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/kanrisya");	//jspを転送
		
		return resc;
	}
}

