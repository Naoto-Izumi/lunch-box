package Kanrisya.CommandFiles;

import java.util.Map;
import Main.ResponseContext;
import Main.AbstractCommand;

public class SuperKanrisyaCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
	
		resc.setTarget("kanrisya/kanrisya");	//jspを転送
		
		return resc;
	}
}

