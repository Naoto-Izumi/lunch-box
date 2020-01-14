package Kanrisya.Lock.CommandFiles;

import java.util.Map;
import Kanrisya.Lock.ResponseContext;

public class InputProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/kanrisya");	//jspを転送
		
		return resc;
	}
}

