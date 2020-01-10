package Kanrisya.Lock.CommandFiles;

import java.util.Map;
import Kanrisya.Lock.Main.ResponseContext;

public class InputProductCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya");	//jspを転送
		
		return resc;
	}
}

