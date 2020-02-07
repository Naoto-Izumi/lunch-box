package Kanrisya.CommandFiles;

import java.util.Map;
import Kanrisya.ResponseContext;
import Kanrisya.AbstractCommand;

public class SuperKanrisyaCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/kanrisya");	//jspを転送
		
		return resc;
	}
}

